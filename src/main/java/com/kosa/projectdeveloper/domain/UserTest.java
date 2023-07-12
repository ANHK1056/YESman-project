package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "user_test")
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Entity
public class UserTest {
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


//    // ShowReview 랑 Join 위해 넣었어요..!
//    @OneToMany(mappedBy = "review_Id")
//    private List<ShowReview> showReviews = new ArrayList<>();


    @Builder
    public UserTest(String userName, String userEmail,
                String userPw,String userPhNm){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw =userPw;
        this.userPhNm = userPhNm;
    }

}
