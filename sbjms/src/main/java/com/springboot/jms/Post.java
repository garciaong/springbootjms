package com.springboot.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName(value = "post_message")
public class Post {
	
	@JsonProperty("post_id")
	private String id;
	@JsonProperty("post_content")
	private String message;
	
}
