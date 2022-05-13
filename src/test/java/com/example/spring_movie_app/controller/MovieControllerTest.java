package com.example.spring_movie_app.controller;

import com.example.spring_movie_app.SpringMovieAppApplication;
import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.repository.movie.MovieRepository;
import com.example.spring_movie_app.test.SpringSecurityResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = SpringMovieAppApplication.class)
@AutoConfigureMockMvc
@ExtendWith(SpringSecurityResource.class)
public class MovieControllerTest {

    @MockBean
    private MovieRepository movieRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetIndex() throws Exception {

        // setup
        Long input = 1L;
        Movie movie = new Movie();
        List<Movie> result = new ArrayList<>();
        result.add(movie);
        Mockito.doReturn(result).when(movieRepository).findAll(input);

        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/movie")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("movie/index"))
                .andExpect(model().attribute("movies", result));

        // then
        Mockito.verify(movieRepository, Mockito.times(1)).findAll(input);

    }


}
