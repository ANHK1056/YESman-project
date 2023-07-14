package com.kosa.projectdeveloper.controller;


import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowRank;
import com.kosa.projectdeveloper.repository.ShowRankRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ShowController {

    private final ShowRepository showRepository;
    private final ShowRankRepository showRankRepository;


    @GetMapping("/test12")
    public String test1432432(Model model){

        List<Show> shows = showRepository.findAll();

        List<ShowRank> showRanks = showRankRepository.findAll();

        model.addAttribute("shows", shows);
        model.addAttribute("showRanks", showRanks);


        return "Show";
    }

}

