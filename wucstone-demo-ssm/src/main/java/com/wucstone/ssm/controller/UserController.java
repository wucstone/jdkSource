package com.wucstone.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wucstone.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userServiceImpl;
	
		@RequestMapping("/userLogin")
		@ResponseBody
		public String userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
			
			userServiceImpl.getUserByLogAccount();
			
			return "wewewe";
		}
}
