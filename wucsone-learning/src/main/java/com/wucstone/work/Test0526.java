package com.wucstone.work;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Test0526 {


    @Test
    public void testMain(){

        ReentrantLock lock = new ReentrantLock();

        Integer before = 100000;
        String after = transfer(before);
    }

    private String transfer(Integer before) {

        System.out.println(before.toString().length());

        return null;
    }
}
