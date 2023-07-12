package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.domain.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTestRepository extends JpaRepository<UserTest, Long> {
    Optional<UserTest> findByUserId(Long userId);
}
