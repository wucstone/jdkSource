package com.wucstone.service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.wucstone.entity.UserEntity;

public interface IMemberService {
	
	@RequestMapping("/getMember")
	public UserEntity getMember(String name);

}
