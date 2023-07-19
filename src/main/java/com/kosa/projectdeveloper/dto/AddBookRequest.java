package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBookRequest {
    private LocalDateTime bookDate;
    private String showDate;
    private String seat;
    private User user;
    private Show show;

    // 유저 정보, 연극 정보 위한 필드
    private String userEmail;
    private String showId;

    public Book toEntity() {
        return Book.builder()
                .user(user)
                .show(show)
                .seat(seat)
                .showDate(showDate)
                .build();
    }
}
