package com.wucstone.ssm.dao;

import java.util.Map;

public interface UserDao {

	void insertUserInfo(Map userInfo);

	Map<String, String> getUserInfoByParams(Map<String, String> params);
}
