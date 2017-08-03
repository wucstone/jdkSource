package com.wucstone.spring.amq;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MQConsumerTest{
	
	
	@Test
	public void receiveMessageTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		while(true){
			
		}
	}
}
