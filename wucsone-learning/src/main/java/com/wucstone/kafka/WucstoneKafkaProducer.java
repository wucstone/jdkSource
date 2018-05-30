package com.wucstone.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

public class WucstoneKafkaProducer {
	
	private static Producer<String,String> producer=null;
	
	private static Properties props=new Properties();
	
	private static InputStream in=WucstoneKafkaProducer.class.getResourceAsStream("/producer.conf");
	
	public static Producer getInstance() throws IOException {
		props.load(in);
		
		return  new KafkaProducer<String, String>(props);
	}

	
	

}
