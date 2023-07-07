package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByTokenId(Long tokenid);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);

}
