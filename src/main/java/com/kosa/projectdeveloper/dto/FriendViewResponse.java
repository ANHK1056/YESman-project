package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.User;
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

    // 유저 정보 위한 필드
    private String userEmail;

    public FriendViewResponse(FriendReview friendReview) {
        this.id = friendReview.getId();
        this.user = friendReview.getUser();
        this.title = friendReview.getTitle();
        this.content = friendReview.getContent();
        this.createdAt = friendReview.getCreatedAt();
    }

}


