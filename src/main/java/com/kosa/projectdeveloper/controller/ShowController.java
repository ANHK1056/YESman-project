package com.kosa.projectdeveloper.controller;


import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowRank;
import com.kosa.projectdeveloper.repository.ShowRankRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ShowController {

    private final ShowRepository showRepository;
    private final ShowRankRepository showRankRepository;

    // 공연 메인에 페이지 매핑
    // 시연에서는 체계적으로 매핑이 되지 않아 진행하지 않음
    @GetMapping("/showMain")
    public String showMain(Model model){

        List<Show> shows = showRepository.findAll();

        List<ShowRank> showRanks = showRankRepository.findAll();

        model.addAttribute("shows", shows);
        model.addAttribute("showRanks", showRanks);


        return "ShowMain";
    }

    // 공연 목록 페이지 매핑
    @GetMapping("/showList")
    public String goToShowList(Model model){

        List<Show> shows = showRepository.findAll();

        List<ShowRank> showRanks = showRankRepository.findAll();

        model.addAttribute("shows", shows);
        model.addAttribute("showRanks", showRanks);

        return "ShowList";
    }

}

