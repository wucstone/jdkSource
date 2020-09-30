package com.wucstone.spring.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class HelloWorldServiceImpl implements InitializingBean {


	@Resource
	private WorldServiceImpl worldService;

	@PostConstruct
	public void sayHello() {

		System.out.println("PostConstruct");
	}

	public HelloWorldServiceImpl() {
		System.out.println("create"+this.worldService);
		System.out.println("create");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet"+this.worldService);

		System.out.println("afterPropertiesSet");
	}
}
