package com.gyamin.web.session;

import com.gyamin.stocktrace.config.RedisConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;

public class RedisOperator implements SessionDataOperation {

    private RedisConfig redisConfig;
    private Jedis jedis;

    public RedisOperator(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;

        this.jedis = new Jedis(redisConfig.getRedisHost());
    }

    @Override
    public boolean storeSessionData(String key, String value) {
        this.jedis.mset(key, value);
        this.jedis.expire(key, redisConfig.getRedisExpire());
        return false;
    }

    @Override
    public String getSessionData(String key) {
        this.jedis.expire(key, redisConfig.getRedisExpire());
        String sessionData = this.jedis.get(key);
        return sessionData;
    }

    @Override
    public boolean deleteSessionData(String key) {
        return false;
    }
}
