package com.wucstone.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {


	@Resource
	private HelloWorldService helloWorldService;

	    @RequestMapping("/helloWorld")
	    public void helloWorld(@RequestParam(value="name", defaultValue="World") String name) throws Exception {
	    	helloWorldService.packageParams("1111",null);
	    }

}
