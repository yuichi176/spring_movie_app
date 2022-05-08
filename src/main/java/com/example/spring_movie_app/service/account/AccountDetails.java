package com.example.spring_movie_app.service.account;

import com.example.spring_movie_app.domain.Account;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class AccountDetails extends User {
    private final Account account;
    /**
     * Spring Securityで認証するためのユーザ情報を設定する
     *
     * @param account データベースから取得したユーザ情報
     */
    public AccountDetails(Account account) {
        super(account.getUserName(), account.getPassword(),
                AuthorityUtils.createAuthorityList(
                        "ROLE_" + account.getRoleName().name())
        );
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
