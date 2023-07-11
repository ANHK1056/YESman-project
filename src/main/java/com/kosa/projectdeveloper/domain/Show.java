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
public class Show {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id", updatable = false)
    private String show_id;

    @Column(name = "show_name", updatable = false)
    private String show_name;

    @Column(name = "show_start_date", updatable = false)
    private String show_start_date;

    @Column(name = "show_end_date", updatable = false)
    private String show_end_date;

    @Column(name = "facility_id", updatable = false)
    private String facility_id;

    @Column(name = "show_hall", updatable = false)
    private String show_hall;

    @Column(name = "location", updatable = false)
    private String location;

    @Column(name = "show_genre", updatable = false)
    private String show_genre;

    @Column(name = "show_state", nullable = false)
    private String show_state;

    // ShowReview 랑 Join 위해 넣었어요..!
    @OneToMany(mappedBy = "review_Id")
    private List<ShowReview> showReviews = new ArrayList<>();


    @Builder
    public Show(String show_id, String show_name,String show_start_date, String show_end_date,String facility_id ,String show_hall, String location, String show_genre, String show_state) {
        this.show_id = show_id;
        this.show_name = show_name;
        this.show_start_date = show_start_date;
        this.show_end_date = show_end_date;
        this.facility_id = facility_id;
        this.show_hall = show_hall;
        this.location = location;
        this.show_genre = show_genre;
        this.show_state = show_state;
    }

}
