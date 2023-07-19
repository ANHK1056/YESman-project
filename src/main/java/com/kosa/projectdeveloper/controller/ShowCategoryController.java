package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowLocation;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowLocationRepository;
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
public class ShowCategoryController {

    private final ShowLocationRepository showLocationRepository;
    private final ShowRepository showRepository;

    @GetMapping("/showList/seoulLocations/{locationAddress}")
    public String categorizeShowLocations(@PathVariable String locationAddress, Model model) {

        List<ShowLocation> showLocationList = showLocationRepository.findByLocationAddressContaining("서울특별시 " + locationAddress);

        List<Show> showList = new ArrayList<>();

        for (int i = 0 ; i < showLocationList.size(); i++){
            showList.add(showRepository.findById(showLocationList.get(i).getShowDetail().getShowId()).orElse(null));
        }

        model.addAttribute("shows", showList);

        return "showLocationsCategory";
    }

    @GetMapping("/testHtml")
    public String testHtml(Model model){
        return "testMain";
    }

}
