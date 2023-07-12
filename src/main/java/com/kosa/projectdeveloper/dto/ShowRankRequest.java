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

    public ShowRank toEntity(){
        return ShowRank.builder()
                .rankId(rankId)
                .showDetail(showDetail)
                .build();
    }
}
