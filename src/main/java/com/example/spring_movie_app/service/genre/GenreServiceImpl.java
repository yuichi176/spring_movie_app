package com.example.spring_movie_app.service.genre;

import com.example.spring_movie_app.domain.Genre;
import com.example.spring_movie_app.repository.genre.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> find(Long genreId) {
        return this.genreRepository.find(genreId);
    }
}
