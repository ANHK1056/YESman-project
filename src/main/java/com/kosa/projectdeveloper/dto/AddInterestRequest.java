package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Interest;
import com.kosa.projectdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddInterestRequest {
    private String actorName;
    private User user;

    private String userEmail;

    public Interest toEntity() {
        return Interest.builder()
                .actorName(actorName)
                .user(user)
                .build();
    }
}
