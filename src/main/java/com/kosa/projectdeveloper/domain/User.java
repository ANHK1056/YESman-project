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
    // TODO: 2023-07-05 PK 맵핑에 대해 추후 검토
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", updatable = false)
    private Long userId;
    //setting name
    @Column()
    private String userName;
    //email 형식
    @Column(nullable = false, unique = true)
    private String userEmail;
    // only english
    @Column()
    private String userPw;
    //user_phoneNumber
    @Column()
    private String userPhNm;


    // ShowReview 랑 Join 위해 넣었어요..!
    @OneToMany(mappedBy = "review_Id")
    private List<ShowReview> showReviews = new ArrayList<>();


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

    public User updatePhNm(String userPhNm){
        this.userPhNm =userPhNm;
        return this;

    }

}
