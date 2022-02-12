package com.ashu.sbt.micro.service.msg;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import com.ashu.sbt.micro.service.msg.bean.Order;
import com.ashu.sbt.micro.service.msg.cmp.JMSSender;

@SpringBootApplication
@EnableJms
@EnableEurekaClient
@RefreshScope
public class JmsWithAmqApplication {
	private static Logger logger = LoggerFactory.getLogger(JmsWithAmqApplication.class);
	private static AtomicInteger id = new AtomicInteger();

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = 
				SpringApplication.run(JmsWithAmqApplication.class, args);
		// JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		JMSSender jmsSender = context.getBean(JMSSender.class);
		// Send an user
		System.out.println("Sending an user message.");
		jmsSender.sendMessage("ashu.in.queue", 
				(new Order(id.decrementAndGet(), "XENOS", 120, 99999999.99)).toString());
		jmsSender.sendMessage("ashu.out.queue", 
				(new Order(id.decrementAndGet(), "NAM", 120, 99999999.99)).toString());
		jmsSender.sendMessage("ashu.in.queue", 
				(new Order(id.decrementAndGet(), "SOPHIS", 120, 99999999.99)).toString());;
		jmsSender.sendMessage("ashu.out.queue", 
				(new Order(id.decrementAndGet(), "IAPPS", 120, 99999999.99))
				.toString());
		jmsSender.sendMessage("ashu.in.queue", 
				(new Order(id.decrementAndGet(), "PLS", 120, 99999999.99)).toString());

		logger.info("Waiting for user and confirmation ...");
		System.in.read();
		context.close();
	}

}
