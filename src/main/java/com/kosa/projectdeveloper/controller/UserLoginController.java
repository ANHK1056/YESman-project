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
    @PostMapping("/users")
    public String signup(AddUserRequest request){

        String email=request.getUserEmail();
        User user= null;
        try {
            user =userService.findByUserEmail(email);
        }catch (IllegalArgumentException e){

        }

      if(user !=null){
          return "redirect:signup";
      }

        userService.save(request);
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "/";
    }

}
