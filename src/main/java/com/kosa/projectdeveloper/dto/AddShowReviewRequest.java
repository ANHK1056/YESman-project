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

    private String review_Title;
    private String review_Content;
    private Show show;
    private Book book;


    public ShowReview toEntity() {
        return ShowReview.builder()
                .review_Title(review_Title)
                .review_Content(review_Content)
//                .user(uesr)
                .show(show)
                .book(book)
                .build();
    }


}
