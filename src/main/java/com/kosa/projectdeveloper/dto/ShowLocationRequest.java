package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShowLocationRequest {
    private String locationAddress;
    private ShowDetail showDetail;

    // 유저 정보, 연극 정보 위한 필드
    private String userEmail;
    private String showId;

    public ShowLocation toEntity() {
        return ShowLocation.builder()
                .locationAddress(locationAddress)
                .showDetail(showDetail)
                .build();
    }
}
