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
    private String show_id;

    @Column(name = "facility_id", updatable = false)
    private String facility_id;

    @Column(name = "show_name", updatable = false)
    private String show_name;

    @Column(name = "show_start_date", updatable = false)
    private String show_start_date;

    @Column(name = "show_end_date", updatable = false)
    private String show_end_date;

    @Column(name = "show_hall", updatable = false)
    private String show_hall;

    @Column(name = "show_actor", updatable = false)
    private String show_actor;

    @Column(name = "show_age", updatable = false)
    private String show_age;

    @Column(name = "runtime", updatable = false)
    private String runtime;

    @Column(name = "company", updatable = false)
    private String company;

    @Column(name = "show_price", updatable = false)
    private String show_price;

    @Column(name = "location", updatable = false)
    private String location;

    @Column(name = "show_state", updatable = false)
    private String show_state;

    @Column(name = "show_genre", updatable = false)
    private String show_genre;

    @Column(name = "show_image1", updatable = false)
    private String show_image1;

    @Column(name = "show_image2", updatable = false)
    private String show_image2;

    @Column(name = "show_image3", updatable = false)
    private String show_image3;

    @Column(name = "show_image4", updatable = false)
    private String show_image4;

    @Column(name = "show_time", updatable = false)
    private String show_time;

    @Column(name = "show_content", updatable = false)
    private String show_content;


    @Builder
    public ShowDetail(String show_id, String facility_id, String show_name, String show_start_date, String show_end_date,
                      String show_hall, String show_actor, String show_age,String runtime ,String company, String show_price, String location,
                      String show_genre, String show_state, String show_image1, String show_image2, String show_image3,
                      String show_image4, String show_time, String show_content) {
        this.show_id = show_id;
        this.facility_id = facility_id;
        this.show_name = show_name;
        this.show_start_date = show_start_date;
        this.show_end_date = show_end_date;
        this.show_hall = show_hall;
        this.show_actor = show_actor;
        this.show_age = show_age;
        this.runtime = runtime;
        this.company = company;
        this.show_price = show_price;
        this.location = location;
        this.show_genre = show_genre;
        this.show_state = show_state;
        this.show_image1 = show_image1;
        this.show_image2 = show_image2;
        this.show_image3 = show_image3;
        this.show_image4 = show_image4;
        this.show_time = show_time;
        this.show_content = show_content;



    }



}
