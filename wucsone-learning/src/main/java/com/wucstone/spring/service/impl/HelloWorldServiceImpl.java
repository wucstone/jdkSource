package com.wucstone.spring.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wucstone.spring.event.HelloEventPublish;
import com.wucstone.spring.service.HelloWorldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {


	@Resource
	private HelloEventPublish helloEventPublish;

	@Override
	public String sayHello(String name) {

		System.out.println("HelloWorldServiceImpl,thread----" + Thread.currentThread().getName());
		helloEventPublish.publish(name);
		return "Hello ".concat(name);
	}
}
