package com.wucstone.spinlock;


import org.junit.Test;

import java.util.function.Predicate;

public class Main {

    private volatile boolean flag = true;

    @Test
    public void testMain(){

        Predicate p = o -> o!= null;
        String result = new SpinLockOperator<String>(p, new SpinLockTask<String>() {
            @Override
            public String doTask() {

                throw new RuntimeException("1234567890");
//                return "success";
            }

            @Override
            public void handleException(Exception e) {
                System.out.println(e.getMessage());
            }
        },100L,300000L).submit();



    }
}
