package com.wucstone.thread.interrupt;

import com.wucstone.utils.ThreadPoolResource;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.stream.IntStream;

@Slf4j
public class TestMain {


    public static void main(String[] args) {


        while (true){
            Future<Object> future = ThreadPoolResource.CALC_THREAD_POOL.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {

        //                Thread.sleep(12000L);
        //                System.out.println("执行线程任务");
        //                throw new InterruptedException();
                    return "success";
                }
            });
            try {
                System.out.println(future.get(1000L, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                log.info("InterruptedException...");
            }  catch (TimeoutException e) {
                log.info("TimeoutException...");
            }catch (ExecutionException e) {
                e.printStackTrace();
                log.info("ExecutionException...");
            }
        }


    }
}
