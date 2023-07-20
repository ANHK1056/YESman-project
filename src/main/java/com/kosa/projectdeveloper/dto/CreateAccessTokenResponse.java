/*
access토큰을 저장하는 request
 */
package com.kosa.projectdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAccessTokenResponse {
    private String accessToken;
}

