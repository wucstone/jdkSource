package com.wucstone.kafka;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

public class KafkaTest {
	
	@Test
	public void testProducer() throws IOException, InterruptedException, ExecutionException{
		
//		Consumer<String, String> consumer=WucstoneKafkaConsumer.getInstance();
		Producer<String, String> producer=WucstoneKafkaProducer.getInstance();
		
			 
			 
			 
	     Future<RecordMetadata> result = null;
	     
	     for (int i = 10000; i < 10100; i++) {
	    	 result= producer.send(new ProducerRecord("topic2", "测试数据丢失"+i));
	    	 System.out.println("partition="+result.get().partition()+",offset="+result.get().offset());
		 }
		 producer.close();
		
	}
	
	@Test
	public void testConsumer() throws IOException{
		
		Consumer<String, String> consumer=WucstoneKafkaConsumer.getInstance();
		
		consumer.subscribe(Collections.singletonList("mytopic"));

        System.out.println("Subscribed to topic " + "mytopic");
        int i = 0;

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1);
            for (ConsumerRecord<String, String> record : records)

                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s, partition = %s\n",
                        record.offset(), record.key(), record.value(),record.partition());
        }
		
	}

}
