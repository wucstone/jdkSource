package com.wucstone.ssm.service;

import java.util.Map;

public interface UserService {

	Boolean userLogin(Map<String, String> params)throws Exception;

}
