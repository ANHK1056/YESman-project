package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowRank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShowRankRequest {
    private String rankId;
    private ShowDetail showDetail;

    // 유저 정보, 연극 정보 위한 필드
    private String userEmail;
    private String showId;

    public ShowRank toEntity(){
        return ShowRank.builder()
                .rankId(rankId)
                .showDetail(showDetail)
                .build();
    }
}
