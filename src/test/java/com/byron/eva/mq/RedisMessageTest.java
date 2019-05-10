package com.byron.eva.mq;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/28
 */
public class RedisMessageTest {

    public static void main(String[] args) {
        // 连接redis服务端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "167.179.64.235", 6379,30000,"mtfan#123");

        //发布者
        RedisPublisher publisher = new RedisPublisher(jedisPool);
        publisher.start();

        //订阅者
        RedisSubscriber subscriber = new RedisSubscriber(jedisPool);
        subscriber.start();
    }
}
