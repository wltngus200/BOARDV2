package com.green.boardver2.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResultDto<T> {//제네릭 타입을 객체가 생성될 때 결정
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}
