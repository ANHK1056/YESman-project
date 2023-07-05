package com.kosa.projectdeveloper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String userName;
    private String userPw;
    private String userBirth;
    private String userGender;
    private String userPhNm;
    private String userEmail;
    private String userAddress;
}
