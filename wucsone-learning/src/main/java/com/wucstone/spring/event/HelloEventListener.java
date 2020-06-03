package com.wucstone.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HelloEventListener implements ApplicationListener<HelloEvent> {
    @Override
    public void onApplicationEvent(HelloEvent helloEvent) {

        System.out.println("HelloEventListener,thread----" + Thread.currentThread().getName());
        System.out.println("hello--------------"+helloEvent.getMessage());

    }
}
