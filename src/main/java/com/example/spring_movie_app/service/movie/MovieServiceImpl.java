package com.example.spring_movie_app.service.movie;

import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.repository.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll(Long userId) {
        return this.movieRepository.findAll(userId);
    }

    @Override
    public Movie findOne(Long movieId) {return this.movieRepository.findOne(movieId); }

    @Override
    public void add(Movie movie) {
        this.movieRepository.add(movie);
    }

    @Override
    public void updateOne(Movie movie) { this.movieRepository.updateOne(movie); }

    @Override
    public void deleteOne(Long movieId) { this.movieRepository.deleteOne(movieId); }
}
