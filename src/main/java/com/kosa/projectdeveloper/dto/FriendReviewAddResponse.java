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
public class FriendReviewAddResponse {

    private User user;
    private String title;
    private String content;

    // 유저 정보 위한 필드
    private String userEmail;

    public FriendReview toEntity() {
        return FriendReview.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();

    }
}


