package com.wucstone.work;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class Test1105 {

    @Test
    public void testMain()throws Exception{

        int total = 500;
        int size = 500;
        int i = 0;
        while(total == size){
            i++;

            if(i==10){
                total = 200;
            }else{
                total = 500;
            }
            System.out.println(i+"-------"+total);
        }

    }



}
