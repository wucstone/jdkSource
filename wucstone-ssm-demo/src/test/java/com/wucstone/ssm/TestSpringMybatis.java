package com.wucstone.ssm;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wucstone.ssm.service.UserService;

public class TestSpringMybatis {
	
	@Test
	public void testSpring(){
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) ac.getBean("userService");
		Map<String,String> params=new HashMap<String,String>();
		try {
			params.put("userName", "wuchuang");
			params.put("userAge", "27");
			boolean flag=userService.userLogin(params);
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
