package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FriendResponse {

    private final Long id;
    private final User user;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

    // 유저 정보 위한 필드
    private String userEmail;

    public FriendResponse(FriendReview friendReview) {
        this.id = friendReview.getId();
        this.user = friendReview.getUser();
        this.title = friendReview.getTitle();
        this.content = friendReview.getContent();
        this.createdAt = friendReview.getCreatedAt();
    }
}


