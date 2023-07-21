/*
로그인, 로그아웃, 회원 가입 mapping을 하는 controller
 */
package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
import com.kosa.projectdeveloper.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RequiredArgsConstructor
@Controller
public class UserLoginController {
    private final UserService userService;
    //회원 가입 시 request를 받는 mapping
    @PostMapping("/users")
    public String signup(AddUserRequest request){

        String email=request.getUserEmail();
        User user= null;
        try {
            user =userService.findByUserEmail(email);
        }catch (IllegalArgumentException e){

        }
        //유저 정보가 있을 시 다시 회원 가입 창으로
      if(user !=null){
          return "redirect:signup";
      }

        userService.save(request);
        return "redirect:/login";
    }
    //로그아웃 맵핑
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "/";
    }

}
