package com.green.boardver2.user;

import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(UserPostReq p){
        //암호화를 위한 로직이 들어감

        return mapper.postUser(p);
    }
}
