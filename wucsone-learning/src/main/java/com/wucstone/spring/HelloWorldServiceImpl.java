package com.wucstone.spring;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloWorldServiceImpl extends HelloWorldService{

	public Map map = new HashMap();

	public HelloWorldServiceImpl() {
		map.put("1111",this);
	}


	@Override
	protected String packageParams(String merchant, Map data) {

		System.out.println("1234567890-="+ JSONObject.toJSONString(data));
		return null;
	}
}
