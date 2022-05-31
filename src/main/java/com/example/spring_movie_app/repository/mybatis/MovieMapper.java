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

    List<Movie> find(@Param("userId") Long userId, @Param("keyword") String keyword);

    Movie get(@Param("movieId") Long movieId);

    int add(Movie movie);

    int updateOne(Movie movie);

    int deleteOne(Long userId);
}
