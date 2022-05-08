package com.example.spring_movie_app.form;

import com.example.spring_movie_app.domain.Movie;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.sql.Date;
import java.time.LocalDateTime;

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

    public Movie toEntity() {
        Movie movie = new Movie();
        movie.setMovieName(this.movieName);
        movie.setAddDate(stringToDate(this.addDate));
        movie.setMovieComment(this.movieComment);
        movie.setMovieEval(stringToInteger(this.movieEval));
        return movie;
    }
}
