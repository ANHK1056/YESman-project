package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
public class ReadBookResponse {
    private Long bookId;
    private LocalDateTime bookDate;
    private String showDate;
    private String seat;
    private User user;
    private Show show;

    // 유저 정보, 연극 정보 위한 필드
    private String userEmail;
    private String showId;

    public ReadBookResponse(Book book){
        this.bookId = book.getBookId();
        this.show = book.getShow();
        this.user = book.getUser();
        this.seat = book.getSeat();
        this.showDate = book.getShowDate();
    }

}
