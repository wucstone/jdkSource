package com.wucstone.order.FeignClient;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.wucstone.service.IMemberService;

@FeignClient(value="service.member")
public interface Order2MemberFeignClient extends IMemberService{

}
