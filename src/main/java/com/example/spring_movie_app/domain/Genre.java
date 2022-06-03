package com.example.spring_movie_app.domain;

/**
 * ジャンル情報を表すドメインオブジェクト
 */
public class Genre {
    /**
     * ジャンルID
     */
    private Long genreId;

    /**
     * ジャンル名
     */
    private String genreName;

    /**
     * 削除フラグ
     */
    private boolean deleteFlag;

    public Long getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
