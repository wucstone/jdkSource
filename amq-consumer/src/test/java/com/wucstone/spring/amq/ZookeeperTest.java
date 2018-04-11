package com.wucstone.spring.amq;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;


public class ZookeeperTest {
	
	private static final int SESSION_TIMEOUT = 30000;  
	
    private  CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private  Stat stat = new Stat();
    private ZooKeeper zooKeeper;
	
	
    private static Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("执行结束！！！");
		}
	});
    
	@Test
	public void testZoo() throws IOException, KeeperException, InterruptedException{
		Watcher watcher =new Watcher() {
			
			public void process(WatchedEvent event) {
				 if (KeeperState.SyncConnected == event.getState()) {
			            if (EventType.None == event.getType() && null == event.getPath()) {
			            	System.out.println("Zookeeper session established");
			            } else if (EventType.NodeCreated == event.getType()) {
			                System.out.println("success create znode");

			            } else if (EventType.NodeDataChanged == event.getType()) {
			                System.out.println("success change znode: " + event.getPath());

			            } else if (EventType.NodeDeleted == event.getType()) {
			            	connectedSemaphore.countDown();
			                System.out.println("success delete znode");

			            } else if (EventType.NodeChildrenChanged == event.getType()) {
			                System.out.println("NodeChildrenChanged");

			            }
				}
			}
		};
		Runtime.getRuntime().addShutdownHook(t);
	    zooKeeper=getClient(watcher);
//		zoo.setData("/brokers/topics", "test".getBytes(), 1);
//		byte[] b=zoo.getData("/brokers/topics", watcher, new Stat());
		String p="/wucstone1";
		  //exists register watch
        zooKeeper.exists(p, true);
        String path = zooKeeper.create(p, "456".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        
//        connectedSemaphore.await();
        //get register watch
        zooKeeper.getData(path, true, stat);
        zooKeeper.setData(path, "hhhh".getBytes(), -1);
        zooKeeper.exists(path, true);
        //exists register watch
        zooKeeper.delete(path, -1); 
      
	}
	public ZooKeeper getClient(Watcher watcher) throws IOException{
//		return new ZooKeeper("node11:2181,node12:2181,node13:2181", SESSION_TIMEOUT, watcher);
		return new ZooKeeper("node-wuc-02:2181,node-wuc-03:2181,node-wuc-04:2181", SESSION_TIMEOUT, watcher);
	}
	
	public ZooKeeper getClient2(Watcher watcher) throws IOException{
//		return new ZooKeeper("node11:2181,node12:2181,node13:2181", SESSION_TIMEOUT, watcher);
//		return new ZooKeeper("node-wuc-02:2181,node-wuc-03:2181,node-wuc-04:2181", SESSION_TIMEOUT, watcher);
		return new ZooKeeper("node-wuc-02:2181", SESSION_TIMEOUT, watcher);
	}
	public ZooKeeper getClient3(Watcher watcher) throws IOException{
//		return new ZooKeeper("node11:2181,node12:2181,node13:2181", SESSION_TIMEOUT, watcher);
//		return new ZooKeeper("node-wuc-02:2181,node-wuc-03:2181,node-wuc-04:2181", SESSION_TIMEOUT, watcher);
		return new ZooKeeper("node-wuc-03:2181", SESSION_TIMEOUT, watcher);
	}
	public ZooKeeper getClient4(Watcher watcher) throws IOException{
//		return new ZooKeeper("node11:2181,node12:2181,node13:2181", SESSION_TIMEOUT, watcher);
//		return new ZooKeeper("node-wuc-02:2181,node-wuc-03:2181,node-wuc-04:2181", SESSION_TIMEOUT, watcher);
		return new ZooKeeper("node-wuc-04:2181", SESSION_TIMEOUT, watcher);
	}
	
	ZooKeeper zooKeeper2=null;
	ZooKeeper zooKeeper3=null;
	ZooKeeper zooKeeper4=null;
	
	@Test
	public void testCluster() throws IOException, KeeperException, InterruptedException{
		
		Watcher watcher =new Watcher() {
			public void process(WatchedEvent event) {
				if (KeeperState.SyncConnected == event.getState()) {
		            if (EventType.None == event.getType() && null == event.getPath()) {
		            	System.out.println("Zookeeper session established");
		            } else if (EventType.NodeCreated == event.getType()) {
		                System.out.println("success create znode");

		            } else if (EventType.NodeDataChanged == event.getType()) {
		                System.out.println("success change znode: " + event.getPath());
		                try {
							zooKeeper3.close();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

		            } else if (EventType.NodeDeleted == event.getType()) {
		            	connectedSemaphore.countDown();
		                System.out.println("success delete znode");

		            } else if (EventType.NodeChildrenChanged == event.getType()) {
		                System.out.println("NodeChildrenChanged");

		            }
			}
			
			}
		};
		zooKeeper2=getClient2(watcher);
		zooKeeper3=getClient3(watcher);
		zooKeeper4=getClient4(watcher);
		
		String path="/wucstone";
//        path = zooKeeper2.create(path, "456".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        byte[] b=zooKeeper2.getData(path, true, stat);
//        System.out.println(new String(b));
//        
//        zooKeeper3.exists(path, watcher);
//        zooKeeper3.setData(path, "0987".getBytes(), -1);
        
        
        List<ACL> list=zooKeeper3.getACL(path, stat);
        
        
        for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
//        b=zooKeeper4.getData(path, true, stat);
//        System.out.println(new String(b));
        
		
	}

}
