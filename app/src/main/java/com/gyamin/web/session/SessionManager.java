package com.gyamin.web.session;

import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private SessionDataOperation sessionDataOperation;
    private CookieOperator cookieOperator;

    public SessionManager() {
        this.sessionDataOperation = new RedisOperator();
        this.cookieOperator = new CookieOperator();
    }

    public void startSession() {
        String sessionId = this.cookieOperator.setSessionIdToCookie();
    }

    public void storeSessionData(HashMap<String, Object> value) {
        String key = this.cookieOperator.getSessionId();
        this.sessionDataOperation.storeSessionData(key, value);
    }

    public Map<String, Object> getSessionData() {
        String key = this.cookieOperator.getSessionId();
        Map<String, Object> sessionData = this.sessionDataOperation.getSessionData(key);
        return sessionData;
    }

    public void endSession() {
        String key = this.cookieOperator.getSessionId();
        this.cookieOperator.removeSessionIdFromCookie();
        this.sessionDataOperation.deleteSessionData(key);
    }
}
