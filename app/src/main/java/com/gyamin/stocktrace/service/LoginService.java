package com.gyamin.stocktrace.service;

import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.bean.SessionInfoBean;
import com.gyamin.stocktrace.dao.UsersDao;
import com.gyamin.stocktrace.dao.UsersDaoImpl;
import com.gyamin.stocktrace.exception.ApplicationException;
import com.gyamin.stocktrace.request.LoginRequest;
import com.gyamin.stocktrace.entity.Users;
import com.gyamin.web.session.SessionManager;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import org.seasar.doma.jdbc.tx.TransactionManager;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;

@Service
public class LoginService {
    public Map doLogin(LoginRequest request) throws ApplicationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        UsersDao dao = new UsersDaoImpl();

        Users loginUser = tm.required(() -> {
            return dao.selectByLoginIdPassword(request.getId(), request.getPassword());
        });

        if(loginUser == null) {
            // ユーザが存在しない場合
            throw new ApplicationException("ログインIDまたはパスワードに誤りがあります。");
        }

        // セッション開始
        (new SessionManager()).startSession();

        SessionInfoBean sessionInfoBean = new SessionInfoBean();
        sessionInfoBean.setLoginUser(loginUser);

        // セッション情報にユーザ情報を格納
        Map mapSessionInfo = PropertyUtils.describe(sessionInfoBean);
        (new SessionManager()).storeSessionData(mapSessionInfo);

        return mapSessionInfo;
    }
}
