package com.example.spring_movie_app.repository.movie;

import com.example.spring_movie_app.domain.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findAll(Long userId);

    Movie findOne(Long movieId);

    void add(Movie movie);

    void updateOne(Movie movie);

    void deleteOne(Long movieId);
}
