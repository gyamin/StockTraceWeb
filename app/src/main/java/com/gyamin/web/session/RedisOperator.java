package com.gyamin.web.session;

import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;

import com.gyamin.stocktrace.common.ApplicationProperties;

public class RedisOperator implements SessionDataOperation {
    Jedis jedis;

    public RedisOperator() {
         this.jedis = new Jedis("loc_cent7");
    }

    @Override
    public boolean storeSessionData(String key, HashMap value) {
        this.jedis.hmset(key, value);
        this.jedis.expire(key, 30);
        return false;
    }

    @Override
    public Map<String, Object> getSessionData(String key) {
        Map sessionData = this.jedis.hgetAll(key);
        return sessionData;
    }

    @Override
    public boolean deleteSessionData(String key) {
        return false;
    }
}
