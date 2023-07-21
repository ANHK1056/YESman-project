package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FriendUpdateRequest {
    private  User user;
    private  String title;
    private  String content;

    // 유저 정보 위한 필드
    private String userEmail;

    public FriendUpdateRequest(FriendReview friendReview) {
        this.title =  friendReview.getTitle();
        this.content = friendReview.getContent();
    }

}


