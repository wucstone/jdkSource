package com.wucstone.spinlock;


import org.junit.Test;

import java.util.function.Predicate;

public class Main {

    private volatile boolean flag = true;
    private Integer cnt = 0;

    @Test
    public void testMain(){

        Predicate<String> p = o -> o == null;
        String result = new SpinLockOperator<String>(p, new SpinLockTask<String>() {
            @Override
            public String doTask() {

                if(cnt++ == 1000){
                    System.out.println("1");
                    return null;
                }else{
                    System.out.println("0");
                    return "0";
                }
            }
        },300L,3000L).submit();

        System.out.println(result);

        while(true){}


    }
}
