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
                return "success";
            }
        },100L,3000L).submit();



    }
}
