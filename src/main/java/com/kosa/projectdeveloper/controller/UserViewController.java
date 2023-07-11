package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.UserListViewRespose;
import com.kosa.projectdeveloper.dto.UserViewResponse;
import com.kosa.projectdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
@RequiredArgsConstructor
@Controller
public class UserViewController {

    private final UserService userService;

//    @GetMapping("/login")
//    public String oauthLogin(){
//        return "oauthLogin";
//    }


    @GetMapping("/user")
    public String getUsers(Model model) {
        List<UserListViewRespose> users = userService.findAll().stream()
                .map(UserListViewRespose::new)
                .toList();
        model.addAttribute("users", users);
        // TODO: 2023-07-10 userList 페이지 이름 수정
        return "userList";
    }
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model){
        User user = userService.findByUserId(id);
        model.addAttribute("users",new UserViewResponse(user));
        // TODO: 2023-07-10 user 페이지 이름 수정
        return "user";
    }
    @GetMapping("/new-user")
    public String newUser(@RequestParam(required = false)Long id, Model model)
    {
        if(id == null){
            model.addAttribute("users", new UserViewResponse());
        } else {
            User user =userService.findByUserId(id);
            model.addAttribute("users", new UserViewResponse(user));
        }

        return "newUser";
    }
    // TODO: 2023-07-07 login form 구성 시 주석 해제
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    // TODO: 2023-07-07 login form 구성 시 주석 해제
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }


}
