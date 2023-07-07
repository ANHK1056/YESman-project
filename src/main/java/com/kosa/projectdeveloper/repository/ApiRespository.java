package com.kosa.projectdeveloper.repository;


import com.kosa.projectdeveloper.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiRespository extends JpaRepository<Show, String> {

    Optional<Show> findById(String show_id);

}

