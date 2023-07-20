/*
OAuth2 로그인시 유저 정보를 저장
 */
package com.kosa.projectdeveloper.config.oauth;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class OAuth2UserCustomService extends DefaultOAuth2UserService {

    //유저 정보 저장 객체
    private final UserRepository userRepository;

    //유저정보를 저장하는 메서드
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest); // ❶ 요청을 바탕으로 유저 정보를 담은 객체 반환
        saveOrUpdate(user);

        return user;
    }

    // 유저가 있으면 업데이트, 없으면 유저 생성
    private User saveOrUpdate(OAuth2User oAuth2User) {
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        User user = userRepository.findByUserEmail(email)
                .map(entity -> entity.updateName(name))
                .orElse(User.builder()
                        .userEmail(email)
                        .userName(name)
                        .userPhNm("수정 필요")
                        .userPw(encoder.encode("0000"))
                        .build());

        return userRepository.save(user);
    }
}

