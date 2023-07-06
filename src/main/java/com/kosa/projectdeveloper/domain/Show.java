package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Show {

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

    @Column(name = "company", updatable = false)
    private String company;

    @Column(name = "show_price", updatable = false)
    private String show_price;

    @Column(name = "location", updatable = false)
    private String location;

    @Column(name = "show_state", updatable = false)
    private String show_state;

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



}
