package com.gyamin.stocktrace.service;

import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.dao.UsersDao;
import com.gyamin.stocktrace.dao.UsersDaoImpl;
import com.gyamin.stocktrace.request.LoginRequest;
import com.gyamin.stocktrace.entity.Users;
import org.springframework.stereotype.Service;

import org.seasar.doma.jdbc.tx.TransactionManager;

@Service
public class LoginService {
    public Users doLogin(LoginRequest request) {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        UsersDao dao = new UsersDaoImpl();

        Users loginUser = tm.required(() -> {
            return dao.selectByLoginIdPassword(request.getId(), request.getPassword());
        });

        if(loginUser == null) {

        }
        return loginUser;
    }
}