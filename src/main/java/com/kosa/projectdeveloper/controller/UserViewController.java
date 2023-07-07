package com.kosa.projectdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.io.IOException;

@Controller
public class UserViewController {
    // TODO: 2023-07-07 login form 구성 시 주석 해제
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
    @GetMapping("/login")
    public String oauthLogin(){
        return "oauthLogin";
    }

    // TODO: 2023-07-07 login form 구성 시 주석 해제
//    @GetMapping("/signup")
//    public String signup(){
//        return "signup";
//    }
    @GetMapping("/updateUser")
    public String updateUser(){
        return "updateUser";
    }



}
