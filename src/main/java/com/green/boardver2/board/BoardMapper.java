package com.green.boardver2.board;

import com.green.boardver2.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{
    int postBoard(BoardPostReq p);
    int deleteBoard(long boardId);
    List<BoardGetAllRes> getBoardAll(BoardGetReq p);
    BoardGetOneRes getBoardOne(long BoardId);
    int patchBoardHits(long boardId);
    int putBoard(BoardPutReq p);
}
