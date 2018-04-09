package com.wucstone.spring.amq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;


public class ZookeeperTest {
	
	private static final int SESSION_TIMEOUT = 30000;  
	
    private  CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private  Stat stat = new Stat();
    private ZooKeeper zooKeeper;
	
	
	@Test
	public void testZoo() throws IOException, KeeperException, InterruptedException{

		
		
		Watcher watcher =new Watcher() {
			
			public void process(WatchedEvent event) {
				 if (KeeperState.SyncConnected == event.getState()) {
			            if (EventType.None == event.getType() && null == event.getPath()) {
			                connectedSemaphore.countDown();
			                System.out.println("Zookeeper session established");
			            } else if (EventType.NodeCreated == event.getType()) {
			                System.out.println("success create znode");

			            } else if (EventType.NodeDataChanged == event.getType()) {
			                System.out.println("success change znode: " + event.getPath());

			            } else if (EventType.NodeDeleted == event.getType()) {
			                System.out.println("success delete znode");

			            } else if (EventType.NodeChildrenChanged == event.getType()) {
			                System.out.println("NodeChildrenChanged");

			            }
				}
			}
		};
	    zooKeeper=getClient(watcher);
//		zoo.setData("/brokers/topics", "test".getBytes(), 1);
//		byte[] b=zoo.getData("/brokers/topics", watcher, new Stat());
		String p="/wucstone";
		  //exists register watch
        zooKeeper.exists(p, true);
        String path = zooKeeper.create(p, "456".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //get register watch
        zooKeeper.getData(path, true, stat);
        zooKeeper.setData(path, "hhhh".getBytes(), -1);
        zooKeeper.setData(path, "abc".getBytes(), -1);
        zooKeeper.exists(path, true);
        //exists register watch
        zooKeeper.delete(path, -1); 
	}
	
	public ZooKeeper getClient(Watcher watcher) throws IOException{
		return new ZooKeeper("node11:2181,node12:2181,node13:2181", SESSION_TIMEOUT, watcher);
	}

}
