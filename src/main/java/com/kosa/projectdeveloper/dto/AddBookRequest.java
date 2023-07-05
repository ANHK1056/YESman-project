package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBookRequest {
    private Long bookId;
    private String userId;
    private String showId;
    private String bookMail;
    // TODO: 2023-07-05 타입 확인 필요
    private String bookDay;
    // TODO: 2023-07-05 타입 확인 필요
    private String bookTime;
    // TODO: 2023-07-05 타입 확인 필요
    private Long bookPay;

    public Book toEntity() {
        return Book.builder()
                .bookId(bookId)
                .userId(userId)
                .showId(showId)
                .bookMail(bookMail)
                .bookDay(bookDay)
                .bookTime(bookTime)
                .bookPay(bookPay)
                .build();
    }
}
