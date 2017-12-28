package com.wq.springmvc.sample.service.impl.jms;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageProducer {
	
	protected static final String MSG_COUNT = "messageCount";
	
	@Autowired
	private JmsTemplate jmsTemplate = null;

	@PostConstruct
	public void generateMessages() throws JMSException {
		
		final int messageCount = 100;
			
		final String text = "TP Message " + messageCount;
		
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(text);
				textMessage.setIntProperty(MSG_COUNT, messageCount);
				
				return textMessage;
			}
		});
		
	}
}
