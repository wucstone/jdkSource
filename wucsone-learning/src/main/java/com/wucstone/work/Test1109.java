package com.wucstone.work;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test1109 {

    @Test
    public void testMain()throws Exception{

        A a = new A();
        B b = new B();

        Map map = new HashMap(8);

        map.put("a",a);
        map.put("b",b);

        System.out.println(map);

    }



}
