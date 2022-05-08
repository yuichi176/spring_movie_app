package com.example.spring_movie_app.repository.movie;

import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.repository.mybatis.MovieMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public MovieRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Movie> findAll(String  userName) {
        List<Movie> movies = null;
        movies = this.sqlSessionTemplate
                .getMapper(MovieMapper.class).findAll(userName);
        return movies;
    }

    @Override
    public Movie findOne(Long movieId) {
        Movie movie = this.sqlSessionTemplate
                .getMapper(MovieMapper.class).findOne(movieId);
        return movie;
    }

    @Override
    public void add(Movie movie) {
        this.sqlSessionTemplate
                .getMapper(MovieMapper.class).add(movie);
    }

    @Override
    public void updateOne(Movie movie) {
        this.sqlSessionTemplate
                .getMapper(MovieMapper.class).updateOne(movie);
    }

    @Override
    public void deleteOne(Long userId) {
        this.sqlSessionTemplate
                .getMapper(MovieMapper.class).deleteOne(userId);
    }

}
