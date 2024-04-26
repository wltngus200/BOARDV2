package com.green.boardver2.board;

import com.green.boardver2.board.model.*;
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

    List<BoardGetAllRes> getBoardAll(BoardGetReq p){
        //p.setLength(p.getSize());
        //p.setStartIdx((p.getPage()-1)*p.getSize());
        return mapper.getBoardAll(p);
    }

    BoardGetOneRes getBoardOne(long boardId) {
        BoardGetOneRes result = mapper.getBoardOne(boardId);
        if (result != null) {//Record가 있다면 조회수 +1
            mapper.patchBoardHits(boardId);
        }
        return result;
    }

    int deleteBoard(long boardId){
        return mapper.deleteBoard(boardId);
    }

    int putBoard(BoardPutReq p){return mapper.putBoard(p);}
}
