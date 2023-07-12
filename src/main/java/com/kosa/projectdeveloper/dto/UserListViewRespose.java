package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.User;
import lombok.Getter;


@Getter
public class UserListViewRespose {
    private  final Long userId;
    private final String userName;
    private final String userPw;
    private final String userPhNm;
    private final String userEmail;

    public UserListViewRespose(User user){
        this.userId = user.getUserId();
        this.userName = user.getUsername();
        this.userPw = user.getUserPw();
        this.userPhNm =user.getUserPhNm();
        this.userEmail = user.getUserEmail();

    }
}
