package com.wucstone.thread.util.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {
	
	  private int num;
      private Semaphore semaphore;
      
      public SemaphoreThread(int num,Semaphore semaphore){
          this.num = num;
          this.semaphore = semaphore;
      }
       
      @Override
      public void run() {
          try {
              semaphore.acquire();
              System.out.println("工人"+this.num+"占用一个机器在生产...");
              Thread.sleep(2000);
              System.out.println("工人"+this.num+"释放出机器");
              semaphore.release();           
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
}
