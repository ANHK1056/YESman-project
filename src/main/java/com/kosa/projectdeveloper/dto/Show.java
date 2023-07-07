package com.kosa.projectdeveloper.dto;

public class Show {
    private String show_id;
    private String show_name;
    private String show_start_date;
    private String show_end_date;
    private String show_hall;
    private String show_genre;
    private String show_state;

    public String getShow_id() {
        return show_id;
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

    public String getShow_genre() {
        return show_genre;
    }

    public String getShow_state() {
        return show_state;
    }

    @Override
    public String toString() {
        return "Show{" +
                "show_id='" + show_id + '\'' +
                ", show_name='" + show_name + '\'' +
                ", show_start_date='" + show_start_date + '\'' +
                ", show_end_date='" + show_end_date + '\'' +
                ", show_hall='" + show_hall + '\'' +
                ", show_genre='" + show_genre + '\'' +
                ", show_state='" + show_state + '\'' +
                '}';
    }
}
