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

    public FriendReview save(FriendReviewAddResponse friendReviewAddResponse) {
        return friendRepository.save(friendReviewAddResponse.toEntity());
    }

    public List<FriendReview> findAll() {
        return friendRepository.findAll();
    }

    public FriendReview findById(long id) {
        return friendRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deleteById(long id) {
        friendRepository.deleteById(id);
    }

    @Transactional
    public FriendReview updateFriendReview(long id, FriendUpdateRequest friendUpdateRequest) {
        FriendReview friendReview = friendRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        friendReview.update(friendUpdateRequest.getTitle(), friendUpdateRequest.getContent());

        return friendReview;

    }


}


