/*
유저정보를 수정하는 Requset
 */
package com.kosa.projectdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {
    private String userPhNm;
    private String userPw;

    private String userEmail;

}
