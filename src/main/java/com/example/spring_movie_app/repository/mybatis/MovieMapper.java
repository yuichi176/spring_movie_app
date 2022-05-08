package com.example.spring_movie_app.repository.mybatis;

import com.example.spring_movie_app.domain.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatisによるmovieテーブルとのマッパーを表すインタフェース
 */
@Mapper
public interface MovieMapper {
    List<Movie> findAll(@Param("userName") String userName);
    Movie findOne(@Param("movieId") Long movieId);
    void add(Movie movie);
    void updateOne(Movie movie);
    void deleteOne(Long userId);
}
