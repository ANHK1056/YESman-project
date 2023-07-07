package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;

@Getter
public class BookListViewResponse {

    private final Long bookId;
    private final String showId;
    // TODO: 2023-07-05 타입 확인 필요
    private final String bookDay;
    // TODO: 2023-07-05 타입 확인 필요
    private final String bookTime;
    private final String seatPosition;
    private final String showLocation;

    public BookListViewResponse(Book book) {
        this.bookId = book.getBookId();
        this.showId = book.getShowId();
        this.bookDay = book.getBookDay();
        this.bookTime = book.getBookTime();
        this.seatPosition = book.getSeatPosition();
        this.showLocation = book.getShowLocation();
    }

}
