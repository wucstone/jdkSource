package com.wucstone.hadoop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HBasedemo {

	String TN = "user";
	
	HBaseAdmin admin;
	HTable htable;
	
	@Before
	public void before() throws Exception {
		Configuration conf = new Configuration();
		// 完全分布式HBase集群  指定ZooKeeper集群地址
		// 伪分布式  单独指定那一台HBase节点
		conf.set("hbase.zookeeper.quorum", "node-wuc-04,node-wuc-02,node-wuc-03");
		
		admin = new HBaseAdmin(conf);
		htable = new HTable(conf, TN);
	}
	
	@After
	public void end() throws Exception {
		if(admin != null) {
			admin.close();
		}
		if(htable != null) {
			htable.close();
		}
	}
	
	@Test
	public void createTable() throws Exception {
		if(admin.tableExists(TN)) {
			admin.disableTable(TN);
			admin.deleteTable(TN);
		}
		
		HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(TN));
		
		HColumnDescriptor cf = new HColumnDescriptor("cf".getBytes());
		cf.setInMemory(true);
		cf.setMaxVersions(1);
		
		desc.addFamily(cf);
		
		admin.createTable(desc);
	}
	
	/**
	 * 添加数据
	 * @throws Exception
	 */
	@Test
	public void put() throws Exception {
		Put put = new Put("1111".getBytes());
		put.add("cf".getBytes(), "name".getBytes(), "xiaoming".getBytes());
		put.add("cf".getBytes(), "age".getBytes(), "31".getBytes());
		
		htable.put(put);
	}
	
	/**
	 *  读取数据  get方式
	 * @throws Exception
	 */
	@Test
	public void getData() throws Exception {
		Get get = new Get("1111".getBytes());
		get.addColumn("cf".getBytes(), "name".getBytes());
		
		Result rs = htable.get(get);
		Cell cell = rs.getColumnLatestCell("cf".getBytes(), "name".getBytes());
		
		System.out.println(new String(CellUtil.cloneValue(cell)));
	}

	
	/**
	 * 十个用户， 每个产生一百条通话记录
	 */
	@Test
	public void insertDB1() throws Exception {
		
		List<Put> puts = new ArrayList<Put>();
		
		for (int i = 0; i < 10; i++) {
			// 自己、用户的手机号码
			String pNum = getPhoneNum("186");
			
			for (int j = 0; j < 100; j++) {
				// 对方手机号
				String dNum = getPhoneNum("177");
				// 通话时间
				String dateStr = getDate("2017");
				// 主叫、被叫类型
				String type = r.nextInt(2) + "";
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				
				
				// rowkey：  手机号_(大数-时间戳)
				String rowkey = pNum + "_" + (Long.MAX_VALUE-sdf.parse(dateStr).getTime());
				
				Put put = new Put(rowkey.getBytes());
				put.add("cf".getBytes(), "dnum".getBytes(), dNum.getBytes());
				put.add("cf".getBytes(), "date".getBytes(), dateStr.getBytes());
				put.add("cf".getBytes(), "type".getBytes(), type.getBytes());
				
				puts.add(put);
			}
		}
		
		htable.put(puts);
	}
	
	
	/**
	 * 查询某个用户 某月 产生的所有通话记录
	 * 
	 * 18678525661 一月份
	 */
	@Test
	public void scanDB2() throws Exception {
		Scan scan = new Scan();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		String startRow = "18678525661_" + (Long.MAX_VALUE - sdf.parse("20170201000000").getTime());
		String stopRow = "18678525661_" + (Long.MAX_VALUE - sdf.parse("20170101000000").getTime());
		
		scan.setStartRow(startRow.getBytes());
		scan.setStopRow(stopRow.getBytes());
		
		ResultScanner rs = htable.getScanner(scan);
		
		for (Result result : rs) {
			System.out.print(new String(CellUtil.cloneValue(result.getColumnLatestCell("cf".getBytes(), "dnum".getBytes()))));
			System.out.print(" - " + new String(CellUtil.cloneValue(result.getColumnLatestCell("cf".getBytes(), "date".getBytes()))));
			System.out.println(" - " + new String(CellUtil.cloneValue(result.getColumnLatestCell("cf".getBytes(), "type".getBytes()))));
		}
	}
	
	/**
	 * 查询某个用户   所有主叫被叫 通话记录
	 * 过滤器
	 * @throws Exception 
	 */
	@Test
	public void scanDB3() throws Exception {
		Scan scan = new Scan();
		
		FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL);
		
		// 前缀过滤器
		PrefixFilter filter1 = new PrefixFilter("18678525661".getBytes());
		list.addFilter(filter1);
		
		// 值过滤器  找到 所有的type=0  主叫的  通话记录
		SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
				"cf".getBytes(), "type".getBytes(), CompareOp.EQUAL, "0".getBytes());
		list.addFilter(filter2);
		
		scan.setFilter(list);
		
		ResultScanner rs = htable.getScanner(scan);
		
		for (Result result : rs) {
			System.out.print(new String(CellUtil.cloneValue(result.getColumnLatestCell("cf".getBytes(), "dnum".getBytes()))));
			System.out.print(" - " + new String(CellUtil.cloneValue(result.getColumnLatestCell("cf".getBytes(), "date".getBytes()))));
			System.out.println(" - " + new String(CellUtil.cloneValue(result.getColumnLatestCell("cf".getBytes(), "type".getBytes()))));
		}
	}
	
	//  练习：  实现 删除某个Cell
	
	Random r = new Random(); 
	
	/**
	 * 随机生成测试手机号码
	 * prefix: 手机号码前缀   eq:186
	 */
	public String getPhoneNum(String prefix) {
		return prefix + String.format("%08d", r.nextInt(99999999));
	}
	
	/**
	 * 随机生成时间
	 * @param year年
	 * @return 时间  格式：yyyyMMddHHmmss
	 */
	public String getDate(String year) {
		return year + String.format("%02d%02d%02d%02d%02d", 
				new Object[]{r.nextInt(12)+1, r.nextInt(28)+1,
				r.nextInt(24), r.nextInt(60), r.nextInt(60)});
	}
}