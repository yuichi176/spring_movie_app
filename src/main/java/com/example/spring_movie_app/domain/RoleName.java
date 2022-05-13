package com.example.spring_movie_app.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

/**
 * ユーザに対する認可列挙体
 */
public enum RoleName {
    /**
     * 管理者
     */
    ADMIN() {
        @Override
        public List<GrantedAuthority> getGrantedAuthority() {
            return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
        }
    },
    /**
     * 一般ユーザ
     */
    USER() {
        @Override
        public List<GrantedAuthority> getGrantedAuthority() {
            return AuthorityUtils.createAuthorityList( "ROLE_USER");
        }
    };

    public abstract List<GrantedAuthority> getGrantedAuthority();
}
