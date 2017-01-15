package com.gyamin.web.session;

import java.util.HashMap;
import java.util.Map;

public interface SessionDataOperation {
    public boolean storeSessionData(String key, Map<String, String> value);
    public Map<String, String> getSessionData(String key);
    public boolean deleteSessionData(String key);
}
