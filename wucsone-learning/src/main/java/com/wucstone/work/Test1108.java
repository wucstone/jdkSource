package com.wucstone.work;

import com.sun.javafx.geom.transform.Identity;
import org.apache.tomcat.util.buf.B2CConverter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test1108 {

    @Test
    public void testMain()throws Exception{

       List<B> list1 = new ArrayList<>();
//
//       B b1 = new B("b1","bbbbbbbbb1");
//        B b2 = new B("b2","bbbbbbbbb2");
//        B b3 = new B("b3","bbbbbbbbb3");
//        B b4 = new B("b4","bbbbbbbbb4");
//
//        list1.add(b1);
//        list1.add(b2);
//        list1.add(b3);
//        list1.add(b4);
//
//        List<B> list2 = new ArrayList<>();

//        B bb1 = new B("b1","aa1");
//        B bb2 = new B("b2","aa2");
//        B bb3 = new B("b3","aa3");
//        B bb4 = new B("b4","aa4");
//
//        list2.add(bb1);
//        list2.add(bb2);
//        list2.add(bb3);
//        list2.add(bb4);
//
////        Map<String,List<B>> map = Stream.of(list1,list2).flatMap(p->p.stream()).collect(Collectors.groupingBy(B::getName));
////        System.out.println(map);
//
////        System.out.println(Stream.of(list1, list2).flatMap(p -> p.stream()).collect(Collectors.groupingBy(B::getName)).entrySet().stream()
////                .map(e -> {
////                    String cAddr = e.getValue().stream().map(B::getAddr).collect(Collectors.joining());
////                    return new B(e.getKey(), cAddr);
////                }).collect(Collectors.toList()));
//        Map<String,B> map1 = list1.stream().collect(Collectors.toMap(B::getName,Function.identity()));
//        Map<String,B> map2 = list2.stream().collect(Collectors.toMap(B::getName,Function.identity()));
//
//        System.out.println(Stream.of(map1, map2).flatMap(m -> m.entrySet().stream()).
//                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
//                    return new B(v1.getName(), v1.getAddr() + v2.getAddr());
//                })));


    }



}
