package com.kosa.projectdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class UpdateShowReviewRequest {

    private String reviewTitle;
    private String reviewContent;

}

