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

    public ShowLocation toEntity() {
        return ShowLocation.builder()
                .locationAddress(locationAddress)
                .showDetail(showDetail)
                .build();
    }
}
