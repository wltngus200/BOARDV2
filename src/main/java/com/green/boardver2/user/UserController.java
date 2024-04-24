package com.green.boardver2.user;

import com.green.boardver2.common.ResultDto;
import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //최종결재만 하는 애
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<ResultDto<Integer>> postUser(@RequestBody UserPostReq p){
        int result= service.postUser(p);
        return null; //임시
        //200번대면 통신 잘 됨 400번대 클라이언트문제 500번대 서버문제
        //ok를 적었다 200대로 응답을 하겠다, 예외처리를 하면 다른 번호
    }
}
