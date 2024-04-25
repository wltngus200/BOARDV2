package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetAllReq;
import com.green.boardver2.board.model.BoardGetOneReq;
import com.green.boardver2.board.model.BoardPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{
    int postBoard(BoardPostReq p);
    List<BoardGetAllReq> getBoardAll();
    int deleteBoard(int boardId);
    BoardGetOneReq getBoardOne(long BoardId);
}
