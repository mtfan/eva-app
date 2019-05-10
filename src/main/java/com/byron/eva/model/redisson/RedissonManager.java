package com.byron.eva.model.redisson;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/5/7
 */
public class RedissonManager {

    private static final String RAtomicName = "byronId_";

    private static Config config = new Config();
    private static RedissonClient redisson = null;

    public static void init() {
        try {
            //这是用的集群server
            Config config = new Config();
            config.useClusterServers()
                    .addNodeAddress("redis://167.179.64.235:6379", "redis://167.179.64.235:6380")
                    .setPassword("mtfan#123")
                    .setScanInterval(5000);
            redisson = Redisson.create(config);
            //清空自增的ID数字
            RAtomicLong atomicLong = redisson.getAtomicLong(RAtomicName);
            atomicLong.set(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RedissonClient getRedisson() {
        return redisson;
    }

    /**
     * 获取redis中的原子ID
     *
     * @return
     */
    public static Long nextID() {
        RAtomicLong atomicLong = getRedisson().getAtomicLong(RAtomicName);
        atomicLong.incrementAndGet();
        return atomicLong.get();
    }
}