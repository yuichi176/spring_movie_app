package com.example.spring_movie_app.form;

import com.example.spring_movie_app.domain.Movie;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;

public class MovieForm {
    /**
     * 映画名
     */
    @NotEmpty(message = "映画名を入力してください")
    private String movieName;
    /**
     * 追加日時
     */
    @NotEmpty(message = "鑑賞日を入力してください")
    private String addDate;
    /**
     * 映画コメント
     */
    private String movieComment;
    /**
     * 映画評価
     */
    @NotEmpty(message = "評価を入力してください")
    private String movieEval;

    /**
     * 映画ジャンル
     */
    @NotEmpty(message = "ジャンルを入力してください")
    private String movieGenre;

    public String getMovieName() {
        return movieName;
    }

    public String getAddDate() {
        return addDate;
    }

    public String getMovieComment() {
        return movieComment;
    }

    public String  getMovieEval() {
        return movieEval;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public void setMovieComment(String movieComment) {
        this.movieComment = movieComment;
    }

    public void setMovieEval(String movieEval) {
        this.movieEval = movieEval;
    }

    public Date stringToDate(String strDate) {
        return Date.valueOf(strDate);
    }

    public int stringToInteger(String strEval) {
        return Integer.parseInt(strEval);
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Movie toEntity() {
        Movie movie = new Movie();
        movie.setMovieName(this.movieName);
        movie.setAddDate(stringToDate(this.addDate));
        movie.setMovieComment(this.movieComment);
        movie.setMovieEval(stringToInteger(this.movieEval));
        movie.setMovieGenre(this.movieGenre);
        return movie;
    }
}
