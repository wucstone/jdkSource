package com.wucstone.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return user.getName()+"--"+user.getAge();
		
	}

}
