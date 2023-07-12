package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import lombok.Getter;

@Getter
public class ShowRequest {
    private String showId;
    private String showName;
    private String showStartDate;
    private String showEndDate;
    private String facilityName;
    private String showOpenRun;
    private String poster;
    private String showGenre;
    private String showState;


    public ShowRequest(String showId, String showName, String showStartDate, String showEndDate,
                String facilityId, String showHall, String showGenre, String showState) {
    }

    @Override
    public String toString() {
        return "Show{" +
                "show_id='" + showId + '\'' +
                ", show_name='" + showName + '\'' +
                ", show_start_date='" + showStartDate + '\'' +
                ", show_end_date='" + showEndDate + '\'' +
                ", show_hall='" + showOpenRun + '\'' +
                ", location='" + poster + '\'' +
                ", show_genre='" + showGenre + '\'' +
                ", show_state='" + showState + '\'' +
                '}';
    }

    public Show toEntity() {
        return Show.builder()
                .showId(showId)
                .showName(showName)
                .showStartDate(showStartDate)
                .showEndDate(showEndDate)
                .facilityName(facilityName)
                .showOpenRun(showOpenRun)
                .poster(poster)
                .showGenre(showGenre)
                .showState(showState)
                .build();
    }
}
