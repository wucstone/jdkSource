package com.wucstone.work;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;


public class Test1110 {

    @Test
    public void testMain()throws Exception{

        String s1 = "pros";
        String s2 = new String("pros");
        String s3 = "pro"+"s";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());
        System.out.println(s2 == s3.intern());


        ReentrantLock r;

        String ss = "        ";

        System.out.println(ss.length());
        ss = ss.trim();
        System.out.println(ss);
        System.out.println(ss.length());


    }



}
