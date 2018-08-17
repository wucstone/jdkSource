package com.wucstone.zookeeper.distlock.ii;

import java.io.IOException;
import java.util.Collections;
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
import org.apache.zookeeper.data.Stat;

public class ZKUtils {
	
	
	private static final String ZK_URL = "node11:2181,node12:2181,node13:2181";
	private static final int ZK_TIMEOUT = 3000;
	private CountDownLatch latch=new CountDownLatch(1);
//	private static volatile List<String> nodes=new ArrayList<String>();
	private ZooKeeper zoo;
	private String defaultPath="/zkLock";
	private String currentPath;
	private String watcherNode;
	private Watcher lockWatcher;
	
	
	
	
	public void setZoo(ZooKeeper zoo) {
		this.zoo = zoo;
	}




	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}




	public void setWatcherNode(String watcherNode) {
		this.watcherNode = watcherNode;
	}




	public void setLockWatcher(Watcher lockWatcher) {
		this.lockWatcher = lockWatcher;
	}




	/**
	 * 获取zookeeper连接
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws KeeperException 
	 */
//	public ZooKeeper getConnection() throws IOException, InterruptedException, KeeperException{
//		
//		
//		
//		
//		return zoo;
//	}
//	private void initParam() throws KeeperException, InterruptedException, IOException{
//		
//		
//
//	}
	
	public ZKUtils(int count) throws KeeperException, InterruptedException, IOException {
		zoo= new ZooKeeper(ZK_URL, 3000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if(event.getState()==KeeperState.SyncConnected){
					latch.countDown();
				}
			}
		});
		latch.await();
		
		
		
		if(zoo.exists(defaultPath, false)==null){
			zoo.create(defaultPath, "default data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		currentPath=zoo.create(defaultPath+"/seq", "default lock".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

		
		currentPath=currentPath.substring(currentPath.indexOf("seq"));
		List<String> nodes=zoo.getChildren(defaultPath, false);
		Collections.sort(nodes);
		int index=nodes.indexOf(currentPath);
		if(index==0){
			watcherNode="";
		}else{
			watcherNode=defaultPath+"/"+nodes.get(index-1);
		}
		
		
		lockWatcher = new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if(event.getType()==EventType.NodeDeleted && event.getPath().equals(watcherNode)){
					try {
						isMinNode();
						System.out.println(currentPath+"执行递归"+Thread.currentThread().hashCode());
						return;
					} catch (KeeperException | InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		
	}


	/**
	 * 获取锁
	 * @param zoo
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public String getDistributeLock() throws KeeperException, InterruptedException{
		
		List<String> nodes=zoo.getChildren(defaultPath, true);

		if(zoo.exists(defaultPath+"/"+currentPath, lockWatcher)!=null){
			System.out.println("当前节点:"+currentPath+",检测节点:"+watcherNode+"--nodes:"+nodes);
		}

//		nodes=getChildrenNode(zoo,currentPath);

		if(isMinNode()){
			System.out.println(Thread.currentThread().getName()+"返回："+currentPath);
			return defaultPath+"/"+currentPath;
		}else{
			return null;
		}
	}


	private boolean isMinNode() throws KeeperException, InterruptedException {
		
		List<String> nodes=zoo.getChildren(defaultPath, false);
		Collections.sort(nodes);
		
		int index=nodes.indexOf(currentPath);
		
		switch(index){
		
			case -1:{
				System.out.println("当前节点"+currentPath+"不存在"+Thread.currentThread().hashCode());
				return false;
			}
			case 0:{
				System.out.println("当前节点"+currentPath+"是最小的"+Thread.currentThread().hashCode());
				return true;
			}
			default:{
				
				return isMinNode();
//				String watcherNode=defaultPath+"/"+nodes.get(index-1);
//				try {
//					zoo.getData(watcherNode,lockWatcher , new Stat());
//					return false;
//				} catch (KeeperException | InterruptedException e) {
//					e.printStackTrace();
//					if(zoo.exists(watcherNode, false)==null){
//						System.out.println("当前节点的前一个节点"+watcherNode+"不存在");
//						nodes=zoo.getChildren(defaultPath, false);
//						return isMinNode();
//					}else{
//						throw e;
//					}
//				}
			}
		}
		
		
	}
	
	/**
	 * 释放锁
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public void closeLock(String currentPath) throws InterruptedException, KeeperException{
		if(zoo!=null&&zoo.exists(currentPath, false)!=null){
			zoo.delete(currentPath, -1);
			System.out.println("释放锁:"+currentPath);
		}
	}
	/**
	 * 释放锁
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public void closeZoo() throws InterruptedException, KeeperException{
		if(zoo!=null){
			zoo.close();
			System.out.println("释放锁");
		}
	}

}
