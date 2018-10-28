package com.wucstone.order.api.fallBack;

import org.springframework.stereotype.Component;

import com.wucstone.entity.UserEntity;
import com.wucstone.order.api.feignClient.Order2MemberFeignClient;

@Component
public class Order2MemberFallback implements Order2MemberFeignClient{

	@Override
	public UserEntity getMember(String name) {
		
		UserEntity user = new UserEntity();
		user.setName("以类的方式实现服务降级");
		
		
		return user;
	}

}
