package com.wucstone.spring.amq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.wucstone.spring.bean.MailParam;

@Service("mqProducer")
public class MQProducer{
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination;

	public void sendMessage(final MailParam mail){
		jmsTemplate.send(destination,new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(mail));
			}
		});
	}
}
