package com.gyamin.web.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CookieOperator {

    private HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    private HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    private String cookieKey;

    public CookieOperator() {
        this.cookieKey = "session_id";
    }

    public String setSessionIdToCookie() {
        String sessionId = getSessionId();
        if(sessionId.length() == 0) {
            sessionId = UUID.randomUUID().toString();
        }
        httpServletResponse.addCookie(new Cookie(this.cookieKey, sessionId));
        return sessionId;
    }

    public String getSessionId() {
        Cookie cookies[] = httpServletRequest.getCookies();
        String sessionId = "";

        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                if(cookies[i].getName().equals(this.cookieKey)){
                    sessionId = cookies[i].getValue();
                }
            }
        }
        return sessionId;
    }

    public void removeSessionIdFromCookie() {
        Cookie cookies[] = httpServletRequest.getCookies();

        String sessionId = null;
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                if(cookies[i].getName().equals(this.cookieKey)){
                    sessionId = cookies[i].getValue();
                    cookies[i].setMaxAge(0);
                    httpServletResponse.addCookie(cookies[i]);
                }
            }
        }
    }
}
