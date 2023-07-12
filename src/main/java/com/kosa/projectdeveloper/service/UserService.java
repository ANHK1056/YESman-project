package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
import com.kosa.projectdeveloper.dto.UpdateUserRequest;
import com.kosa.projectdeveloper.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .orElseThrow(()-> new IllegalArgumentException("not found: "+ userId));
    }
    public User findByUserEmail(String email) {
        return userRepository.findByUserEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ email));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(long id) {

        User user = userRepository.findByUserId(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : " + id));
        userRepository.delete(user);
    }
    @Transactional
    public User updateUser(long id, UpdateUserRequest request) {
        User user = userRepository.findByUserId(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+ id));

        user.updatePhNm(request.getUserPhNm());

        return  user;

    }

}
