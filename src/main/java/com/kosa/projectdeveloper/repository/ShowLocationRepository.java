package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.ShowLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowLocationRepository extends JpaRepository<ShowLocation, Long> {

    public List<ShowLocation> findByLocationAddressContaining(String specificAddress);
}
