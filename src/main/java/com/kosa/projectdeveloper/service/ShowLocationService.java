package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.ShowLocation;
import com.kosa.projectdeveloper.dto.ShowLocationRequest;
import com.kosa.projectdeveloper.repository.ShowLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowLocationService {

    private ShowLocationRepository showLocationRepository;

    // 연극 주소 엔티티 저장
    public ShowLocation save(ShowLocationRequest request) {
        return showLocationRepository.save(request.toEntity());
    }

    // 연극 주소 목록 조회
    public List<ShowLocation> findAll() {
        return showLocationRepository.findAll();
    }
}
