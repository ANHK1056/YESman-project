package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String userName;
    private String userPw;
    private String userBirth;
    private String userGender;
    private String userPhNm;
    private String userEmail;
    private String userAddress;

    public User toEntity(){
//        BCryptPasswordEncoder endcoder =new BCryptPasswordEncoder();
        return  User.builder()
                .userName(userName)
                .userAddress(userAddress)
                .userPw(userPw)
//                .userPw(endcoder.encode(userPw))
                .userGender(userGender)
                .userEmail(userEmail)
                .userPhNm(userPhNm)
                .userBirth(userBirth)
                .build();
    }
}
