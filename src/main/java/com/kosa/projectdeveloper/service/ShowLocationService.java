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

    public ShowLocation save(ShowLocationRequest request) {
        return showLocationRepository.save(request.toEntity());
    }

    public List<ShowLocation> findAll() {
        return showLocationRepository.findAll();
    }
}
