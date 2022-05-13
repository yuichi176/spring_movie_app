package com.example.spring_movie_app.test;

import com.example.spring_movie_app.domain.Account;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;


/**
 * テストユーザで自動ログインを行うクラス
 */
public class SpringSecurityResource implements BeforeEachCallback, AfterEachCallback {

    private TestAccount testAccount = new TestAccount();

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("----- テストユーザ自動認証実行 -----");
        Account account = testAccount.createAccount();


    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        SecurityContextHolder.createEmptyContext();
    }
}
