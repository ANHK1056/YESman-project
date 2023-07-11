package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FriendUpdateRequest {
    private User userId;
    private  String title;
    private  String content;
    private  LocalDateTime createdAt;

}


