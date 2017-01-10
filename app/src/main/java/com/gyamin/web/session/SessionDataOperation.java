package com.gyamin.web.session;

import java.util.HashMap;
import java.util.Map;

public interface SessionDataOperation {
    public boolean storeSessionData(String key, HashMap value);
    public Map<String, Object> getSessionData(String key);
    public boolean deleteSessionData(String key);
}
