package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.dto.ShowReviewResponse;
import com.kosa.projectdeveloper.dto.UpdateShowReviewRequest;

import com.kosa.projectdeveloper.service.ShowReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ShowReviewApiController {

    private final ShowReviewService showReviewService;

    // 리뷰 생성
    @PostMapping("/api/show-review")
    public ResponseEntity<ShowReview> addShowReview(@RequestBody AddShowReviewRequest request) {
        ShowReview savedShowreview = showReviewService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedShowreview);
    }

    // 리뷰 목록 조회
    @GetMapping("/api/show-review")
    public ResponseEntity<List<ShowReviewResponse>> findAllShowreview() {
        List<ShowReviewResponse> showReviews = showReviewService.findAll()
                .stream()
                .map(ShowReviewResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(showReviews);
    }
    // 리뷰 수정
    @PutMapping("/api/show-review/{review_id}")
    public ResponseEntity<ShowReview> updateShowReview(
            @PathVariable Long review_id, @RequestBody UpdateShowReviewRequest request) {
        ShowReview updatedShowReview = showReviewService.update(review_id, request);

        return ResponseEntity.ok()
                .body(updatedShowReview);
    }

    // 리뷰 삭제
    @DeleteMapping("/api/show-review/{review_id}")
    public ResponseEntity<Void> deleteShowReview(@PathVariable Long review_id) {
        showReviewService.delete(review_id);

        return ResponseEntity.ok()
                .build();
    }

}
