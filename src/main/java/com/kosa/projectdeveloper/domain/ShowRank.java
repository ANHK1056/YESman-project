package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ShowRank {

    // 연극 랭킹 수
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranks")
    private Long ranks;

    // 연극 랭킹 순위
    @Column
    private String rankId;

    // 연극 상세 정보와 관계 형성
    @OneToOne
    @JoinColumn(name = "show_id", nullable = false)
    private ShowDetail showDetail;

    @Builder
    public ShowRank (String rankId, ShowDetail showDetail){
        this.rankId = rankId;
        this.showDetail = showDetail;
    }

}
