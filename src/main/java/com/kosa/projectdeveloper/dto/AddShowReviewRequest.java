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

<<<<<<< HEAD
    private String review_Title;
    private String review_Content;
    private Show show;
=======
    private String reviewTitle;
    private String reviewContent;

//    private Show show;
>>>>>>> f5e1c8fb9d7fd2061e60d2e5934d1263ad7ba531
    private Book book;



    public ShowReview toEntity() {
        return ShowReview.builder()
<<<<<<< HEAD
                .review_Title(review_Title)
                .review_Content(review_Content)
//                .user(uesr)
                .show(show)
                .book(book)
=======
                .reviewTitle(reviewTitle)
                .reviewContent(reviewContent)


//                .show(show)
//                .book(book)
>>>>>>> f5e1c8fb9d7fd2061e60d2e5934d1263ad7ba531
                .build();
    }


}
