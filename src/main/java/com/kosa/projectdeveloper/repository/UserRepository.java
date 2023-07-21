//유저 정보를 저장 및 조회하는 repository
package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail);
    Optional<User> findByUserId(Long userId);

}
