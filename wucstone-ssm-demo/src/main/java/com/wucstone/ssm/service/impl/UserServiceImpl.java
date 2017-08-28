package com.wucstone.ssm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wucstone.ssm.dao.UserDao;
import com.wucstone.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public Boolean userLogin(Map<String, String> params) throws Exception {
		
		Map<String,String> userInfo=userDao.getUserInfoByParams(params);
		if(params.get("userAge").equals(userInfo.get("userAge"))){
			return true;
		}else{
			return false;
		}

	}

}
