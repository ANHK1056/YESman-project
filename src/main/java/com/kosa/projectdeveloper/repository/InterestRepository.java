package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
}
