/**
 * 
 */
package com.ashu.sbt.micro.service.msg.cmp;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Component
public class SampleReceiverSender {
	private Logger logger = LoggerFactory.getLogger(SampleReceiverSender.class);

	@JmsListener(destination = "ashu.in.queue")
	@SendTo("ashu.out.queue")
	public String receiveMessage(final Message jsonMessage) throws JMSException {
		logger.info(" >>  Received Payment: " + jsonMessage);
		String response = null;
		if (jsonMessage instanceof TextMessage) {
			response = ((TextMessage) jsonMessage).getText();
			Map<?, ?> map = new Gson().fromJson(response, Map.class);
			logger.info(" >>  Received Payment: " + map);
		}
		return response;
	}
}
