package com.wucstone.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wucstone.entity.UserEntity;

public interface IMemberService {
	
	@RequestMapping("/getMember")
	public UserEntity getMember(@RequestParam("name")String name);

}
