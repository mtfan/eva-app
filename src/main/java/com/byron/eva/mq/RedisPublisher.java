package com.byron.eva.mq;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/28
 */
public class RedisPublisher extends Thread {

    private final JedisPool jedisPool;

    public RedisPublisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //连接池中取出一个连接
        Jedis jedis = jedisPool.getResource();
        while (true) {
            String line;
            try {
                line = reader.readLine();
                if (!"quit".equals(line)) {
                    //从通过mychannel 频道发布消息
                    jedis.publish("mychannel", line);
                    System.out.println(String.format("发布消息成功！channel： %s, message： %s", "mychannel", line));
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
