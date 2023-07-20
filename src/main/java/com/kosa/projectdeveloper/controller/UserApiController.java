/*
유저 정보를 수정, 삭제,조회하는 api 클래스
 */
package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.AddUserRequest;
//import com.kosa.projectdeveloper.dto.UpdateUserRequest;
import com.kosa.projectdeveloper.dto.UpdateUserRequest;
import com.kosa.projectdeveloper.dto.UserResponse;
import com.kosa.projectdeveloper.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    //조회 mapping
    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long id){
        User user = userService.findByUserId(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    //삭제 mapping
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        userService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    //수정 mapping
    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserRequest reuest){
        User updateUser  = userService.updateUser(id, reuest);

        return ResponseEntity.ok()
                .body(updateUser);
    }






}


