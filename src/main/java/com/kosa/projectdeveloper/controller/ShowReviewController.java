package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;
import com.kosa.projectdeveloper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ShowReviewController {

    private final ShowReviewRepository showReviewRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    @Autowired
    public ShowReviewController(ShowReviewRepository showReviewRepository, UserRepository userRepository, ShowRepository showRepository) {
        this.showReviewRepository = showReviewRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    // 모든 리뷰 조회
    @GetMapping
    public ResponseEntity<List<ShowReview>> getAllReviews() {
        List<ShowReview> reviews = ShowReviewRepository.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 특정 리뷰 조회
    @GetMapping("/{id}")
    public ResponseEntity<ShowReview> getReviewById(@PathVariable Long id) {
        ShowReview showReview = showReviewRepository.findById(id).orElse(null);
        if (showReview != null) {
            return new ResponseEntity<>(showReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 새로운 리뷰 작성
    @PostMapping
    public ResponseEntity<ShowReview> createReview(@RequestBody ShowReview showReview) {
        User user = userRepository.findById(showReview.getUser().getUserId()).orElse(null);
        Show show = ShowRepository.findById(showReview.getShow().getShow_id()).orElse(null);
        if (user != null && show != null) {
            showReview.setUser(user);
            showReview.setShow(Show);
            showReview.setDate(new Date());
            showReview savedReview = ShowReviewRepository.save(showReview);
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 리뷰 수정
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setContent(updatedReview.getContent());
            Review savedReview = reviewRepository.save(review);
            return new ResponseEntity<>(savedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 리뷰 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            reviewRepository.delete(review);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
