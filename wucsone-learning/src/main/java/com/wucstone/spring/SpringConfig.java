package com.wucstone.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("com.wucstone.spring")
@EnableAsync
public class SpringConfig {

}
