package com.byron.eva.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/2/21
 */
@Slf4j
@Component
public class EvaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Eva项目启动后CommandLineRunner执行code...");
    }
}
