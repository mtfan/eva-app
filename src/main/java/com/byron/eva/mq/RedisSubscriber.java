package com.byron.eva.mq;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/28
 */
public class RedisSubscriber extends Thread {

    private final JedisPool jedisPool;

    private final RedisMessageListener redisMessageListener = new RedisMessageListener();

    private final static String myChannel = "myChannel";

    public RedisSubscriber(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        Jedis jedis = null;
        try {
            //取出一个连接
            jedis = jedisPool.getResource();
            //通过subscribe的api去订阅，参数是订阅者和频道名
            jedis.subscribe(redisMessageListener, myChannel);

            //注意：subscribe是一个阻塞的方法，在取消订阅该频道前，会一直阻塞在这，无法执行后续的代码
            //这里在msgListener的onMessage方法里面收到消息后，调用了this.unsubscribe();来取消订阅，才会继续执行
            System.out.println("继续执行后续代码。。。");

        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
