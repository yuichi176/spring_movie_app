package com.example.spring_movie_app.service.movie;

import com.example.spring_movie_app.domain.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll(Long userId);

    Movie findOne(Long movieId);

    void add(Movie movie);

    void updateOne(Movie movie);

    void deleteOne(Long movieId);
}
