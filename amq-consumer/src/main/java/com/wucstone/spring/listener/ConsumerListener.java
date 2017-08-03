package com.wucstone.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerListener implements MessageListener{

	public void onMessage(Message message) {
	       if(message instanceof TextMessage){
				TextMessage tm = (TextMessage) message;
				try {
					System.out.println("监听器内接收的信息"+tm.getText());
//					MailParam mail=(MailParam) JSONObject.parse(tm.getText());
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}


}
