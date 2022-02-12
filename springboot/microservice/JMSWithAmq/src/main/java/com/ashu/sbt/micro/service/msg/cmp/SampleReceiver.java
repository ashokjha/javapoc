/**
 * 
 */
package com.ashu.sbt.micro.service.msg.cmp;


import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Component
public class SampleReceiver {
	private Logger logger = LoggerFactory.getLogger(SampleReceiver.class);


	@Autowired
	JMSSender msgSender;


	@JmsListener(destination = "ashu.out.queue")
	public void receiveMessage(final Message jsonMessage) throws JMSException {
		logger.info(" >>  Received from Payment: " + jsonMessage);
	}
	
}
