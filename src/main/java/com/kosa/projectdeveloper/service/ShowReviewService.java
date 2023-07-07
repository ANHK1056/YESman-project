package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class ShowReviewService {

    private final ShowReviewRepository showReviewRepository;

    public Show save(AddShowReviewRequest request) {
        return showReviewRepository.save(request.toEntity());
    }


}
