package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.Api.Api;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShowDetailController {

    private final ShowDetailRepository showDetailRepository;

    private static Api api = new Api();

    @GetMapping("/test13")
    public String test13(Model model){

        List<ShowDetail> showdetails = showDetailRepository.findAll();

        model.addAttribute("showDetails", showdetails);

        return "ShowDetail";
    }

    @GetMapping("/shows/{show_id}")
    public String test14(Model model, @PathVariable String show_id){

        List<ShowDetail> detailListist = new ArrayList<ShowDetail>();

        ShowDetail showDetail;

        try {
            showDetail = showDetailRepository.findById(show_id).get();
        }
        catch (Exception e) {
            detailListist = api.ShowDetailAPI(detailListist, show_id);
            showDetail = detailListist.get(0);
        }

//        detailListist = api.ShowDetailAPI(detailListist, show_id);
//
//        showDetail = detailListist.get(0);

//        showDetailRepository.save(showDetail);

        model.addAttribute("showDetail", showDetail);

        return "ShowDetail";
    }

}
