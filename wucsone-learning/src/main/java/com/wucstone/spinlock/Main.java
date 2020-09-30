package com.wucstone.spinlock;


import org.junit.Test;

import java.util.function.Predicate;

public class Main {

    private volatile boolean flag = true;

    @Test
    public void testMain(){

        Predicate<String> p = o -> "1".equals(o);
        String result = new SpinLockOperator<String>(p, new SpinLockTask<String>() {
            @Override
            public String doTask() {
                System.out.println("0");
                return "0";
            }
        },30000L,3000L).submit();

        System.out.println(result);



    }
}
