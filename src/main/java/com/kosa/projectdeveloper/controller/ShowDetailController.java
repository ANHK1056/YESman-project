package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
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

//    private static Api api = new Api();

    @GetMapping("/showList/show/{show_id}")
    public String getShowDetail(Model model, @PathVariable String show_id){

        List<ShowDetail> detailListist = new ArrayList<ShowDetail>();

        ShowDetail showDetail;

        showDetail = showDetailRepository.findById(show_id).orElse(ShowDetail.builder().build());

//        try {
//            showDetail = showDetailRepository.findById(show_id).get();
//        }
//        catch (Exception e) {
//            detailListist = api.ShowDetailAPI(detailListist, show_id);
//            showDetail = detailListist.get(0);
//        }

        model.addAttribute("showDetail", showDetail);

        return "ShowDetail";
    }

}
