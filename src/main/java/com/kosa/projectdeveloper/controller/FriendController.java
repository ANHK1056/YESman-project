package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.dto.*;
import com.kosa.projectdeveloper.repository.FriendRepository;
import com.kosa.projectdeveloper.repository.UserRepository;
import com.kosa.projectdeveloper.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FriendController {
    private final FriendService friendService;
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    // 커뮤니티 글 작성
    @PostMapping("/api/friend")
    public ResponseEntity<FriendReview> addFriend(@RequestBody FriendReviewAddResponse friendReviewAddResponse) {

        System.out.println("UserEmail api : " + friendReviewAddResponse.getUserEmail());

        User user = userRepository.findByUserEmail(friendReviewAddResponse.getUserEmail()).orElse(null);

        System.out.println("UserEmail user : " + user.getUserEmail());

        FriendReview friendReview = FriendReview.builder()
                .user(user)
                .title(friendReviewAddResponse.getTitle())
                .content(friendReviewAddResponse.getContent())
                .build();
        FriendReview saveFriendReview = friendRepository.save(friendReview);

        System.out.println("UserEmail friend : " + saveFriendReview.getUser().getUserEmail());
//        FriendReview saveFriendReview = friendService.save(friendReviewAddResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveFriendReview);
    }


    // 커뮤니티 글 목록 조회
    @GetMapping("/api/friend")
    public ResponseEntity<List<FriendResponse>> friedResponse() {
        List<FriendResponse> friendResponses = friendService.findAll()
                .stream()
                .map(FriendResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(friendResponses);
    }

    // 커뮤니티 글 조회
    @GetMapping("/api/friend/{id}")
    public ResponseEntity<FriendResponse> friedResponse(@PathVariable long id) {
        FriendReview friendResponses = friendService.findById(id);

        return ResponseEntity.ok()
                .body(new FriendResponse(friendResponses));
    }

    // 커뮤니티 글 수정
    @PutMapping("/api/friend/{id}")
    public ResponseEntity<FriendReview> updateFriendReview(
            @PathVariable Long id, @RequestBody FriendUpdateRequest request) {
        FriendReview updateFriendReview = friendService.updateFriendReview(id, request);

        return ResponseEntity.ok()
                .body(updateFriendReview);

    }

    // 커뮤니티 글 삭제
    @DeleteMapping("/api/friend/{id}")
    public ResponseEntity<Void> deleteFriendReview(@PathVariable Long id) {
        friendService.deleteById(id);

        return ResponseEntity.ok()
                .build();
    }

}




