/**
 * 
 */
package com.ashu.sbt.micro.service.msg.cmp;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Component
public class JMSSender {

	@Autowired
	JmsTemplate jmsTemplate;

//	public void sendMessage(final String queue, final Object data) {
//		jmsTemplate.convertAndSend(queue, data);
//	}

	public void sendMessage(final String queueName, final String data) {
		Map<?, ?> map = new Gson().fromJson(data, Map.class);
		final String textMessage = "Hello " + map.get("name");
		System.out.println("Sending message " + textMessage + " to queue - " + queueName);
		jmsTemplate.send(queueName, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setText(data);
				return message;
			}
		});
	}
}
