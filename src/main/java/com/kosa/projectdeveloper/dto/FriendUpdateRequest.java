package com.kosa.projectdeveloper.dto;

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
    private  LocalDateTime createAt;

//    public FriendUpdateRequest(FriendReview friendReview) {
//        this.userId = friendReview.getUser();
//        this.title =  friendReview.getTitle();
//        this.content = friendReview.getContent();
//        this.createdt = friendReview.getCreatedAt();
//    }

}


