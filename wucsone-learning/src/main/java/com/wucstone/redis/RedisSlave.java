package com.wucstone.redis;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


public class RedisSlave {

    @Test
    public void testRedisSlave(){

//
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
//        LocalDateTime local = LocalDateTime.now();
//        System.out.println(df.format(local));


//        System.out.println("2020年05月10日 00:00:00".substring(5,11));
//
//
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));



//        System.out.println(LocalDate.parse("2020年05月17日", df));


        JedisPool pool = new JedisPool("r-bp1fub54xyjawe8q2ipd.redis.rds.aliyuncs.com",6380);
        Jedis jedis = pool.getResource();
        jedis.auth("wu9o129*whK21wQLJs");
        jedis.select(200);
        Set<String> set1 = jedis.keys("HH_OPS_VERSION_LIMIT*");


        for(String s:set1){
            jedis.del(s);
        }
//
        System.out.println(JSONObject.toJSONString(jedis.keys("HH_OPS_VERSION_LIMIT*")));
//
//        jedis.del("HH_STORE_LOCK_cocaCola------------:sync:");
//        jedis.del("cocaCola------------:sync::INDEX");
//        jedis.del("cocaCola------------:sync::SET0");
//        jedis.del("cocaCola------------:sync::SET1");
//
//        System.out.println(JSONObject.toJSONString(jedis.get("HH_STORE_LOCK_cocaCola------------:sync:")));




//        JedisPool pool = new JedisPool("127.0.0.1",6370);
//        Jedis jedis = pool.getResource();

//        System.out.println("第一次"+System.currentTimeMillis());
//        for(int i=0;i<100000;i++){
//            Person p = new Person("abcdes",new Random().nextInt(100000),"北京市朝阳区望京金辉大厦".concat(System.currentTimeMillis()+""));
//            jedis.sadd("NO.1",JSONObject.toJSONString(p));
//        }
//        System.out.println("第二次"+System.currentTimeMillis());
//
//        for(int i=0;i<100000;i++){
//            Person p = new Person("adscmxx",new Random().nextInt(100000),"北京市朝阳区启阳路金辉大厦".concat(System.currentTimeMillis()+""));
//            jedis.sadd("NO.2",JSONObject.toJSONString(p));
//        }
//        System.out.println("第三次"+System.currentTimeMillis());


//        System.out.println(JSONObject.toJSONString(jedis.smembers("NO.1")).getBytes().length);
//        System.out.println(JSONObject.toJSONString(jedis.smembers("NO.2")).getBytes().length);
//
//
//        System.out.println(JSONObject.toJSONString(new Person("wuchuang",1,"beijing"))+"-----------"+JSONObject.toJSONString(new Person("wuchuang",1,"beijing")).getBytes().length);
//
//        Set<String> set = jedis.sdiff("NO.2","NO.1");
//        System.out.println(JSONObject.toJSONString(set).length());
//        System.out.println(set.size());
//
//        System.out.println("第四次"+System.currentTimeMillis());

//        System.out.println(jedis.incr("index"));


    }
}
