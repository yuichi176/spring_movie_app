package com.example.spring_movie_app.repository.account;

import com.example.spring_movie_app.domain.Account;
import com.example.spring_movie_app.repository.account.AccountRepository;
import com.example.spring_movie_app.repository.mybatis.AccountMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public AccountRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public Account findOne(String userName) {
        Account account = null;
        account = this.sqlSessionTemplate
                .getMapper(AccountMapper.class).get(userName);
        return account;
    }

    @Override
    public void add(String userName, String password) {
        this.sqlSessionTemplate
                .getMapper(AccountMapper.class).add(userName, password);
    }
}
