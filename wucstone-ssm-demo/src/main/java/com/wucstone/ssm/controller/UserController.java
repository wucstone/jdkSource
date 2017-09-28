package com.wucstone.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
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
		
		return "user/userIndex";
	}
	@RequestMapping(value="/getUserList")
	@ResponseBody
	public String getUserList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,String> params=HttpRequestUtil.getParamsByRequest(request);
		Map result=new HashMap();
		
		int total=userService.getUserCountByParams(params);
		List<Map<String,String>> rows=userService.getUserListByParams(params);
		result.put("total",total );
		result.put("rows", rows);
		return JSONUtils.toJSONString(result);
	}
}
