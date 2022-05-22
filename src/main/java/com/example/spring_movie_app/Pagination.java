package com.example.spring_movie_app;

/**
 * Thymeleafでページング情報を受け渡すためのオブジェクト
 */
public class Pagination {

    private boolean first;
    private boolean last;
    private int number;
    private int numberOfElements;
    private int size;
    private long totalElements;
    private int totalPages;

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public int getNumber() {
        return number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
