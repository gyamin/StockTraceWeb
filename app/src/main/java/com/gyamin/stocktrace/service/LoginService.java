package com.gyamin.stocktrace.service;

import com.gyamin.stocktrace.request.PostLogin;
import org.springframework.stereotype.Service;
import com.gyamin.stocktrace.bean.User;

@Service
public class LoginService {
    public User doLogin(PostLogin request) {
        User loginUser = new User();
        loginUser.setFamilyName("野神");
        loginUser.setFirstName("康正");
        return loginUser;
    }
}