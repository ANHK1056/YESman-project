package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
//import com.kosa.projectdeveloper.dto.UpdateUserRequest;
import com.kosa.projectdeveloper.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    // TODO: 2023-07-07 로그인 폼 구성 시 주석 해제
//    @PostMapping("/api/user")
//    public String signup(AddUserRequest request){
//        userService.save(request);
//        return "redirect:/login";
//    }

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) {
        User savedUser = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }


    // TODO: 2023-07-09 테스트 후 주석 해제
//    @GetMapping("/api/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }
//    @PostMapping("/updateUser")
//    public ResponseEntity<User> updateUser(@RequestBody AddUserRequest request, Principal principal){
//        User savedUser = userService.save(request,request.getUserBirth(),request.getUserGender(),request.getUserPhNm(),
//                request.getUserAddress());
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedUser);
//
//    }
}


