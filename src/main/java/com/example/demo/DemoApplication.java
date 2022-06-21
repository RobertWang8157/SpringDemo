package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//(exclude=HibernateJpaAutoConfiguration.class)
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
@EnableTransactionManagement


public class DemoApplication extends SpringBootServletInitializer{
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(DemoApplication.class);
	    }
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		

	}

}
