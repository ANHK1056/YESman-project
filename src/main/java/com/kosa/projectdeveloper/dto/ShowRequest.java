package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import lombok.Getter;

@Getter
public class ShowRequest {
    private String show_id;
    private String show_name;
    private String show_start_date;
    private String show_end_date;
    private String facility_id;
    private String show_hall;
    private String location;
    private String show_genre;
    private String show_state;


    public ShowRequest(String showId, String showName, String showStartDate, String showEndDate,
                String facilityId, String showHall, String showGenre, String showState) {
    }

    @Override
    public String toString() {
        return "Show{" +
                "show_id='" + show_id + '\'' +
                ", show_name='" + show_name + '\'' +
                ", show_start_date='" + show_start_date + '\'' +
                ", show_end_date='" + show_end_date + '\'' +
                ", show_hall='" + show_hall + '\'' +
                ", location='" + location + '\'' +
                ", show_genre='" + show_genre + '\'' +
                ", show_state='" + show_state + '\'' +
                '}';
    }

    public Show toEntity() {
        return Show.builder()
                .show_id(show_id)
                .show_name(show_name)
                .show_start_date(show_start_date)
                .show_end_date(show_end_date)
                .facility_id(facility_id)
                .show_hall(show_hall)
                .location(location)
                .show_genre(show_genre)
                .show_state(show_state)
                .build();
    }
}
