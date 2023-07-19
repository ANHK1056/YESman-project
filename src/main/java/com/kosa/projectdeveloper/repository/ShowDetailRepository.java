package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.ShowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ShowDetailRepository extends JpaRepository<ShowDetail, String> {

    // 출연진에 대한 검색어를 통한 검색
    public List<ShowDetail> findByShowActorContaining(String actorName);

    // 연극명에 대한 검색어를 이용한 검색
    public List<ShowDetail> findByShowNameContaining(String showName);

    // 시설명에 대한 검색어를 이용한 검색
    public List<ShowDetail> findByFacilityNameContaining(String facilityName);

}
