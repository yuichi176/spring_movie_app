package com.example.spring_movie_app.repository.genre;

import com.example.spring_movie_app.domain.Genre;
import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.repository.mybatis.GenreMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public GenreRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Genre> find(Long genreId) {
        List<Movie> movies = null;
        List<Genre> genres = null;
        genres = this.sqlSessionTemplate
                .getMapper(GenreMapper.class).find(genreId);
        return genres;
    }

}
