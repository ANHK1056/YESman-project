//유저 정보를 보여주는 클래스
package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserViewResponse {
    private Long userId;
    private String userName;
    private String userPw;
    private String userPhNm;
    private String userEmail;

    public UserViewResponse(User user){
        this.userId = user.getUserId();
        this.userName = user.getUsername();
        this.userPw = user.getUserPw();
        this.userPhNm =user.getUserPhNm();
        this.userEmail = user.getUserEmail();

    }

}
