package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;

import com.kosa.projectdeveloper.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class AddShowReviewRequest {


    private String reviewTitle;
    private String reviewContent;

//    private Show show;
    private Book book;

    private Long bookId;

    private String userEmail;


    public ShowReview toEntity() {
        return ShowReview.builder()

                .reviewTitle(reviewTitle)
                .reviewContent(reviewContent)


//                .show(show)
                .book(book)
                .build();
    }


}
