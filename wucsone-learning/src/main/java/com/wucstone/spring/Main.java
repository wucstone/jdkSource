package com.wucstone.spring;

import com.wucstone.spring.service.impl.HelloWorldServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorldServiceImpl bean = ac.getBean(HelloWorldServiceImpl.class);
        System.out.println(bean);
    }
}
