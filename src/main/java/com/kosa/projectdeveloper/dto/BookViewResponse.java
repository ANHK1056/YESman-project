package com.kosa.projectdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BookViewResponse {
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

    // TODO: 2023-07-06 좌석 위치 별도 추가, 확인 필요
    private String seatPosition;

    // TODO: 2023-07-06 공연장 위치 별도 추가, 확인 필요
    private String showLocation;

    private LocalDateTime createdAt;

    public BookViewResponse(Book book){
        this.bookId = book.getBookId();
//        this.userId = book.getUserId();
//        this.showId = book.getShowId();
//        this.bookMail = book.getBookMail();
//        this.bookDay = book.getBookDay();
//        this.bookTime = book.getBookTime();
//        this.bookPay = book.getBookPay();
//        this.seatPosition = book.getSeatPosition();
//        this.showLocation = book.getShowLocation();
//        this.createdAt = book.getCreatedAt();
    }
}
