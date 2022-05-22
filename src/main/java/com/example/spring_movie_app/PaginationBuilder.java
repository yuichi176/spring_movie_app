package com.example.spring_movie_app;

import org.springframework.data.domain.Page;

public class PaginationBuilder {
    /**
     * コンストラクタ
     */
    private PaginationBuilder() {
    }

    /**
     * Paginationのインスタンスを生成するメソッド
     */
    public static Pagination create(Page pageObject) {
        Pagination pagination = new Pagination();
        pagination.setFirst(pageObject.isFirst());
        pagination.setLast(pageObject.isLast());
        pagination.setNumber(pagination.getNumber());
        pagination.setNumberOfElements(pageObject.getNumberOfElements());
        pagination.setSize(pageObject.getSize());
        pagination.setTotalElements(pageObject.getTotalElements());
        pagination.setTotalPages(pageObject.getTotalPages());
        return pagination;
    }
}
