/*
유저 정보를 저장하는 클래스
 */
package com.kosa.projectdeveloper.domain;

import com.kosa.projectdeveloper.dto.AddUserRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    //id is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", updatable = false)
    private Long userId;
    //setting name
    @Column
    private String userName;
    //email 형식
//    @Column(nullable = false, unique = true)
    @Column
    private String userEmail;
    // only english
    @Column
    private String userPw;
    //user_phoneNumber
    @Column
    private String userPhNm;



    @Builder
    public User(String userName, String userEmail,
                String userPw,String userPhNm){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw =userPw;
        this.userPhNm = userPhNm;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }


    @Override
    public String getUsername() {
        return userEmail;
    }
    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User updateName(String userName) {
        this.userName =userName;

        return this;

    }

    //유저 정보를 수정하는 메서드
    public User update(String userPhNm,String userPw){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        this.userPhNm =userPhNm;
        this.userPw=encoder.encode(userPw);
        return this;

    }

}
