package com.wucstone.spring.amq;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperTest {
	
	private static final int SESSION_TIMEOUT = 30000;  
	
	public static void main(String[] args){
		try {
			ZooKeeper zoo=new ZooKeeper("127.0.0.1:2181", SESSION_TIMEOUT, new Watcher() {
				public void process(WatchedEvent event) {
					System.out.println(event.getPath());
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
