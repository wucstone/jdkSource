package com.wucstone.api.order.service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {
	
	@RequestMapping("/getMemberFromOrderService")
	public String getMemberFromOrderService(String name);

}
