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

    // 장소 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locations", updatable = false)
    private Long locations;

    // 연극 시설 주소
    @Column(name = "location_address")
    private String locationAddress;

    // 연극 상세 정보와 관계 형성
    @OneToOne
    @JoinColumn(name = "show_id", nullable = false)
    private ShowDetail showDetail;

    @Builder
    public ShowLocation (String locationAddress, ShowDetail showDetail){
        this.locationAddress = locationAddress;
        this.showDetail = showDetail;
    }


}
