package com.wucstone.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHDFS {
	
	Configuration conf=null;
	FileSystem fs=null;
	@Before
	public void getset() throws Exception {
//		System.setProperty("HADOOP_USER_NAME", "hdfs");
		//默认加载/src配置文件 core-site.xml  hdfs-site.xml
		conf= new Configuration(true);
		conf.set("fs.defaultFS", "hdfs://mycluster");
		fs= FileSystem.get(conf);
	}
	
	@After
	public void end() throws Exception  {
		fs.close();
	}
	
	@Test
	public void del() throws Exception {
		Path path1 = new Path("/user/root/mr/output/out");
		fs.delete(path1, true);
		Path path2 = new Path("/user/root/mr/output");
		fs.delete(path2, true);
	}

}
