package com.wucstone.spring.amq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wucstone.spring.bean.MailParam;


public class MQProducerTest{
	
	
	public void sendMessageTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		MQProducer mqProducer = (MQProducer) applicationContext.getBean("mqProducer");
		MailParam mail=new MailParam();
		mail.setSendTo("wucstone");
		mail.setSubject("测试activemq");
		mail.setContext("我在测试activemq");
		mqProducer.sendMessage(mail);
	}
}
