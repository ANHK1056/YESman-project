package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.ShowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailApiRespository extends JpaRepository<ShowDetail, String> {

    Optional<ShowDetail> findById(String show_id);

}