package com.gyamin.web.session;

import com.gyamin.stocktrace.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private SessionDataOperation sessionDataOperation;
    private CookieOperator cookieOperator;

    public SessionManager() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("redis-config.xml");
        RedisConfig redisConfig = ctx.getBean(RedisConfig.class);
        sessionDataOperation = new RedisOperator(redisConfig);
        cookieOperator = new CookieOperator();
    }

    public void startSession() {
        String sessionId = cookieOperator.setSessionIdToCookie();
    }

    public void storeSessionData(Map<String, String> value) {
        String sessionKey = cookieOperator.getSessionId();
        this.sessionDataOperation.storeSessionData(sessionKey, value);
    }

    public Map<String, String> getSessionData() {
        String sessionKey = cookieOperator.getSessionId();
        Map<String, String> sessionData = sessionDataOperation.getSessionData(sessionKey);
        return sessionData;
    }

    public void endSession() {
        String sessionKey = cookieOperator.getSessionId();
        cookieOperator.removeSessionIdFromCookie();
        sessionDataOperation.deleteSessionData(sessionKey);
    }

}
