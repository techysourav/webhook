package com.wibmo.prepaid.chatboat.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.json.jackson2.JacksonFactory;

@Configuration
public class DemoConfig {
	@Bean
	public JacksonFactory jacksonFactory() {
		return JacksonFactory.getDefaultInstance();
	}

	
	
}
