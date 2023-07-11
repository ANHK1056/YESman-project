package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service

public class ShowReviewService {

    private  final ShowReviewRepository showReviewRepository;

    // 리뷰 생성
    public ShowReview save(AddShowReviewRequest request) {
        return showReviewRepository.save(request.toEntity());
    }

    // 모든 리뷰 조회
    public List<ShowReview> findAll() {
        return showReviewRepository.findAll();
    }

    // 리뷰 수정
    public ShowReview updateShowReview(ShowReview showReview) {
        return showReviewRepository.save(showReview);
    }

    // 리뷰 삭제
    // Collections.singleton(review_id) 이렇게 쓰는게 맞는지 잘 모르겠어요,,
    public void deleteShowReview(Long review_id) {
        showReviewRepository.deleteAllById(Collections.singleton(review_id));
    }


}