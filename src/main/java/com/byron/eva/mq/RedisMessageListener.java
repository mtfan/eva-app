package com.byron.eva.mq;

import redis.clients.jedis.JedisPubSub;

/**
 * @Description: Redis服务订阅消息
 *
 * @Author: fanmingtao
 * @Date: 2019/4/28
 */
public class RedisMessageListener extends JedisPubSub {

    /**
     * 监听到订阅频道接受到消息时的回调 (onMessage)
     *
     * @param channel
     * @param message
     */
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(String.format("收到消息成功！ channel： %s, message： %s", channel, message));
        super.onMessage(channel, message);
    }

    /**
     * 监听到订阅模式接受到消息时的回调 (onPMessage)
     *
     * @param pattern
     * @param channel
     * @param message
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(String.format("收到消息成功！pattern： %s, channel： %s, message： %s", pattern, channel, message));
        super.onPMessage(pattern, channel, message);
    }

    /**
     * 订阅频道时的回调( onSubscribe )
     *
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("收到订阅频道消息！channel： %s, subscribedChannels： %s", channel, subscribedChannels));
        super.onSubscribe(channel, subscribedChannels);
    }

    @Override
    public void unsubscribe() {
        System.out.println(String.format("收到取消掉订阅消息！"));
        super.unsubscribe();
    }

    /**
     * 取消掉订阅消息
     *
     * @param channels
     */
    @Override
    public void unsubscribe(String... channels) {
        System.out.println(String.format("收到取消掉订阅消息！channels： %s", channels));
        super.unsubscribe(channels);
    }

    /**
     * 取消订阅频道时的回调( onUnsubscribe)
     *
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("收到取消订阅频道消息！channel： %s, subscribedChannels： %s", channel, subscribedChannels));
        super.onUnsubscribe(channel, subscribedChannels);
    }
}
