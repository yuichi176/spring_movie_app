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
    public List<Movie> find(Long userId, String keyword) {
        return this.movieRepository.find(userId, keyword);
    }

    @Override
    public Movie get(Long movieId) {return this.movieRepository.get(movieId); }

    @Override
    public void add(Movie movie) {
        this.movieRepository.add(movie);
    }

    @Override
    public void updateOne(Movie movie) { this.movieRepository.updateOne(movie); }

    @Override
    public void deleteOne(Long movieId) { this.movieRepository.deleteOne(movieId); }
}
