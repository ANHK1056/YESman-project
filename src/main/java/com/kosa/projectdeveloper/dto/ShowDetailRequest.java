package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.ShowDetail;
import lombok.Getter;

@Getter
public class ShowDetailRequest {
    private String show_id;
    private String facility_id;
    private String show_name;
    private String show_start_date;
    private String show_end_date;
    private String show_hall;
    private String show_actor;
    private String show_age;
    private String runtime;
    private String company;
    private String show_price;
    private String location;
    private String show_genre;
    private String show_state;
    private String show_image1;
    private String show_image2;
    private String show_image3;
    private String show_image4;
    private String show_time;
    private String show_content;

    public ShowDetailRequest(String show_id, String facility_id, String show_name, String show_start_date,  String show_end_date,
                      String show_hall, String show_actor, String show_age,String runtime ,String company, String show_price, String location,
                      String show_genre, String show_state, String show_image1, String show_image2, String show_image3,
                      String show_image4, String show_time, String show_content) {

    }


    @Override
    public String toString() {
        return "ShowDto{" +
                "show_id='" + show_id + '\'' +
                ", facility_id='" + facility_id + '\'' +
                ", show_name='" + show_name + '\'' +
                ", show_start_date='" + show_start_date + '\'' +
                ", show_end_date='" + show_end_date + '\'' +
                ", show_hall='" + show_hall + '\'' +
                ", show_actor='" + show_actor + '\'' +
                ", show_age='" + show_age + '\'' +
                ", runtime='" + runtime + '\'' +
                ", company='" + company + '\'' +
                ", show_price='" + show_price + '\'' +
                ", location='" + location + '\'' +
                ", show_genre='" + show_genre + '\'' +
                ", show_state='" + show_state + '\'' +
                ", show_image1='" + show_image1 + '\'' +
                ", show_image2='" + show_image2 + '\'' +
                ", show_image3='" + show_image3 + '\'' +
                ", show_image4='" + show_image4 + '\'' +
                ", show_time='" + show_time + '\'' +
                ", show_content='" + show_content + '\'' +
                '}';
    }


    public ShowDetail toEntity() {
        return ShowDetail.builder()
                .show_id(show_id)
                .facility_id(facility_id)
                .show_name(show_name)
                .show_start_date(show_start_date)
                .show_end_date(show_end_date)
                .show_hall(show_hall)
                .show_actor(show_actor)
                .show_age(show_age)
                .runtime(runtime)
                .company(company)
                .show_price(show_price)
                .location(location)
                .show_genre(show_genre)
                .show_state(show_state)
                .show_image1(show_image1)
                .show_image2(show_image2)
                .show_image3(show_image3)
                .show_image4(show_image4)
                .show_time(show_time)
                .show_content(show_content)
                .build();



    }
}
