package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FriendResponse {

    private final User user;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

    public FriendResponse(FriendReview friendReview) {

        this.user = friendReview.getUser();
        this.title = friendReview.getTitle();
        this.content = friendReview.getContent();
        this.createdAt = friendReview.getCreatedAt();
    }
}


