package com.byron.eva.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
public class EvaApplicationRunner implements ApplicationRunner {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Eva项目启动后ApplicationRunner执行code...");


    }
}
