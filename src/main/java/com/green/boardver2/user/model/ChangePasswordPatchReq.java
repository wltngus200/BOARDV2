package com.green.boardver2.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordPatchReq {
    //비밀번호 수정할 때 보내야 할 값: uid(대상), upw(주인인지 확인), new_upw(신규비밀번호)
    //많은 데이터 중 대상지정은 pk or uid
    //여기엔 프론트에게 받을 값만 적어놔야 함
    //적어두면 swagger에 표시 됨 프론트에게 안 받아도 될 값 저장할 시
    @JsonIgnore //바로 아래에 있는 것을 스웨거에 표시 X
    private long userId;
    private String uid;
    private String currentPw;
    private String newPw;

}
