package com.wucstone.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@RequestMapping("/getMenus")
	public String getMenus(HttpServletRequest request,HttpServletResponse response){

		
		return null;
	}

}
