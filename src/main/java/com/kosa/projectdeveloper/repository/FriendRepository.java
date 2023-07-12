package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.FriendReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<FriendReview, Long> {

   Optional<FriendReview> findById(long id);
}
