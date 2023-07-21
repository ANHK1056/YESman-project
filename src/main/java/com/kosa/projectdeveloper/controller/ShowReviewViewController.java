package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.ShowReview;
import com.kosa.projectdeveloper.dto.ShowReviewListViewResponse;
import com.kosa.projectdeveloper.dto.ShowReviewViewResponse;
import com.kosa.projectdeveloper.repository.ShowReviewRepository;
import com.kosa.projectdeveloper.service.ShowReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShowReviewViewController {

    private  final ShowReviewService showReviewService;

    // 공연 후기 목록 조회
    @GetMapping("/show-review")
    public String getShowReviews(Model model){
        List<ShowReviewListViewResponse> showReviews = showReviewService.findAll().stream()
                .map(ShowReviewListViewResponse::new)
                .toList();
        model.addAttribute("reviews",showReviews);

        return "showReviewList";
    }

    // 공연 후기 글 조회
    @GetMapping("/show-review/{id}")
    public String getShowReview(@PathVariable Long id, Model model) {
        ShowReview showReview = showReviewService.findByShowReviewId(id);
        model.addAttribute("reviews",new ShowReviewViewResponse(showReview));

        return "showReview";

    }

    // 공연 후기 글 작성 페이지 연결
    @GetMapping("/new-showReview")
    public String newShowReview(@RequestParam(required = false)Long id, Model model){
        if(id ==null) {
            model.addAttribute("reviews", new ShowReviewViewResponse());
        } else {
            ShowReview showReview = showReviewService.findByShowReviewId(id);
            model.addAttribute("reviews",new ShowReviewViewResponse(showReview));
        }

        return "newShowReview";
    }


}
