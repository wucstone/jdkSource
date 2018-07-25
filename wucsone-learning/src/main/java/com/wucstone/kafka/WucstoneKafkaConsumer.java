package com.wucstone.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class WucstoneKafkaConsumer {
	
	private WucstoneKafkaConsumer() {
	}

	public static KafkaConsumer getInstance() throws IOException{

		Properties props=new Properties();
		InputStream in=WucstoneKafkaConsumer.class.getResourceAsStream("/consumer.conf");
		props.load(in);
		
		KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(props);
		
		return consumer;
	}
	
}
