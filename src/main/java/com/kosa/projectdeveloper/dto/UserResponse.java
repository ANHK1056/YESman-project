package com.kosa.projectdeveloper.dto;

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
