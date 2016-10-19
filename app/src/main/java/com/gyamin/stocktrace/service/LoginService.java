package com.gyamin.stocktrace.service;

import com.gyamin.stocktrace.bean.StockFluctuationInPeriodBean;
import com.gyamin.stocktrace.dao.StockPricesDao;
import com.gyamin.stocktrace.request.LoginRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.gyamin.stocktrace.bean.User;

import java.util.List;

@Service
public class LoginService {
    public User doLogin(LoginRequest request) {
        User loginUser = new User();
        loginUser.setFamilyName("野神");
        loginUser.setFirstName("康正");
        return loginUser;
    }
}