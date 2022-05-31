package com.example.spring_movie_app.service;

import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.repository.movie.MovieRepository;
import com.example.spring_movie_app.service.movie.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllWhenSuccess() {

        // setup
        Long input = 1L;
        Movie movie = new Movie();
        List<Movie> result = new ArrayList<>();
        result.add(movie);
        Mockito.doReturn(result).when(movieRepository).find(input, null);
        MovieServiceImpl target = new MovieServiceImpl(movieRepository);

        // when
        List<Movie> movieList = target.find(input, null);

        // then
        assertEquals(result, movieList);
        Mockito.verify(movieRepository, Mockito.times(1)).find(input, null);
    }


}
