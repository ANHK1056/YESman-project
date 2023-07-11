package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShowDetailController {

    private final ShowDetailRepository showDetailRepository;


    @GetMapping("/test13")
    public String test13(Model model){

        List<ShowDetail> showdetails = showDetailRepository.findAll();

        model.addAttribute("showdetails", showdetails);

        return "ShowDetail";
    }
//
//    @GetMapping("/show-one")
//    public String test14(Model model){
//
//        ShowDetail showDetail =
//
//        model.addAttribute("showDetail", showDetail);
//
//        return "showDetail";
//    }

}
