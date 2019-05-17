package com.byron.eva.api;

import com.byron.eva.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/25
 */
@Slf4j
@RestController
@RequestMapping("/cache")
public class CacheApi {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("get")
    public String getKeyValue(String keyName) {
        String cacheValue1 = redisUtil.get(keyName) == null ? null : redisUtil.get(keyName).toString();
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String cacheValue = opsForValue.get(keyName);
        return cacheValue;
    }

    @RequestMapping("set")
    public boolean setKeyValue(@RequestParam Map<String, Object> map) {
        String name = map.get("name").toString();
        Object value = map.get("value");
        boolean isSuccess = redisUtil.set(name, value, 60);
        return isSuccess;
    }

    @RequestMapping()
    public String deleteKey(@RequestParam("key") String key) {
        redisUtil.del(key);
        return "success";
    }

    @RequestMapping("expire")
    public Long getExpire(@RequestParam("name") String name) {
        long expire = redisUtil.getExpire(name);
        return expire;
    }

    @RequestMapping("test")
    public void testRedisTemplate() {
        RLock lock = redissonClient.getLock("Byron-Redisson");
        try {
            lock.tryLock();
            log.info("lock lock()！！！");
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();
            Integer times = 10;
            for (int i = 1; i <= times; i++) {
                listOperations.leftPush("list_key", i + "_list");
                stringRedisTemplate.opsForValue().set("list_key" + i, i + "");
            }
            System.out.println("list_key:" + listOperations.range("list_key", 0, -1));
        } catch (Exception e) {
            log.error("lock has error!!!", e);
        } finally {
            lock.unlock();
            log.info("lock unlock！！！");
        }
    }
}
