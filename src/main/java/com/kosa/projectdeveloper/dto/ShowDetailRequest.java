package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.ShowDetail;
import lombok.Getter;

@Getter
public class ShowDetailRequest {
    private String showId;
    private String facilityId;
    private String showName;
    private String showStartDate;
    private String showEndDate;
    private String facilityName;
    private String showActor;
    private String showAge;
    private String runtime;
    private String company;
    private String showPrice;
    private String poster;
    private String showGenre;
    private String showState;
    private String showImage1;
    private String showImage2;
    private String showImage3;
    private String showImage4;
    private String showDate;
    private String showContent;

    private String userEmail;

    public ShowDetailRequest(String showId, String facilityId, String showName, String showStartDate,  String showEndDate,
                             String facilityName, String showActor, String showAge,String runtime ,String company,
                             String showPrice, String poster, String showGenre, String showState, String showImage1,
                             String showImage2, String showImage3, String showImage4, String showDate, String showContent) {

    }


    @Override
    public String toString() {
        return "ShowDto{" +
                "show_id='" + showId + '\'' +
                ", facility_id='" + facilityId + '\'' +
                ", show_name='" + showName + '\'' +
                ", show_start_date='" + showStartDate + '\'' +
                ", show_end_date='" + showEndDate + '\'' +
                ", show_hall='" + facilityName + '\'' +
                ", show_actor='" + showActor + '\'' +
                ", show_age='" + showAge + '\'' +
                ", runtime='" + runtime + '\'' +
                ", company='" + company + '\'' +
                ", show_price='" + showPrice + '\'' +
                ", location='" + poster + '\'' +
                ", show_genre='" + showGenre + '\'' +
                ", show_state='" + showState + '\'' +
                ", show_image1='" + showImage1 + '\'' +
                ", show_image2='" + showImage2 + '\'' +
                ", show_image3='" + showImage3 + '\'' +
                ", show_image4='" + showImage4 + '\'' +
                ", show_time='" + showDate + '\'' +
                ", show_content='" + showContent + '\'' +
                '}';
    }


    public ShowDetail toEntity() {
        return ShowDetail.builder()
                .showId(showId)
                .facilityId(facilityId)
                .showName(showName)
                .showStartDate(showStartDate)
                .showEndDate(showEndDate)
                .facilityName(facilityName)
                .showActor(showActor)
                .showAge(showAge)
                .runtime(runtime)
                .company(company)
                .showPrice(showPrice)
                .poster(poster)
                .showGenre(showGenre)
                .showState(showState)
                .showImage1(showImage1)
                .showImage2(showImage2)
                .showImage3(showImage3)
                .showImage4(showImage4)
                .showDate(showDate)
                .showContent(showContent)
                .build();



    }
}
