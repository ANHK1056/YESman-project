package com.kosa.projectdeveloper.dto;


import com.kosa.projectdeveloper.domain.FriendReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FriendReviewAddResponse {
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public FriendReview toEntity() {
        return FriendReview.builder()
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .build();

    }
}


