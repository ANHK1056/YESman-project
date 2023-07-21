//로그인시 저장되는 정보를 유저 정보로 저장하는 Service
package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public User loadUserByUsername(String userEmail)  {
        return userRepository.findByUserEmail(userEmail)
                .orElseThrow(()-> new IllegalArgumentException(userEmail));
    }
}
