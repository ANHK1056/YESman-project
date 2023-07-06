package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // TODO: 2023-07-05 User_id로 사용자 정보를 가져올 때 사용

    Optional<User> findByUserEmail(String userEmail);

}
