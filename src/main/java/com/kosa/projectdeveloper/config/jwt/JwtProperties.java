/*
JWT Properties 정보를 담고 있는 클래스
 */
package com.kosa.projectdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
    //토큰 발급자
    private String issuer;

    //JWT Token을 hash 할때 사용할 Secretkey
    private String secretKey;
}
