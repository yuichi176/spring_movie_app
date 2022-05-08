package com.example.spring_movie_app.repository.mybatis;

import com.example.spring_movie_app.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * MyBatisによるaccountテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface AccountMapper {
    Account get(@Param("userName") String userName);
    void add(String userName, String password);
}
