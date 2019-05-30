package com.springboot.jms;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JMSService {

	private Logger log = LoggerFactory.getLogger(JMSService.class);
	
	@Autowired
	private JMSRepository jmsRepository;
	
	public List<Post> getPost() {
		log.info("Inside getPost() method...");
		List<Post> posts = new ArrayList<Post>();
		Post post = null;
		for(PostEntity entity:jmsRepository.findAll()) {
			post = new Post();
			post.setId(entity.getId().toString());
			post.setMessage(entity.getMessage());
			posts.add(post);
		}
		return posts;
	}
	
}
