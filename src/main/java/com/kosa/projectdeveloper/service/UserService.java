package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
import com.kosa.projectdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    // TODO: 2023-07-06 BCryptPasswordEncoder를 final 상수로 헀을 때 오류 
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    BCryptPasswordEncoder endcoder =new BCryptPasswordEncoder();
    public Long save(AddUserRequest dto){
        BCryptPasswordEncoder endcoder =new BCryptPasswordEncoder();
        // TODO: 2023-07-05 error 발생시 Repository 수정
        return  userRepository.save(User.builder()
                .userName(dto.getUserName())
                .userPw(endcoder.encode(dto.getUserPw()))
                .userBirth(dto.getUserBirth())
                .userGender(dto.getUserGender())
                .userPhNm(dto.getUserPhNm())
                .userEmail(dto.getUserEmail())
                .userAddress(dto.getUserAddress())
                .build()).getUserId();
    }
    public User findByUserId(Long userId){
        return userRepository.findByUserId(userId)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected user"));
    }
    public User findByUserEmail(String email) {
        return userRepository.findByUserEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }


}
