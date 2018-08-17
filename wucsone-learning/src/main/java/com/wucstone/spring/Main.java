package com.wucstone.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

	
    public static void main(String[] args) {

    	AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        SpringApplication.run(Main.class, args);
    }
}
