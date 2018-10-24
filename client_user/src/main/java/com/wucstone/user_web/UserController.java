package com.wucstone.user_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	
	
	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/hello")
	public String hello(){
		
		
		return "hello world";
	}
	
	@GetMapping(value = "/getOrderSrvice")
	public String getOrderSrvice(){
		return restTemplate.getForObject("http://service.order/getOrder", String.class)+"--"+serverPort;
	}
}
