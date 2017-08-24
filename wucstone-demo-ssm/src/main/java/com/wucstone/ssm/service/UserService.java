package com.wucstone.ssm.service;

import com.wucstone.ssm.bean.UserInfo;

public interface UserService {

	UserInfo getUserByLogAccount()throws Exception;
}
