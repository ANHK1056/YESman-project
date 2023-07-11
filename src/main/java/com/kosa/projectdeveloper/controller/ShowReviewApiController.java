package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.dto.ShowReviewResponse;
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

//    @PutMapping("/{id}")
//    public ResponseEntity<ShowReview> updateShowReview(
//            @PathVariable("id") Long id, @RequestBody ShowReview showReview) {
//        showReview.setId(id);
//        ShowReview updatedShowReview = showReviewService.updateShowReview(showReview);
//        if (updatedShowReview != null) {
//            return new ResponseEntity<>(updatedShowReview, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteShowReview(@PathVariable("id") Long id) {
//        showReviewService.deleteShowReview(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
