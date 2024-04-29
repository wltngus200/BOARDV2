package com.green.boardver2.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Setter
@Getter
@ToString

//페이지값
public class BoardGetReq {
    private int page;//페이지값
    private int size=10;//페이지당 레코드 수

    @ConstructorProperties({"page", "size"})//자바의 이름과 다를 때 생성자에 이름 부여
    public BoardGetReq(Integer page, Integer size) {
        this.page = page == null ? 1 : page;
        this.size = size == null ? 10 : size;
        this.startIdx = (this.page - 1) * this.size;
        this.length = this.size;
    }

    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int length;
}
