package com.green.boardver2.user;

import com.green.boardver2.user.model.UserPostReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface UserMapper {
    int postUser(UserPostReq p);
    //insert 전용의 멤버필드
}
