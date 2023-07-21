package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Book;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.dto.UpdateShowReviewRequest;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;

import jakarta.transaction.Transactional;
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
    @Transactional
    public ShowReview update(long id, UpdateShowReviewRequest request) {

        ShowReview showReview = showReviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        showReview.update(request.getReviewTitle(), request.getReviewContent());

        return showReview;
    }

    //리뷰 글 조회
    public ShowReview findByShowReviewId(long showReviewId){
        return showReviewRepository.findById(showReviewId)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + showReviewId));
    }

    // 리뷰 삭제
    public void delete(Long review_id) {
        showReviewRepository.deleteById(review_id);

    }


}

