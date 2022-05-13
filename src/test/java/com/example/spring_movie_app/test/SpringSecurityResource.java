package com.example.spring_movie_app.test;

import com.example.spring_movie_app.domain.Account;
import com.example.spring_movie_app.domain.RoleName;
import com.example.spring_movie_app.service.account.AccountDetails;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
        List<GrantedAuthority> grantedAuthorities = RoleName.ADMIN.getGrantedAuthority();
        AccountDetails accountDetails = new AccountDetails(
                account.getUserId(),
                account.getUserName(),
                account.getPassword(),
                grantedAuthorities);
        Authentication authentication
                = new UsernamePasswordAuthenticationToken(
                        accountDetails,
                "N/A",
                AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        SecurityContextHolder.createEmptyContext();
    }
}
