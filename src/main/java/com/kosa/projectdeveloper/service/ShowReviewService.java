package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class ShowReviewService {

    private final ShowRepository showRepository;

    public Show save(AddShowReviewRequest request) {
        return showRepository.save(request.toEntity());
    }


}
