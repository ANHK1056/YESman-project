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


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id", updatable = false)
    private String showId;

    @Column(name = "facility_id", updatable = false)
    private String facilityId;

    @Column(name = "show_name", updatable = false)
    private String showName;

    @Column(name = "show_start_date", updatable = false)
    private String showStartDate;

    @Column(name = "show_end_date", updatable = false)
    private String showEndDate;

    @Column(name = "facility_name", updatable = false)
    private String facilityName;

    @Column(name = "show_actor", updatable = false)
    private String showActor;

    @Column(name = "show_age", updatable = false)
    private String showAge;

    @Column(name = "runtime", updatable = false)
    private String runtime;

    @Column(name = "company", updatable = false)
    private String company;

    @Column(name = "show_price", updatable = false)
    private String showPrice;

    @Column(name = "poster", updatable = false)
    private String poster;

    @Column(name = "show_state", updatable = false)
    private String showState;

    @Column(name = "show_genre", updatable = false)
    private String showGenre;

    @Column(name = "show_image1", updatable = false)
    private String showImage1;

    @Column(name = "show_image2", updatable = false)
    private String showImage2;

    @Column(name = "show_image3", updatable = false)
    private String showImage3;

    @Column(name = "show_image4", updatable = false)
    private String showImage4;

    @Column(name = "show_date", updatable = false)
    private String showDate;

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
