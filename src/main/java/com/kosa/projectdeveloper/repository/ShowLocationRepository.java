package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.ShowLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowLocationRepository extends JpaRepository<ShowLocation, Long> {

    // 시설 주소 검색어를 통한 검색(서울 지역 카테고리 세분화)
    public List<ShowLocation> findByLocationAddressContaining(String specificAddress);

}
