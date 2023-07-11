package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.ShowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowDetailRepository extends JpaRepository<ShowDetail, String> {

//    Optional<ShowDetail> findByShow_Id(String show_id);
}
