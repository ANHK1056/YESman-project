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
    // TODO: 2023-07-05 PK 맵핑에 대해 추후 검토
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long userId;

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
    @Column(nullable = false, unique = true)
    private String userEmail;

    //주소로 받음
    @Column(nullable = false)
    private String userAddress;

    @Builder
    public User(/*Long userId,*/String userName,String userPw, String userBirth,
                String userGender,String userPhNm, String userEmail,String userAddress,String auth){
//        this.userId =userId;
        this.userName = userName;
        this.userPw =userPw;
        this.userBirth =userBirth;
        this.userGender = userGender;
        this.userPhNm = userPhNm;
        this.userEmail = userEmail;
        this.userAddress =userAddress;
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




}
