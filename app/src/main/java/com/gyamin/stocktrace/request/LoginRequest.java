package com.gyamin.stocktrace.request;
import javax.validation.constraints.NotNull;

public class LoginRequest {
    @NotNull(message = "ログインIDは必須です。")
    private String id;

    @NotNull(message = "パスワードは必須です。")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
