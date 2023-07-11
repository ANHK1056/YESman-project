package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.ShowReview;
import lombok.Getter;

@Getter
public class ShowReviewResponse {

    private final String title;
    private final String content;

    public ShowReviewResponse(ShowReview showReview) {
        this.title = showReview.getReview_Title();
        this.content = showReview.getReview_Content();
    }


}
