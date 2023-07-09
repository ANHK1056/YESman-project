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
    @Column()
    private String userName;
    // only english
    @Column()
    private String userPw;
    //date 형식으로 받음
    @Column()
    private String userBirth;
    // check box (남/여)
    @Column()
    private String userGender;

    //user_phoneNumber
    @Column()
    private String userPhNm;

    //email 형식
    @Column(nullable = false, unique = true)
    private String userEmail;

    //주소로 받음
    @Column()
    private String userAddress;



    @Builder
    public User(String userName,String userPw, String userBirth,
                String userGender,String userPhNm, String userEmail,String userAddress){
        this.userName = userName;
        this.userPw =userPw;
        this.userBirth =userBirth;
        this.userGender = userGender;
        this.userPhNm = userPhNm;
        this.userEmail = userEmail;
        this.userAddress =userAddress;
    }
    public void update(String userBirth, String userGender, String userPhNm,
                       String userAddress) {
        this.userBirth =userBirth;
        this.userGender=userGender;
        this.userPhNm = userPhNm;
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

    public User update(String userName) {
        this.userName =userName;

        return this;

    }





}
