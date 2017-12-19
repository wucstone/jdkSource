package com.wucstone.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHDFS {

	FileSystem fs;
	
	Configuration conf;
	
	@Before
	public void getset() throws Exception {
//		System.setProperty("HADOOP_USER_NAME", "hdfs");
		//默认加载/src配置文件 core-site.xml  hdfs-site.xml
		
		conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://mycluster");
		fs = FileSystem.get(conf);
		System.setProperty("HADOOP_USER_NAME", "root");

	}
	
	@After
	public void end() throws Exception  {
		fs.close();
	}
	
	
	
	//查看ls、创建目录mkdir、上传put、下载、删除del
//	@Test
//	public void ls() throws Exception {
//		Path path = new Path("/user/root");
//		FileStatus[] status = fs.listStatus(path);
//		for(FileStatus s : status) {
//			System.err.println(s.getPath());
//			System.err.println(s.getAccessTime());
//			System.err.println(s.getLen());
//			System.err.println(s.getBlockSize());
//		}
//	}
	
	
	@Test
	public void mkdir() throws Exception {
		Path path = new Path("/user/root/mr/input/");
		Boolean flag = fs.mkdirs(path,new FsPermission("777"));
		if(flag) {
			System.out.println("mkdir /user/dir success~~");
		}
	}
//	
//	@Test
//	public void put() throws Exception {
//		Path path = new Path("/user/aaa.txt");
//		FSDataOutputStream out = fs.create(path);
//		IOUtils.copyBytes(new FileInputStream(new File("D:/HDFS/aaa.txt")), out, conf);
//	}
//	
//	@Test
//	public void putsmall() throws Exception {
//	//小文件上传
//		Path path = new Path("/user/bigfile");
//		SequenceFile.Writer write = new SequenceFile.Writer(fs, conf, path, Text.class, Text.class);
//		
//		File[] files = new File("D:/HDFS/").listFiles();
//		for(File f : files) {
//			write.append(new Text(f.getName()), new Text(FileUtils.readFileToString(f)));
//		}
//		write.close();
//	}
//	
//	@Test
//	public void getsmall() throws Exception {
//		Path path = new Path("/user/bigfile");
//		SequenceFile.Reader reader = new SequenceFile.Reader(fs, path, conf);
//		
//		Text key = new Text();
//		Text val = new Text();
//		
//		while(reader.next(key, val)) {
//			System.out.println("111");
//			System.out.println(key.toString());
//			System.out.println(val.toString());
//		}
//	}
//	
//	@Test
//	public void del() throws Exception {
//		Path path = new Path("/user/aaa.txt");
//		fs.delete(path, true);
//	}
}
