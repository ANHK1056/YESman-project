package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ReadBookResponse {
    private final Long bookId;
    private final String userId;
    private final String showId;
    private final String bookMail;
    // TODO: 2023-07-05 타입 확인 필요
    private final String bookDay;
    // TODO: 2023-07-05 타입 확인 필요
    private final String bookTime;
    // TODO: 2023-07-05 타입 확인 필요
    private final Long bookPay;
    private final String seatPosition;
    private final String showLocation;

    private LocalDateTime createdAt;

    public ReadBookResponse(Book book){
        this.bookId = book.getBookId();
        this.userId = book.getUserId();
        this.showId = book.getShowId();
        this.bookMail = book.getBookMail();
        this.bookDay = book.getBookDay();
        this.bookTime = book.getBookTime();
        this.bookPay = book.getBookPay();
        this.seatPosition = book.getSeatPosition();
        this.showLocation = book.getShowLocation();
        this.createdAt = book.getCreatedAt();
    }

}
