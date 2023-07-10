package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class AddShowReviewRequest {

    private String review_Title;
    private String review_Content;

    public ShowReview toEntity() {
        return ShowReview.builder()
                .review_Title(review_Title)
                .review_Content(review_Content)
                .build();
    }


}
