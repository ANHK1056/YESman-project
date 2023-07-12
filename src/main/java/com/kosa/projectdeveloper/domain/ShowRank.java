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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranks")
    private Long ranks;

    @Column
    private String rankId;

    @OneToOne
    @JoinColumn(name = "show_id", nullable = false)
    private ShowDetail showDetail;

    @Builder
    public ShowRank (String rankId, ShowDetail showDetail){
        this.rankId = rankId;
        this.showDetail = showDetail;
    }

}
