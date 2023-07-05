package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "users")
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    //id is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private String userId;

    //setting name
    @Column(nullable = false)
    private String userName;
    // only english
    @Column(nullable = false)
    private String userPw;
    //date 형식으로 받음
    @Column(nullable = false)
    private String userBirth;
    // check box (남/여)
    @Column(nullable = false)
    private String userGender;

    //user_phoneNumber
    @Column(nullable = false)
    private String userPhNm;

    //email 형식
    @Column(nullable = false)
    private String userEmail;

    //주소로 받음
    @Column(nullable = false)
    private String userAddress;

    @Builder
    public User(String user_id,String user_name,String user_pw, String user_birth,
                String user_gender,String user_pNm, String user_email,String user_address){
        this.userId =user_id;
        this.userName = user_name;
        this.userPw =user_pw;
        this.userBirth =user_birth;
        this.userGender = user_gender;
        this.userPhNm = user_pNm;
        this.userEmail = user_email;
        this.userAddress =user_address;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }


    @Override
    public String getUsername() {
        return userId;
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




}
