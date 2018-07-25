package com.wucstone.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCounterd'd'd'd{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		
		Configuration conf=new Configuration(true);
		
		Job job=Job.getInstance(conf);
		
	     job.setJarByClass(WordCounter.class);
	     
	     // Specify various job-specific parameters     
	     job.setJobName("wordCounter");
	     
//	     job.setInputPath(new Path("in"));
//	     job.setOutputPath(new Path("out"));
	     
	     Path input = new Path("/user/root/mr/input/");
	     FileInputFormat.addInputPath(job, input);
	     Path output = new Path("/user/root/mr/output");
	     if(output.getFileSystem(conf).exists(output)){
	    	 output.getFileSystem(conf).delete(output,true);
	     }
	     FileOutputFormat.setOutputPath(job, output);
	     
	     job.setMapperClass(MyMapper.class);
	     job.setMapOutputKeyClass(Text.class);
	     job.setMapOutputValueClass(IntWritable.class);
	     
	     job.setReducerClass(MyReducer.class);

	     // Submit the job, then poll for progress until the job is complete
	     job.waitForCompletion(true);

		
		
		
		
	}

}
