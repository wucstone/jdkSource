package com.wucstone.work;


import org.junit.Test;

import java.util.HashMap;


public class Test0527 {


    @Test
    public void testMain()throws Exception{
       HashMap map =  new HashMap<>();
       map.put("name","wuchuang");

       map.entrySet().stream().forEach(e->{
           System.out.println(e.hashCode());
           System.out.println(e.hashCode() & 15);
       });
    }


}
