package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
import com.kosa.projectdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        // TODO: 2023-07-05 error 발생시 Repository 수정
        return  userRepository.save(User.builder()
                .userName(dto.getUserName())
                .userPw(bCryptPasswordEncoder.encode(dto.getUserPw()))
                .userBirth(dto.getUserBirth())
                .userGender(dto.getUserGender())
                .userPhNm(dto.getUserPhNm())
                .userEmail(dto.getUserEmail())
                .userAddress(dto.getUserAddress())
                .build()).getUserId();
    }
}
