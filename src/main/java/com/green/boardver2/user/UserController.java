package com.green.boardver2.user;

import com.green.boardver2.common.ResultDto;
import com.green.boardver2.user.model.SignInPostReq;
import com.green.boardver2.user.model.ChangePasswordPatchReq;
import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //최종결재만 하는 애 //입구이자 점검
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping("signup")
    public ResponseEntity<ResultDto<Integer>> postUser(@RequestBody UserPostReq p){
        //ResponseEntity(원칙적으론 써야됨)가 없으면 200으로 날아감
        //우리가 무슨 일이 있어도 컨트롤러를 통하겠다
        // (<->중간에 에러가 터지면 던지는데 그걸 받는 인터셉터, 그 애에게 에러메세지만 보내면 됨
        int result= service.postUser(p);
        return ResponseEntity.ok(ResultDto.<Integer>builder()
                                .statusCode(HttpStatus.OK)//OK
                                .resultMsg(HttpStatus.OK.toString())
                                .resultData(result).build());

                /* result dto에 빌더패턴: 내가 넣고싶은 만큼만 넣어서 객체생성
                setter가 없을 때 사용, 값변경X
                HttpStatus값만 가진 애가 필요하다 변수 이름(데이터).OK)
                ResultDto.builder().statusCode(HttpStatus.OK).build()
                여러개의 경우 .으로 구분한다 */
        //200번대면 통신 잘 됨 400번대 클라이언트문제 500번대 서버문제
        //ok를 적었다 200대로 응답을 하겠다, 예외처리를 하면 다른 번호
    }

    //get방식으로 받으면 비밀번호가 노출되기 때문에 post방식으로 받음
    @PostMapping("signin")
    public ResponseEntity<ResultDto<Integer>> postSignin(@RequestBody SignInPostReq p){
        int result=service.postSignIn(p);
            String mas=switch(result){//서비스 참고
            case 1 -> "로그인에 성공했습니다.";
            case 2 -> "아이디를 확인해 주세요.";
            case 3->"비밀번호를 확인해 주세요.";
            default -> "알 수 없는 에러가 발생했습니다.";
            };
        return ResponseEntity.ok(ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)//200코드 나의 문제고 통신문제 X
                .resultMsg(mas)
                .resultData(result).build());
    }

    @PatchMapping("password")
    public ResultDto<Integer> patchPassword(@RequestBody ChangePasswordPatchReq p){
        int result=service.patchPassword(p);
        String mas=switch(result){
            case 1 -> "비밀번호 변경에 성공하였습니다.";
            case 2 -> "아이디를 확인해 주세요.";
            case 3 -> "비밀번호가 틀렸습니다.";
            default -> "알 수 없는 에러가 발생했습니다.";
        };
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }
}
