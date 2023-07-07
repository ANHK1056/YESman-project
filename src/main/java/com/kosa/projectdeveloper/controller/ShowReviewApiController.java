package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.AddShowReviewRequest;
import com.kosa.projectdeveloper.service.ShowReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShowReviewApiController {

    private  final ShowReviewService showReviewService;

    @PostMapping("/api/show")
    public ResponseEntity<Show> addShow(@RequestBody AddShowReviewRequest request) {
        Show savedShow = showReviewService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedShow);
    }

}
