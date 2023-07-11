package com.kosa.projectdeveloper.controller;


import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.BookListViewResponse;
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

    @GetMapping("/test12")
    public String test12(Model model){

        List<Show> shows = showRepository.findAll();

        model.addAttribute("shows", shows);

        return "index";
    }


}

