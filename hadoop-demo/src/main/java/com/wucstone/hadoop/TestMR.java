package com.wucstone.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TestMR {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		
		Configuration conf=new Configuration(true);
		
		Job job=Job.getInstance(conf);
		
	     job.setJarByClass(TestMR.class);
	     
	     // Specify various job-specific parameters     
	     job.setJobName("TestMR");
	     
//	     job.setInputPath(new Path("in"));
//	     job.setOutputPath(new Path("out"));
	     
	     FileInputFormat.addInputPath(job, new Path("/user/root/mr/input"));
	     FileOutputFormat.setOutputPath(job, new Path("/user/root/mr/output"));
	     
	     job.setOutputKeyClass(Text.class);
	     job.setOutputValueClass(IntWritable.class);
	     
	     
	     job.setMapperClass(MRMapper.class);
	     job.setReducerClass(MRReducer.class);

	     // Submit the job, then poll for progress until the job is complete
	     job.waitForCompletion(true);

		
		
		
		
	}

}
