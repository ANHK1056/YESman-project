/*
유저 정보를 보여주는 컨트롤러
 */
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


    @GetMapping("/login")
    public String login() {
        return "login";
    }
    //로그인 성공시 나오는 페이지
    @GetMapping("/loginHome/{id}")
    public String loginHome() {

        return "loginHome";
    }
    // TODO: 2023-07-07 login form 구성 시 주석 해제
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }
    //유저정보를 보여주는 페이지
    @GetMapping("/user-account/{id}")
    public String userAccount(@PathVariable Long id, Model model){
        if(id == null){
            model.addAttribute("users", new UserViewResponse());
        } else {
            User user =userService.findByUserId(id);
            model.addAttribute("users", new UserViewResponse(user));
        }
        return "user-account";
    }

    //유저정보를 수정 및 삭제하는 것을 보여주는 페이지
    @GetMapping("/user-personal")
    public String userPersonal(@RequestParam(required = false)Long id, Model model){
        if(id == null){
            model.addAttribute("users", new UserViewResponse());
        } else {
            User user =userService.findByUserId(id);
            model.addAttribute("users", new UserViewResponse(user));
        }
        return "user-personal";
    }



}
