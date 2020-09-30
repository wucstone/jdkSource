package com.wucstone.spinlock;

/**
 * 配合自旋锁使用，自旋任务
 */
public interface SpinLockTask<T> {

    T doTask();

}
