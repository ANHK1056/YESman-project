package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.FriendReview;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FriendListViewResponse {

    private final Long id;
    private final User user;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

    public FriendListViewResponse(FriendReview friendReview) {
        this.id = friendReview.getId();
        this.user = friendReview.getUser();
        this.title = friendReview.getTitle();
        this.content = friendReview.getContent();
        this.createdAt = friendReview.getCreatedAt();

    }
}


