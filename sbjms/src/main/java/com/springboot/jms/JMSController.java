package com.springboot.jms;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jms")
public class JMSController {

	private Logger log = LoggerFactory.getLogger(JMSController.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private JMSService jmsService;
	
	@Value("${config1.property}")
	private String config1;
	
	@Value("${config2.property}")
	private String config2;

	@GetMapping(value = "/query", produces = "application/json")
	public ResponseEntity<List<Post>> query() {
		try {
			log.debug("[Config1="+config1+", Config2="+config2+"]");
			log.info("Retrieving posts...");
			List<Post> result = jmsService.getPost();

			return new ResponseEntity<List<Post>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Post>>(new ArrayList<Post>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/post")
	public void send(@RequestBody Post post) {
		log.info("Sending a post...");
		// Post message to the message queue named 'PostMessageQueue'
		PostEntity entity = new PostEntity();
		entity.setMessage(post.getMessage());
		jmsTemplate.convertAndSend("PostMessageQueue", entity);
	}

}
