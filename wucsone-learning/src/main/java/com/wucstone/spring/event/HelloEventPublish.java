package com.wucstone.spring.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class HelloEventPublish {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message){
        HelloEvent demo = new HelloEvent(this, message);
        applicationEventPublisher.publishEvent(demo);
    }

}
