package com.kosa.projectdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ShowLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locations", updatable = false)
    private Long locations;

    @Column(name = "location_address")
    private String locationAddress;

    @OneToOne
    @JoinColumn(name = "show_id", nullable = false)
    private ShowDetail showDetail;

    @Builder
    public ShowLocation (String locationAddress, ShowDetail showDetail){
        this.locationAddress = locationAddress;
        this.showDetail = showDetail;
    }


}
