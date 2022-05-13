package com.example.spring_movie_app.service.account;

import com.example.spring_movie_app.domain.RoleName;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class AccountDetails extends User {

    /**
     * ユーザID
     */
    private Long userId;

    /**
     * ユーザ名
     */
    private String userName;

    /**
     * コンストラクタ
     * Spring Securityで認証するためのユーザ情報を設定する
     *
     * @param userId     ユーザID
     * @param userName   ユーザ名
     * @param password   パスワード
     * @param roleName   ロール
     */
    public AccountDetails(Long userId,
                          String userName,
                          String password,
                          RoleName roleName
                          ) {
        super(userName, password,
                AuthorityUtils.createAuthorityList(
                        "ROLE_" + roleName.name())
        );
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
