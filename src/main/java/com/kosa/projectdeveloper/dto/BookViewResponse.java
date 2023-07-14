package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.User;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BookViewResponse {

    private Long bookId;
    private LocalDateTime bookDate;
    private String showDate;
    private String seat;
    private User user;
    private Show show;

    private String userEmail;
    private String showId;

    public BookViewResponse(Book book){
        this.bookId = book.getBookId();
        this.show = book.getShow();
        this.user = book.getUser();
        this.seat = book.getSeat();
        this.showDate = book.getShowDate();
        this.bookDate = book.getBookDate();
    }
}
