package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.ShowReview;
import lombok.Getter;

@Getter
public class ShowReviewResponse {

    private final Book book;
    private final String reviewTitle;
    private final String reviewContent;

    private String userEmail;
    private Long bookId;

    public ShowReviewResponse(ShowReview showReview) {
        this.reviewTitle = showReview.getReviewTitle();
        this.reviewContent = showReview.getReviewContent();
        this.book = showReview.getBook();
    }


}
