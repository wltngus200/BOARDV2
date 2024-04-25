package com.green.boardver2.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//나누는 이유! 수정이 일어날 경우 얘가 어떤 기능을 담당하고 있었는지 기억해야 함
//전용이기 때문에 이것만 고려하면 됨
public class SignInPostReq {
    private String uid;
    private String upw;
}
