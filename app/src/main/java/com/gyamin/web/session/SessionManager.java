package com.gyamin.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private SessionDataOperation sessionDataOperation;
    private CookieOperator cookieOperator;

    public SessionManager() {
        sessionDataOperation = new RedisOperator();
        cookieOperator = new CookieOperator();
    }

    public void startSession() {
        String sessionId = cookieOperator.setSessionIdToCookie();
    }

    public void storeSessionData(HashMap<String, Object> value) {
        String key = cookieOperator.getSessionId();
        this.sessionDataOperation.storeSessionData(key, value);
    }

    public Map<String, Object> getSessionData() {
        String key = cookieOperator.getSessionId();
        Map<String, Object> sessionData = sessionDataOperation.getSessionData(key);
        return sessionData;
    }

    public void endSession() {
        String key = cookieOperator.getSessionId();
        cookieOperator.removeSessionIdFromCookie();
        sessionDataOperation.deleteSessionData(key);
    }
}
