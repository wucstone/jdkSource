package com.wucstone.ssm.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	List<Map<String, String>> getUserListByParams(Map<String, String> params);

	void insertUserInfo(Map<String, String> map);

}
