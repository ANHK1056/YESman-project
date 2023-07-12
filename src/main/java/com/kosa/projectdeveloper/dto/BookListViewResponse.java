package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookListViewResponse {

    private Long bookId;
    private LocalDateTime bookDate;
    private String showDate;
    private String seat;
    private User user;
    private Show show;

    public BookListViewResponse(Book book) {
        this.bookId = book.getBookId();
        this.show = book.getShow();
        this.user = book.getUser();
        this.seat = book.getSeat();
        this.showDate = book.getShowDate();
    }

}
