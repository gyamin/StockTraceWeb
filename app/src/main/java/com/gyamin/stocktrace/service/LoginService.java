package com.gyamin.stocktrace.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.bean.SessionInfoBean;
import com.gyamin.stocktrace.dao.UsersDao;
import com.gyamin.stocktrace.dao.UsersDaoImpl;
import com.gyamin.stocktrace.exception.ApplicationException;
import com.gyamin.stocktrace.request.LoginRequest;
import com.gyamin.stocktrace.entity.Users;
import com.gyamin.web.session.SessionManager;
import org.springframework.stereotype.Service;

import org.seasar.doma.jdbc.tx.TransactionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.InvocationTargetException;

@Service
public class LoginService {
    public String doLogin(LoginRequest request) throws ApplicationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {

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
        ObjectMapper mapper = new ObjectMapper();
        // JavaBeansオブジェクトをJSON文字列へ変換
        String jsonSessionInfo = mapper.writeValueAsString(sessionInfoBean);

        (new SessionManager()).storeSessionData(jsonSessionInfo);
        return jsonSessionInfo;
    }
}
