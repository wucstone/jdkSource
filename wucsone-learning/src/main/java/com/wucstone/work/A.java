package com.wucstone.work;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A {


//    public static void main(String[] args) throws Exception{
//
//
//        Map<Integer,Integer> map1 = new HashMap<>();
//        map1.put(1,1);
//        map1.put(3,3);
//
//        Map<Integer,Integer> map2 = new HashMap<>();
//        map2.put(1,2);
//
//        Map mmm = Stream.of(map1,map2).flatMap(m-> m.entrySet().stream())
//                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v2-v1));
////
////        System.out.println(JSONObject.toJSONString(mmm));
//
//        map1.forEach((k,v)->map2.merge(k,v,(v1,v2)->v1-v2));
//
//        System.out.println(JSONObject.toJSONString(map2));
//
//    }

    @Override
    public int hashCode() {
        return 15;
    }
}
