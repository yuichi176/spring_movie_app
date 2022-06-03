package com.example.spring_movie_app.service.genre;

import com.example.spring_movie_app.domain.Genre;

import java.util.List;

public interface GenreService {

    /**
     * クエリパラメータによる複数件参照処理
     *
     * @param genreId ジャンルID
     * @return ジャンルに関連する条件に合致したGenreデータリスト
     */
    List<Genre> find(Long genreId);
}
