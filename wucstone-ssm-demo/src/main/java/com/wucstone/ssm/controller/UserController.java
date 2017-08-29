package com.wucstone.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wucstone.ssm.service.UserService;
import com.wucstone.ssm.util.HttpRequestUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;


	@RequestMapping("/userLogin")
	@ResponseBody
	public String userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,String> params=HttpRequestUtil.getParamsByRequest(request);
		
		Boolean flag=userService.userLogin(params);
		if(flag){
			return "index";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/userIndex")
	public String userIndex(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		return "/user/index";
	}
}
