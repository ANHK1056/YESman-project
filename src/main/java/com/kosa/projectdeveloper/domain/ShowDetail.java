package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ShowDetail {

    // 연극 ID
    @Id
    @Column(name = "show_id", updatable = false)
    private String showId;

    // 시설 ID
    @Column(name = "facility_id", updatable = false)
    private String facilityId;

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

    // 출연진
    @Column(name = "show_actor", updatable = false)
    private String showActor;

    // 관람 연령
    @Column(name = "show_age", updatable = false)
    private String showAge;

    // 상영길이
    @Column(name = "runtime", updatable = false)
    private String runtime;

    // 제작사
    @Column(name = "company", updatable = false)
    private String company;

    // 표값
    @Column(name = "show_price", updatable = false)
    private String showPrice;

    // 포스터 이미지 경로
    @Column(name = "poster", updatable = false)
    private String poster;

    // 연극 상태 (연극 중, 완료 등)
    @Column(name = "show_state", updatable = false)
    private String showState;

    // 연극 장르
    @Column(name = "show_genre", updatable = false)
    private String showGenre;

    // 연극 상세 이미지1
    @Column(name = "show_image1", updatable = false)
    private String showImage1;

    // 연극 상세 이미지2
    @Column(name = "show_image2", updatable = false)
    private String showImage2;

    // 연극 상세 이미지3
    @Column(name = "show_image3", updatable = false)
    private String showImage3;

    // 연극 상세 이미지4
    @Column(name = "show_image4", updatable = false)
    private String showImage4;

    // 연극 상영 일자
    @Column(name = "show_date", updatable = false)
    private String showDate;

    // 연극 내용
    @Column(name = "show_content", updatable = false)
    private String showContent;


    @Builder
    public ShowDetail(String showId, String facilityId, String showName, String showStartDate, String showEndDate,
                      String facilityName, String showActor, String showAge,String runtime ,String company,
                      String showPrice, String poster, String showGenre, String showState,
                      String showImage1, String showImage2, String showImage3, String showImage4,
                      String showDate, String showContent) {
        this.showId = showId;
        this.facilityId = facilityId;
        this.showName = showName;
        this.showStartDate = showStartDate;
        this.showEndDate = showEndDate;
        this.facilityName = facilityName;
        this.showActor = showActor;
        this.showAge = showAge;
        this.runtime = runtime;
        this.company = company;
        this.showPrice = showPrice;
        this.poster = poster;
        this.showGenre = showGenre;
        this.showState = showState;
        this.showImage1 = showImage1;
        this.showImage2 = showImage2;
        this.showImage3 = showImage3;
        this.showImage4 = showImage4;
        this.showDate = showDate;
        this.showContent = showContent;



    }



}
