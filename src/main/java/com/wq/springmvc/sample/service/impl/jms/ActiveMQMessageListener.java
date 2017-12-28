package com.wq.springmvc.sample.service.impl.jms;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageListener implements MessageListener {

	@Autowired
	private AtomicInteger count = null;

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMsg = (TextMessage) message;
				System.out.println("Received message from Destination : " + txtMsg.getText());
				count.incrementAndGet();
			}
		} catch (JMSException e) {
			
		}
	}
}
