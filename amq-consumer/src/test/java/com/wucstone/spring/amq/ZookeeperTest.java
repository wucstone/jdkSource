package com.wucstone.spring.amq;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;


public class ZookeeperTest {
	
	private static final int SESSION_TIMEOUT = 30000;  
	
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException{

		Watcher watcher =new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				System.out.println(event.getType());
				System.out.println(event.getState());
				System.out.println(event.getPath());
			}
		};
		ZooKeeper zoo=getClient(watcher);
		zoo.create("/wuch", "wuchuang".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	
	public static ZooKeeper getClient(Watcher watcher) throws IOException{
		return new ZooKeeper("127.0.0.1:2181", SESSION_TIMEOUT, watcher);
	}

}
