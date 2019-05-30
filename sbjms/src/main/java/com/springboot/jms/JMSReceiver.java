package com.springboot.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSReceiver {

	private static Logger log = LoggerFactory.getLogger(JMSReceiver.class);
	
	@Autowired
	private JMSRepository jmsRepository;

	@JmsListener(destination = "PostMessageQueue", containerFactory = "jmsFactory")
	public void receiveMessage(PostEntity entity) {
		log.info("Received <" + entity + ">");
		jmsRepository.save(entity);
	}
}
