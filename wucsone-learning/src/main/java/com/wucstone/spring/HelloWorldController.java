package com.wucstone.spring;

import com.wucstone.spring.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {


	@Resource
	private HelloWorldService helloWorldService;

	    @PostMapping("/helloWorld")
	    public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) throws Exception {

			System.out.println("HelloWorldController,thread----" + Thread.currentThread().getName());
			return helloWorldService.sayHello(name);
	    }

}
