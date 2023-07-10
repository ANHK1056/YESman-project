package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
//import com.kosa.projectdeveloper.dto.UpdateUserRequest;
import com.kosa.projectdeveloper.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    // TODO: 2023-07-07 로그인 폼 구성 시 주석 해제
//    @PostMapping("/user")
//    public String signup(AddUserRequest request){
//        userService.save(request);
//        return "redirect:/login";
//    }

    private  final UserService userService;

    @PutMapping("/updateUser")
    public String addUser(OAuth2User oAuth2User, AddUserRequest request){
        userService.updateUser(oAuth2User, request);
        // TODO: 2023-07-07 후에 개인정보 추가시 다른 곳으로 변경
        return "redirect:/login";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
//    @PostMapping("/updateUser")
//    public ResponseEntity<User> updateUser(@RequestBody AddUserRequest request, Principal principal){
//        User savedUser = userService.save(request,request.getUserBirth(),request.getUserGender(),request.getUserPhNm(),
//                request.getUserAddress());
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedUser);
//
//    }

}
