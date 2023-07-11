package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.FriendReview;
import com.kosa.projectdeveloper.dto.FriendListViewResponse;
import com.kosa.projectdeveloper.dto.FriendViewResponse;
import com.kosa.projectdeveloper.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class FriendViewController {
    private final FriendService friendService;

    @GetMapping("/friends")
    public String getFriends(Model model) {
        List<FriendListViewResponse> friends = friendService.findAll()
                .stream()
                .map(FriendListViewResponse::new)
                .toList();
        model.addAttribute("friends", friends);

        return "/friendsList";
    }

    @GetMapping("/friends/{id}")
    public String getFriend(@PathVariable Long id, Model model) {
        FriendReview friendReview = friendService.findById(id);
        model.addAttribute("friendReview", new FriendViewResponse(friendReview));

        return "friendReview";
    }

    @GetMapping("/new-friend")
    public String newFriend(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("friendReview", new FriendViewResponse());
        } else {
            FriendReview friendReview = friendService.findById(id);
            model.addAttribute("friendReview", new FriendViewResponse(friendReview));
        }

        return "newFriend";
    }
}




