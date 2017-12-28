package com.wq.springmvc.sample;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wq.springmvc.sample.service.impl.jms.ActiveMQMessageProducer;

@Component
public class ProducerConsumerTest {
	
	@Autowired  
    private ActiveMQMessageProducer activeMQMessageProducer;
	
    public void testSend() throws JMSException {  
        activeMQMessageProducer.generateMessages();  
    }  
}
