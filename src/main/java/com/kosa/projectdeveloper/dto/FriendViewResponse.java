package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.FriendReview;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class FriendViewResponse {

    private Long id;
    private User user;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public FriendViewResponse(FriendReview friendReview) {
        this.user = friendReview.getUser();
        this.title = friendReview.getTitle();
        this.content = friendReview.getContent();
        this.createdAt = friendReview.getCreatedAt();
    }

}


