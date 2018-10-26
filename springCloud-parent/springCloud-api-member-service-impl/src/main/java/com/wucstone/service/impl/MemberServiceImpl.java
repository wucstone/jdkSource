package com.wucstone.service.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wucstone.entity.UserEntity;
import com.wucstone.service.IMemberService;

@RestController
public class MemberServiceImpl implements IMemberService{

	@RequestMapping("/getMember")
	public UserEntity getMember(String name) {
		
		UserEntity entity = new UserEntity();
		entity.setName(name);
		entity.setAge(28);
		
		try {
			Thread.sleep(5500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return entity;
	}

}
