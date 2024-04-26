package com.green.boardver2.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardGetAllRes {
    private long boardId;
    private String title;
    private long writerId;//실제로 보여주진 않지만 작성자 프로필기능 보기를 위해
    private long writer;
    private String createdAt;
    private int hits;
}
