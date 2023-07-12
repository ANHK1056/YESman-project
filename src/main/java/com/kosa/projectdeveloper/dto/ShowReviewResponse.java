package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.ShowReview;
import lombok.Getter;

@Getter
public class ShowReviewResponse {

    private final String reviewTitle;
    private final String reviewContent;

    public ShowReviewResponse(ShowReview showReview) {
        this.reviewTitle = showReview.getReviewTitle();
        this.reviewContent = showReview.getReviewContent();
    }


}
