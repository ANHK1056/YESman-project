package com.kosa.projectdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowReviewRepository extends JpaRepository<ShowReview, Long> {

    Optional<ShowReview> findById(long reviewId);
}
