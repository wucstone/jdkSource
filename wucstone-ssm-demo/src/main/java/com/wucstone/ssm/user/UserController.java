package com.wucstone.ssm.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

		@RequestMapping("/userLogin")
		@ResponseBody
		public String userLogin(HttpServletRequest request,HttpServletResponse response){
			return "wewewe";
		}
}
