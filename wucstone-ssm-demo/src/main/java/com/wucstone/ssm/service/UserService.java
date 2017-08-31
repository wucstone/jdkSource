package com.wucstone.ssm.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	Boolean userLogin(Map<String, String> params)throws Exception;

	int getUserCountByParams(Map<String, String> params)throws Exception;

	List<Map<String, String>> getUserListByParams(Map<String, String> params)throws Exception;

}
