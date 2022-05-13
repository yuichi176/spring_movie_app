package com.example.spring_movie_app.domain;

import com.example.spring_movie_app.security.RoleName;

/**
 * ユーザ情報を表すドメインオブジェクト
 */
public class Account {
    /**
     * ユーザID
     */
    private Long userId;
    /**
     * ユーザ名
     */
    private String userName;
    /**
     * パスワード
     */
    private String password;
    /**
     * ロール
     */
    private RoleName roleName;
    /**
     * 削除フラグ
     */
    private boolean deleteFlag;

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
