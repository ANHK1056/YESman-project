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


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id", updatable = false)
    private String showId;

    @Column(name = "show_name", updatable = false)
    private String showName;

    @Column(name = "show_start_date", updatable = false)
    private String showStartDate;

    @Column(name = "show_end_date", updatable = false)
    private String showEndDate;

    @Column(name = "facility_name", updatable = false)
    private String facilityName;

    @Column(name = "show_open_run", updatable = false)
    private String showOpenRun;

    @Column(name = "poster", updatable = false)
    private String poster;

    @Column(name = "show_genre", updatable = false)
    private String showGenre;

    @Column(name = "show_state", updatable = false)
    private String showState;

//    // ShowReview 랑 Join 위해 넣었어요..!
//    @OneToMany(mappedBy = "review_Id")
//    private List<ShowReview> showReviews = new ArrayList<>();




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
