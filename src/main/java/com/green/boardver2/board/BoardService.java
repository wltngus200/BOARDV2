package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetAllReq;
import com.green.boardver2.board.model.BoardGetOneReq;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    int postBoard(BoardPostReq p){
        return mapper.postBoard(p);
    }

    List<BoardGetAllReq> getBoardAll(){
       return mapper.getBoardAll();
    }

    BoardGetOneReq getBoardOne(long BoardId){
        return mapper.getBoardOne(BoardId);
    }

    int deleteBoard(int boardId){
        return mapper.deleteBoard(boardId);
    }
}
