package com.wucstone.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wucstone.api.order.service.IOrderService;
import com.wucstone.entity.UserEntity;
import com.wucstone.order.FeignClient.Order2MemberFeignClient;

@RestController
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private Order2MemberFeignClient order2MemberFeignClient;


	//未解决服务雪崩效应
	@RequestMapping("/getMemberFromOrderService")
	public String getMemberFromOrderService(String name) {
		
		UserEntity user = order2MemberFeignClient.getMember(name);
		return user.getName()+"--"+user.getAge()+"--"+Thread.currentThread().getName();
		
	}
	/**
	 * @HystrixCommand 通过服务熔断/服务降级/服务隔离的方法解决雪崩效应
	 * @param name
	 * @return
	 */
	@HystrixCommand(fallbackMethod="fallBackGetMemberFromOrderServiceHystrix")
	@RequestMapping("/getMemberFromOrderServiceHystrix")
	public String getMemberFromOrderServiceHystrix(String name){
		
		UserEntity user = order2MemberFeignClient.getMember(name);
		return user.getName()+"--"+user.getAge()+"--"+Thread.currentThread().getName();
	}

	public String fallBackGetMemberFromOrderServiceHystrix(String name){
		return "现在是服务降级"+"--"+name+"--"+Thread.currentThread().getName();
	}
}
