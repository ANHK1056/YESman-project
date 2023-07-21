package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="shows")
public class Show {


    // 연극 ID
    @Id
    @Column(name = "show_id", updatable = false)
    private String showId;

    // 연극명
    @Column(name = "show_name", updatable = false)
    private String showName;

    // 연극 시작 일자
    @Column(name = "show_start_date", updatable = false)
    private String showStartDate;

    // 연극 종료 일자
    @Column(name = "show_end_date", updatable = false)
    private String showEndDate;

    // 시설명
    @Column(name = "facility_name", updatable = false)
    private String facilityName;

    // 오픈런 여부
    @Column(name = "show_open_run", updatable = false)
    private String showOpenRun;

    // 포스터 이미지 URL
    @Column(name = "poster", updatable = false)
    private String poster;

    // 장르
    @Column(name = "show_genre", updatable = false)
    private String showGenre;

    // 연극 상태 (상영 중, 완료 등)
    @Column(name = "show_state", updatable = false)
    private String showState;

    @Builder
    public Show(String showId, String showName,String showStartDate, String showEndDate,
                String facilityName ,String showOpenRun, String poster, String showGenre, String showState) {
        this.showId = showId;
        this.showName = showName;
        this.showStartDate = showStartDate;
        this.showEndDate = showEndDate;
        this.facilityName = facilityName;
        this.showOpenRun = showOpenRun;
        this.poster = poster;
        this.showGenre = showGenre;
        this.showState = showState;
    }


}
