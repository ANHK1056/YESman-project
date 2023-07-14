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

    @GetMapping("/friends")
    public String getFriends(Model model) {
        List<FriendListViewResponse> friends = friendService.findAll()
                .stream()
                .map(FriendListViewResponse::new)
                .toList();


        List<FriendReview> friendReviewList = friendRepository.findAll();

        System.out.println();

        model.addAttribute("friends", friends);
        model.addAttribute("friendsList", friendReviewList);

        return "FriendView";
    }

    @GetMapping("/friends/{id}")
    public String getFriend(@PathVariable Long id, Model model) {
        FriendReview friendReview = friendService.findById(id);
        model.addAttribute("friendReview", new FriendViewResponse(friendReview));

        return "text_userFriendList";
    }

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





