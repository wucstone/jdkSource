package com.wucstone.spinlock;


import com.wucstone.utils.ThreadPoolResource;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;


/**
 * 自旋锁
 *
 */
@Slf4j
public class SpinLockOperator<T> {

    private Predicate<T> predicate;
    private SpinLockTask<T> task;
    private volatile boolean flag = true;

    private Long timeout;
    private Long period;


    /**
     *
     * @param predicate   自旋终止条件
     * @param task   线程任务
     * @param period   自旋任务间隔时间 ms
     * @param timeout  自选任务最大执行时间 ms
     */
    public SpinLockOperator(Predicate predicate,SpinLockTask task,Long period,Long timeout) {
        this.predicate = predicate;
        this.task = task;
        this.timeout = timeout;
        this.period = period;

    }

    public T submit(){

        Future<T> future = ThreadPoolResource.CALC_THREAD_POOL.submit(new Callable<T>() {

            @Override
            public synchronized T call() throws Exception {
                T obj = null;
                while(flag){
                    obj = (T) task.doTask();
                    if(predicate.test(obj)){
                        flag = false;
                    }
                    wait(period);
                }
                return (T)obj;
            }
        });
        T result = null;
        try {
            result = future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.error("自选任务超时，执行任务task:{}",task.getClass());
        } catch (ExecutionException e) {
            log.error("自选任务超时，执行任务task:{}",task.getClass());
        } catch (TimeoutException e) {
            log.error("自选任务超时，执行任务task:{}",task.getClass());
//            future.cancel(true);
        }
        return result;
    }

}
