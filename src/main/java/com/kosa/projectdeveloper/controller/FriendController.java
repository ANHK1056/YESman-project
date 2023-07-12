package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.*;
import com.kosa.projectdeveloper.repository.FriendRepository;
import com.kosa.projectdeveloper.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/api/friend")
    public ResponseEntity<FriendReview> addFriend(@RequestBody FriendReviewAddResponse friendReviewAddResponse) {
        FriendReview saveFriendReview = friendService.save(friendReviewAddResponse);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveFriendReview);
    }

    @GetMapping("/api/friend")
    public ResponseEntity<List<FriendResponse>> friedResponse() {
        List<FriendResponse> friendResponses = friendService.findAll()
                .stream()
                .map(FriendResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(friendResponses);
    }

    @GetMapping("/api/friend/{id}")
    public ResponseEntity<FriendResponse> friedResponse(@PathVariable long id) {
        FriendReview friendResponses = friendService.findById(id);

        return ResponseEntity.ok()
                .body(new FriendResponse(friendResponses));
    }

    @PutMapping("/api/friend/{id}")
    public ResponseEntity<FriendReview> updateFriendReview(
            @PathVariable Long id, @RequestBody FriendUpdateRequest request) {
        FriendReview updateFriendReview = friendService.updateFriendReview(id, request);

                return ResponseEntity.ok()
                .body(updateFriendReview);

//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedfreind);

    }

    @DeleteMapping("/api/friend/{id}")
    public ResponseEntity<Void> deleteFriendReview(@PathVariable Long id) {
        friendService.deleteById(id);

        return ResponseEntity.ok()
                .build();
    }

}


