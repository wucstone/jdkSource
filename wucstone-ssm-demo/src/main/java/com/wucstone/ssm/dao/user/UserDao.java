package com.wucstone.ssm.dao.user;

import java.util.List;
import java.util.Map;

public interface UserDao {

	void insertUserInfo(Map userInfo)throws Exception;

	Map<String, String> getUserInfoByParams(Map<String, String> params)throws Exception;

	int getUserCountByParams(Map<String, String> params)throws Exception;

	List<Map<String, String>> getUserListByParams(Map<String, String> params)throws Exception;
}
