package com.way.jms.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService {

	@Autowired
	JmsTemplate jmsTemplate;
	
	
	//队列模式
/*	@Resource(name="queueDestination")
	Destination destination;*/
	
	//主题模式
	
	@Resource(name="topicDestination")
	Destination destination;
	
	
	
	public void sendMessage(final String message) {
		// TODO Auto-generated method stub
		
		//使用JmsTemplate发送消息
		jmsTemplate.send(destination, new MessageCreator() {
			//创建一个消息
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				
				
				TextMessage textMessage = session.createTextMessage(message);
				
				return textMessage;
			}
		});
		
		System.out.println("发送消息"+message);
	}

}
