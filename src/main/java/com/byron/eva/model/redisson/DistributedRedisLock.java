package com.byron.eva.model.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/5/7
 */
public class DistributedRedisLock {

    private static RedissonClient redisson = RedissonManager.getRedisson();
    private static final String LOCK_TITLE = "redisLock_";

    public static void acquire(String lockName) {
        String key = LOCK_TITLE + lockName;
        RLock redissonLock = redisson.getLock(key);
        //lock提供带timeout参数，timeout结束强制解锁，防止死锁
        redissonLock.lock(2, TimeUnit.MINUTES);
        System.err.println("======redissonLock======" + Thread.currentThread().getName());
    }

    public static void release(String lockName) {
        String key = LOCK_TITLE + lockName;
        RLock redissonLock = redisson.getLock(key);
        redissonLock.unlock();
        System.err.println("======unlock======" + Thread.currentThread().getName());
    }
}
