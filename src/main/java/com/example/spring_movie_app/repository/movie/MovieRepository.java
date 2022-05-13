package com.example.spring_movie_app.repository.movie;

import com.example.spring_movie_app.domain.Movie;

import java.util.List;

public interface MovieRepository {

    /**
     * ユーザID指定による全検索処理
     *
     * @param userId ユーザID
     * @return ユーザに関連する全映画のリスト
     */
    List<Movie> findAll(Long userId);

    /**
     * ID指定による1件検索処理
     *
     * @param movieId 検索対象の映画ID
     * @return 指定されたIDの映画データ
     */
    Movie findOne(Long movieId);

    /**
     * 映画の新規登録処理
     *
     * @param movie 登録内容
     */
    void add(Movie movie);

    /**
     * 映画の更新処理
     *
     * @param movie 更新内容
     */
    void updateOne(Movie movie);

    /**
     * ID指定による映画の削除処理
     *
     * @param movieId 削除対象の映画のID
     */
    void deleteOne(Long movieId);
}
