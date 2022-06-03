package com.example.spring_movie_app.repository.mybatis;

import com.example.spring_movie_app.domain.Genre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatisによるgenreテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface GenreMapper {
    List<Genre> find(@Param("genreId") Long genreId);
}
