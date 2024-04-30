package com.green.boardver2.board;

import com.green.boardver2.board.model.*;
import com.green.boardver2.common.ResultDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //빈등록+URL매핑(담당자 지정)
@RequestMapping("board") //board url로 들어오면 얘가 담당
//http메소드 까지 합해서 담당자 지정
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

//    @GetMapping
//    public ResultDto<List<BoardGetAllRes>> getBoardAll(@RequestParam(name="page") int page,
//                                                       @RequestParam(name="size", defaultValue = "10") int size){
//        BoardGetReq p=new BoardGetReq();
//        p.setStartIdx((page-1)*size);
//        p.setLength(size);
//
//        List<BoardGetAllRes> list=service.getBoardAll(p);
//        return ResultDto.<List<BoardGetAllRes>>builder()
//                .statusCode(HttpStatus.OK)
//                .resultMsg(String.format("rowCount: %d", list.size()))
//                .resultData(list).build();
//    }

    @GetMapping//?page=m&size=n
    public ResultDto<List<BoardGetAllRes>> getBoardAll(@ModelAttribute BoardGetReq p){
        List<BoardGetAllRes> list=service.getBoardAll(p);
        System.out.println(p);
        return ResultDto.<List<BoardGetAllRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(String.format("rowCount: %d", list.size()))
                .resultData(list).build();
    }

    // 1개 가져오기
    @GetMapping("{board_id}")
    public ResultDto<BoardGetOneRes> getBoardOne(@PathVariable(name="board_id") long BoardId) {
        BoardGetOneRes result= service.getBoardOne(BoardId);
        return ResultDto.<BoardGetOneRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(result==null?"잘못입력하셨습니다":HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
    @PutMapping
    public ResultDto<Integer> putBoard(@RequestBody BoardPutReq p){
        int result =service.putBoard(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
    @DeleteMapping
    public ResultDto<Integer> deleteBoard(int boardId){
         int result=service.deleteBoard(boardId);
         return ResultDto.<Integer>builder()
                 .statusCode(HttpStatus.OK)
                 .resultMsg("")
                 .resultData(result).build();
    }
    //페이지값과 사이즈값을 쿼리스트링으로 받을 것 @RequestParam

}
