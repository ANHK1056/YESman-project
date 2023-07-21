//요청받은 것을 유저 정보를 저장하는 클래스로 보내는 클래스
package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private final String userName;
    private final String userPw;
    private final String userPhNm;
    private final String userEmail;

    public UserResponse(User user){
        this.userName = user.getUsername();
        this.userPw = user.getUserPw();
        this.userPhNm = user.getUserPhNm();
        this.userEmail = user.getUserEmail();
    }
}
