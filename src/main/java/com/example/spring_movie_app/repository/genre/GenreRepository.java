package com.example.spring_movie_app.repository.genre;

import com.example.spring_movie_app.domain.Genre;

import java.util.List;

public interface GenreRepository {

    /**
     * クエリパラメータによる複数件参照処理
     *
     * @param genreId ジャンルID
     * @return ユーザに関連する条件に合致したMovieデータリスト
     */
    List<Genre> find(Long genreId);
}
