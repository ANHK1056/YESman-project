package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.ShowReview;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ShowReviewViewResponse {
    private Long reviewId;
    private Book book;
    private  String reviewTitle;
    private  String reviewContent;
    private LocalDate reviewPostingDate;

    public ShowReviewViewResponse(ShowReview showReview){
        this.reviewId =showReview.getReviewId();
        this.book =showReview.getBook();
        this.reviewTitle = showReview.getReviewTitle();
        this.reviewContent =showReview.getReviewContent();
        this.reviewPostingDate =showReview.getReviewPostingDate();
    }
}
