package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.dto.FriendListViewResponse;
import com.kosa.projectdeveloper.dto.FriendViewResponse;
import com.kosa.projectdeveloper.repository.FriendRepository;
import com.kosa.projectdeveloper.service.FriendService;
import com.kosa.projectdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class FriendViewController {
    private final FriendService friendService;
    private final UserService userService;
    private final FriendRepository friendRepository;

    // 커뮤니티 글 목록 조회 매핑
    @GetMapping("/friends")
    public String getFriends(Model model) {
        List<FriendListViewResponse> friends = friendService.findAll()
                .stream()
                .map(FriendListViewResponse::new)
                .toList();


        List<FriendReview> friendReviewList = friendRepository.findAll();

        model.addAttribute("friends", friends);
        model.addAttribute("friendsList", friendReviewList);

        return "FriendView";
    }

    // 커뮤니티 글 조회 매핑
    @GetMapping("/friends/{id}")
    public String getFriend(@PathVariable Long id, Model model) {
        FriendReview friendReview = friendService.findById(id);
        model.addAttribute("friendReview", new FriendViewResponse(friendReview));

        return "text_userFriendList";
    }

    // 커뮤니티 글 작성 시 JS 통해 작성 페이지로 연결
    // js파일에서 JSON으로 유저 엔티티에 대해 객체 그대로 전달이 안 되어
    // 테스트를 위해 모든 유저 중 첫 번째를 찾아 그 객체를 통해 예매 진행
    // 시간 부족으로 인해 실제 접속한 유저로 구현은 하지 못함
    @GetMapping("/new-friend")
    public String newFriend(@RequestParam(required = false) Long id, Model model) {

        String userEmail = userService.findAll().get(0).getUserEmail();

        System.out.println("UserCheck new : " + userEmail);
        System.out.println("id new : " + id);
        if (id == null) {
            model.addAttribute("friendReview", new FriendViewResponse());
        } else {
            FriendReview friendReview = friendService.findById(id);
            model.addAttribute("friendReview", new FriendViewResponse(friendReview));
        }

        model.addAttribute("userEmail", userEmail);

        return "FriendViewList";
    }
}





