package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.RefreshToken;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.UpdateUserRequest;
import com.kosa.projectdeveloper.repository.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }

}

