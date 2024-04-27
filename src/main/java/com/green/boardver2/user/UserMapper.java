package com.green.boardver2.user;

import com.green.boardver2.user.model.ChangePasswordPatchReq;
import com.green.boardver2.user.model.UserEntity;
import com.green.boardver2.user.model.UserPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(UserPostReq p);
    //insert 전용의 멤버필드
    UserEntity getUserById(String uid);//Mapper.xml
    //.xml에 있는 쿼리문에 따라 기능을 수행 uid에 입력된 값을 가진 데이터를 가져와 소장
    int patchPassword(ChangePasswordPatchReq p);

}
