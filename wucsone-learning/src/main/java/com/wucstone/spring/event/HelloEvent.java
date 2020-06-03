package com.wucstone.spring.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class HelloEvent extends ApplicationEvent {

    @Getter
    private String message;

    public HelloEvent(Object source,String message) {
        super(source);
        this.message = message;
    }

}
