package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetAllReq;
import com.green.boardver2.board.model.BoardGetOneReq;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ResultDto<Integer> postBoard(@RequestBody BoardPostReq p){
        int result= service.postBoard(p);
        return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.OK)//OK=200
                    .resultMsg("")
                    .resultData(result).build();
    }
    @GetMapping
    public ResultDto<List<BoardGetAllReq>> getBoardAll(/*??? 파라미터?*/){
        List<BoardGetAllReq> list=service.getBoardAll();
        return ResultDto.<List<BoardGetAllReq>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(list).build();
    }
    // 1개 가져오기
    @GetMapping({"boardId"})
    public BoardGetOneReq getBoardOne(long BoardId) {
        return service.getBoardOne(BoardId);
    }

    @DeleteMapping
    public int deleteBoard(int boardId){
        return service.deleteBoard(boardId);
    }

}
