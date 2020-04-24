package com.wucstone.lambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class TestConsumer {


    private static volatile ConcurrentHashMap<String,Boolean> map = new ConcurrentHashMap();
    public static void main(String[] args) {
        map.put("flag",true);
        Executors.newScheduledThreadPool(10).schedule(new Runnable() {
            @Override
            public void run() {
                map.put("flag",false);
            }
        },10, TimeUnit.SECONDS);
        while(map.get("flag")){
            System.out.println("........");
        }
    }

}
