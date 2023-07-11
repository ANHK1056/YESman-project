package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
import com.kosa.projectdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    // TODO: 2023-07-06 BCryptPasswordEncoder를 final 상수로 헀을 때 오류 
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    BCryptPasswordEncoder endcoder =new BCryptPasswordEncoder();
    public User save(AddUserRequest request){

        return userRepository.save(request.toEntity());
    }

    public User findByUserId(Long userId){
        return userRepository.findByUserId(userId)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected user"));
    }
    public User findByUserEmail(String email) {
        return userRepository.findByUserEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    @Transactional
    public User updateUser(OAuth2User oAuth2User,AddUserRequest request) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        User user = userRepository.findByUserEmail(email)
                .orElseThrow(()->new IllegalArgumentException("Unexpected user"));

        user.update(request.getUserPhNm());

        return user;


    }
}
