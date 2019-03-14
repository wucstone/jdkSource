package com.wucstone.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wucstone.ssm.dao.user.UserDao;
import com.wucstone.ssm.mapper.UserMapper;
import com.wucstone.ssm.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;
	
//	@Autowired
//	private UserMapper userMapper;

	public Boolean userLogin(Map<String, String> params) throws Exception {
		
		Map<String,String> userInfo=userDaoImpl.getUserInfoByParams(params);
		if(params.get("userAge").equals(userInfo.get("userAge"))){
			return true;
		}else{
			return false;
		}

	}

	public int getUserCountByParams(Map<String, String> params)throws Exception {
		return userDaoImpl.getUserCountByParams(params);
	}

	public List<Map<String, String>> getUserListByParams(Map<String, String> params) throws Exception {
		
//		return userMapper.getUserListByParams(params);
		return userDaoImpl.getUserListByParams(params);
	}

}
