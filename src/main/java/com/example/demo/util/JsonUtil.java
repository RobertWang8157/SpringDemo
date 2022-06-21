package com.example.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class JsonUtil {
	@Bean
	public Gson getGsonObj() {		
		return new Gson();		
	}
}
