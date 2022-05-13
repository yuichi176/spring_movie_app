package com.example.spring_movie_app.test;

import com.example.spring_movie_app.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class TestAccount {
    /**
     * 一般アカウント作成
     *
     * @return アカウントのドメインオブジェクト
     */
    public Account createAccount() {
        Account account = new Account();
        account.setUserId(1L);
        account.setUserName("user01");
        account.setPassword("pass");
        return account;
    }
}
