package com.kosa.projectdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShowDto {
    private String show_id;
    private String facility_id;
    private String show_name;
    private String show_start_date;
    private String show_end_date;
    private String show_hall;
    private String show_actor;
    private String show_age;
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


    public String getShow_id() {
        return show_id;
    }

    public String getFacility_id() {
        return facility_id;
    }

    public String getShow_name() {
        return show_name;
    }

    public String getShow_start_date() {
        return show_start_date;
    }

    public String getShow_end_date() {
        return show_end_date;
    }

    public String getShow_hall() {
        return show_hall;
    }

    public String getShow_actor() {
        return show_actor;
    }

    public String getShow_age() {
        return show_age;
    }

    public String getCompany() {
        return company;
    }

    public String getShow_price() {
        return show_price;
    }

    public String getLocation() {
        return location;
    }

    public String getShow_genre() {
        return show_genre;
    }

    public String getShow_state() {
        return show_state;
    }

    public String getShow_image1() {
        return show_image1;
    }

    public String getShow_image2() {
        return show_image2;
    }

    public String getShow_image3() {
        return show_image3;
    }

    public String getShow_image4() {
        return show_image4;
    }

    public String getShow_time() {
        return show_time;
    }

    public String getShow_content() {
        return show_content;
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


}



