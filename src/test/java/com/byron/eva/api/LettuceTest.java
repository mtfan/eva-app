package com.byron.eva.api;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.concurrent.ExecutionException;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/5/8
 */
public class LettuceTest {

    public static void main(String[] args) {
        RedisClient client = RedisClient.create("redis://167.179.64.235:6379");

        StatefulRedisConnection<String, String> connect = client.connect();

        RedisCommands<String, String> syncCommands = connect.sync();
        String name = syncCommands.get("myname");
        System.out.println(name);

        RedisAsyncCommands<String, String> asyncCommands = connect.async();
        String s = null;
        try {
            s = asyncCommands.get("myname").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }
}
