package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.dto.FriendReviewAddResponse;
import com.kosa.projectdeveloper.dto.FriendUpdateRequest;
import com.kosa.projectdeveloper.repository.FriendRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FriendService {

    private final FriendRepository friendRepository;

    // 글 작성
    public FriendReview save(FriendReviewAddResponse friendReviewAddResponse) {
        return friendRepository.save(friendReviewAddResponse.toEntity());
    }

    // 글 목록 조회
    public List<FriendReview> findAll() {
        return friendRepository.findAll();
    }

    // 글 조회
    public FriendReview findById(long id) {
        return friendRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 글 삭제
    public void deleteById(long id) {
        friendRepository.deleteById(id);
    }

    // 글 수정
    @Transactional
    public FriendReview updateFriendReview(long id, FriendUpdateRequest friendUpdateRequest) {
        FriendReview friendReview = friendRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        friendReview.update(friendUpdateRequest.getTitle(), friendUpdateRequest.getContent());

        return friendReview;

    }


}


