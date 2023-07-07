package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class AddShowReviewRequest {

    private String title;
    private String content;

    public Show toEntity() {
        return Show.builder()
                .title(title)
                .content(content)
                .build();
    }


}
