package com.green.boardver2.user;

import com.green.boardver2.user.model.SignInPostReq;
import com.green.boardver2.user.model.ChangePasswordPatchReq;
import com.green.boardver2.user.model.UserEntity;
import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(UserPostReq p){
        //암호화를 위한 로직이 들어감
        String hashedPassword= BCrypt.hashpw(p.getUpw(),BCrypt.gensalt());
        //                      암호화 메소드 (암호화하고 싶은 값 , 값 요청??)
        p.setUpw(hashedPassword);
        /*hash
        salt: 해싱을 여러번 수행 하는 것
        */
        return mapper.postUser(p);
    }
    //1: 로그인 성공, 2: 아이디 없음 3: 비밀번호 틀림
    //id와 pw 둘 다 where절에 넣으면 어느쪽이 문제인지 모름 id먼저 where에 넣기
    public int postSignIn(SignInPostReq p){
        UserEntity entity=mapper.getUserById(p.getUid()/*SignInPostReq의 getter*/);
        if(entity==null){return 2;}//null이면 아이디가 없다
        if(BCrypt.checkpw(p.getUpw(),entity.getUpw())){
            return 1;
        };
        return 3;
    }

    //1 변경성공 2 아이디 확인 3 기존 비밀번호 확인
    public int patchPassword(ChangePasswordPatchReq p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity==null){
            return 2;
        }else if(!BCrypt.checkpw(p.getCurrentPw(),entity.getUpw())){
            return 3;
        }
        String hashedPassword= BCrypt.hashpw(p.getNewPw(),BCrypt.gensalt());
        p.setNewPw(hashedPassword);
        p.setUserId(entity.getUserId());
        return mapper.patchPassword(p);//영향받은 행이 1 "return 1;"과 같다
    }
}
