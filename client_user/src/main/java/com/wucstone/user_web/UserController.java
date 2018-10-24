package com.wucstone.user_web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wucstone.intf.IUserService;

@RestController
public class UserController {
	
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/hello")
	public String hello(){
		
		return "hello world";
	}
	
	@RequestMapping("/getByServerId")
	public List<ServiceInstance> getByServerId(){
		return discoveryClient.getInstances("service.order");
	}
	
	@GetMapping(value = "/getOrderService")
	public String getOrderSrvice(){
		return restTemplate.getForObject("http://service.order/getOrderService", String.class);
	}
	
	@GetMapping(value = "/feignGetOrderService")
	public String feignGetOrderService(){
		return userService.getOrderService();
	}
}
