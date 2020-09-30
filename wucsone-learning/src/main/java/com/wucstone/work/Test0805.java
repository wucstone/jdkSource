package com.wucstone.work;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class Test0805 {

    @Test
    public void testMain()throws Exception{

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        TimerTask task = (timeout) -> {
            Integer a = 1/0;
            System.out.println("task :" + LocalDateTime.now().format(formatter));
        };
        TimerTask task2 = (timeout) -> System.out.println("task :" + LocalDateTime.now().format(formatter));

        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);

        System.out.println("start:" + LocalDateTime.now().format(formatter));
        Timeout timeout = hashedWheelTimer.newTimeout(task, 3, TimeUnit.SECONDS);
        hashedWheelTimer.newTimeout(task2, 4, TimeUnit.SECONDS);
        hashedWheelTimer.newTimeout(task2, 5, TimeUnit.SECONDS);

        while (true){}
    }



}
