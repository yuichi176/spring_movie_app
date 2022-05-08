package com.example.spring_movie_app.domain;

import com.example.spring_movie_app.form.MovieForm;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * 映画情報を表すドメインオブジェクト
 */
public class Movie {
    /**
     * 映画ID
     */
    private Long movieId;
    /**
     * ユーザ名
     */
    private String userName;
    /**
     * 映画名
     */
    private String movieName;
    /**
     * 追加日時
     */
    private Date addDate;
    /**
     * 映画コメント
     */
    private String movieComment;
    /**
     * 映画評価
     */
    private Integer movieEval;
    /**
     * 削除フラグ
     */
    private boolean deleteFlag;

    public Long getMovieId() {
        return movieId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public Date getAddDate() {
        return addDate;
    }

    public String getMovieComment() {
        return movieComment;
    }

    public Integer getMovieEval() {
        return movieEval;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public void setMovieComment(String movieComment) {
        this.movieComment = movieComment;
    }

    public void setMovieEval(Integer movieEval) {
        this.movieEval = movieEval;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }



    public String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public String integerToString(Integer intEval) {
        return Integer.valueOf(intEval).toString();
    }

    public MovieForm toForm() {
        MovieForm movieForm = new MovieForm();
        movieForm.setAddDate(dateToString(this.addDate));
        movieForm.setMovieName(this.movieName);
        movieForm.setMovieComment(this.movieComment);
        movieForm.setMovieEval(integerToString(this.movieEval));
        return movieForm;
    }
}
