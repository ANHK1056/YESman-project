package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    // 유저 정보, 연극 정보 위한 필드
    private String userEmail;
    private String showId;

    public BookListViewResponse(Book book) {
        this.bookId = book.getBookId();
        this.show = book.getShow();
        this.user = book.getUser();
        this.seat = book.getSeat();
        this.showDate = book.getShowDate();
        this.bookDate = book.getBookDate();
    }

}
