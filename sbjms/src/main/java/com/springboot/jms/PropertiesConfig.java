package com.springboot.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource("classpath:config/config1.properties"),
    @PropertySource("classpath:config/config2.properties")
})
public class PropertiesConfig {

	private static Logger log = LoggerFactory.getLogger(PropertiesConfig.class);
	
	public PropertiesConfig() {
		log.info("Loading up custom properties files...");
	}
	
}
