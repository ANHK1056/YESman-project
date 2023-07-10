package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class ShowReviewService {

    private final ShowReviewRepository showReviewRepository;

    public ShowReview save(AddShowReviewRequest request) {
        return showReviewRepository.save(request.toEntity());
    }

    public List<ShowReview> findAllShowReview(){
        return showReviewRepository.findAll();
    }
}
