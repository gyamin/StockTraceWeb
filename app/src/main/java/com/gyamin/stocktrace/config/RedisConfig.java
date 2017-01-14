package com.gyamin.stocktrace.config;

public class RedisConfig {
    private String redisHost;
    private Integer redisExpire;

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public String getRedisHost() {
        return redisHost;
    }

    public Integer getRedisExpire() {
        return redisExpire;
    }

    public void setRedisExpire(Integer redisExpire) {
        this.redisExpire = redisExpire;
    }
}
