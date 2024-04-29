package com.green.boardver2.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardGetOneRes {
    private long boardId;
    private String title;
    private String contents;
    private long writerId;
    private int hits;
}
