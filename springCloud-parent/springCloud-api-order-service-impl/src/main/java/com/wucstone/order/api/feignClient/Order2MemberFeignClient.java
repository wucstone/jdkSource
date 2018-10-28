package com.wucstone.order.api.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.wucstone.order.api.fallBack.Order2MemberFallback;
import com.wucstone.service.IMemberService;

@FeignClient(value="service.member",fallback=Order2MemberFallback.class)
public interface Order2MemberFeignClient extends IMemberService{

}
