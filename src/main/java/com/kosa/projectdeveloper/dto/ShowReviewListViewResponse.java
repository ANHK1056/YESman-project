package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.ShowReview;
import lombok.Getter;

@Getter
public class ShowReviewListViewResponse {
    private final Long reviewId;
    private final Book book;
    private final String reviewTitle;
    private  final  String reviewContent;

    public ShowReviewListViewResponse(ShowReview showReview){
        this.reviewId =showReview.getReviewId();
        this.book =showReview.getBook();
        this.reviewTitle = showReview.getReviewTitle();
        this.reviewContent =showReview.getReviewContent();

    }
}
