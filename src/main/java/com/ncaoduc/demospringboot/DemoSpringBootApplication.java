package com.ncaoduc.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoSpringBootApplication.class, args);
	}

}
