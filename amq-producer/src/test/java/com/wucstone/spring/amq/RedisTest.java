package com.wucstone.spring.amq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisTest{
	
	@Test
	public void sendMessageTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		
		
		JedisPool jedisPool=(JedisPool) applicationContext.getBean("jedisPool");
		Jedis jedis= jedisPool.getResource();
//		for (int i = 0; i < 10; i++) {
//			jedis.lpush("wucstone.queue.redis", new SimpleDateFormat().format(new Date()));
//		}
//		String time=jedis.rpop("wucstone.queue.redis");
//		System.out.println(time);
		
//		String result=jedis.set("wucstone.cache.data.name", "wuchuang");
//		System.out.println(result);
//		String res=jedis.get("wucstone.cache.data.name");
//		System.out.println(res);
	}
}
