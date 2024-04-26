package com.green.boardver2.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
//User Board 모두 사용하는 것을 담아놓은 폴더 Common
@Data
@Builder //빌더패턴: 내가 넣고싶은 만큼만 넣어서 객체생성
public class ResultDto<T> {//필수는 아님 우리가 기준을 세우면 됨(프론트랑 통신)
    //제네릭 타입을 객체가 생성될 때 결정(컴파일할 때 타입이 결정)
    //오브젝트보다 조금 향상됨+수용가능함 꺽쇠 생략시
    private HttpStatus statusCode; //200, 300, 400의 에러코드를 날림
    private String resultMsg; //에러 메세지
    private T resultData; //실제 데이터
    //프론트랑 통신
}
