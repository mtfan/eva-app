package com.byron.eva.config;

import io.netty.channel.nio.NioEventLoopGroup;
import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/26
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redisson")
public class RedissonConfig {

    private String address;

    private String password;

    private int connectionMinimumIdleSize;

    private int idleConnectionTimeout;

    private int pingTimeout;

    private int connectTimeout;

    private int timeout;

    private int retryAttempts;

    private int retryInterval;

    private int reconnectionTimeout;

    private int failedAttempts;

    private int subscriptionsPerConnection;

    private int subscriptionConnectionMinimumIdleSize;

    private int subscriptionConnectionPoolSize;

    private int connectionPoolSize;

    private int database;

    private int dnsMonitoringInterval;

    /**
     * 当前处理核数量 * 2
     */
    private int thread;

    private String codec = "org.redisson.codec.JsonJacksonCodec";

    @Bean(destroyMethod = "shutdown")
    RedissonClient redissonClient() throws Exception {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(address)
                .setPassword(password)
                .setConnectionPoolSize(connectionPoolSize)
                .setDatabase(database)
                .setConnectionMinimumIdleSize(connectionMinimumIdleSize)
                .setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize)
                .setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize)
                .setSubscriptionsPerConnection(subscriptionsPerConnection)
                .setTimeout(timeout)
                .setIdleConnectionTimeout(idleConnectionTimeout);
        Codec codec = (Codec) ClassUtils.forName(getCodec(), ClassUtils.getDefaultClassLoader()).newInstance();
        config.setCodec(codec);
        config.setThreads(thread);
        config.setEventLoopGroup(new NioEventLoopGroup());
        return Redisson.create(config);
    }
}