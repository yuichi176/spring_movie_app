package com.example.spring_movie_app.form;

import com.example.spring_movie_app.validation.Password;

import javax.validation.constraints.NotEmpty;

public class AccountForm {

    /**
     * ユーザ名
     */
    @NotEmpty
    private String userName;

    /**
     * パスワード
     */
    @Password
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
