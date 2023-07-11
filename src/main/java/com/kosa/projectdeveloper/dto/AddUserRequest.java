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
@Setter
public class AddUserRequest {
    private String userName;
    private String userPw;
    private String userPhNm;
    private String userEmail;

    public User toEntity(){
        BCryptPasswordEncoder endcoder =new BCryptPasswordEncoder();
        return  User.builder()
                .userName(userName)
                .userPw(endcoder.encode(userPw))
                .userEmail(userEmail)
                .userPhNm(userPhNm)
                .build();
    }
}
