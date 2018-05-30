package com.wucstone.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.SentinelCommands;

public class RedisSentinel {
	
	public static void main(String[] args) {
		
//		Pool<Jedis> pool=new Pool<Jedis>() {
//		};
		
		
		Set<HostAndPort> nodes=new HashSet<HostAndPort>();
		
		HostAndPort node1=new HostAndPort("node-wuc-01", 6379);
		HostAndPort node2=new HostAndPort("node-wuc-02", 6379);
		HostAndPort node3=new HostAndPort("node-wuc-03", 6379);
		
	    Set<String> sentinels = new HashSet<String>();
        String hostAndPort1 = "node-wuc-01:26379";
        sentinels.add(hostAndPort1);

        String hostAndPort2 = "node-wuc-02:26379";
        sentinels.add(hostAndPort2);
        
        String hostAndPort3 = "node-wuc-03:26379";
        sentinels.add(hostAndPort3);
        
        String clusterName = "mymaster";

        JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName,sentinels,"");

        Jedis jedis = redisSentinelJedisPool.getResource();
        System.out.println(jedis.get("name"));
		
		
	}

}
