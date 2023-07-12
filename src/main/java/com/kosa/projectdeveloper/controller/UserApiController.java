package com.kosa.projectdeveloper.controller;

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

    // TODO: 2023-07-07 로그인 폼 구성 시 수정



    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) {
        User savedUser = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/api/user")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(users);

    }
    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long id){
        User user = userService.findByUserId(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        userService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserRequest reuest){
        User updateUser  = userService.updateUser(id, reuest);

        return ResponseEntity.ok()
                .body(updateUser);
    }


    // TODO: 2023-07-09 테스트 후 주석 해제
    @GetMapping("/api/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
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


