package com.byron.eva.api;

import com.byron.eva.model.redisson.DistributedRedisLock;
import com.byron.eva.model.redisson.RedissonManager;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/26
 */
public class MainTest {

    private static void redisLock() {
        RedissonManager.init(); //初始化
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String key = "ByronFan";
                        DistributedRedisLock.acquire(key);
                        Thread.sleep(1000); //获得锁之后可以进行相应的处理
                        System.err.println("======获得锁后进行相应的操作======");
                        DistributedRedisLock.release(key);
                        System.err.println("=============================");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) {
        redisLock();
    }
}
