package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
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

    public Book toEntity() {
        return Book.builder()
                .user(user)
                .show(show)
                .seat(seat)
                .showDate(showDate)
                .build();
    }
}
