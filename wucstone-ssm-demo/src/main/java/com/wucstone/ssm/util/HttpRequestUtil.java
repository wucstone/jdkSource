package com.wucstone.ssm.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtil {
	
	public static Map<String,String> getParamsByRequest(HttpServletRequest request){
		Map<String,String> result=new HashMap<String, String>();
		Enumeration<String> ens = request.getParameterNames();
		while(ens.hasMoreElements()){
			String node=ens.nextElement();
			result.put(node, request.getParameter(node));
		}
		return result;
	}

}
