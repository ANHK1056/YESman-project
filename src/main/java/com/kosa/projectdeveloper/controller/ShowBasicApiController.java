package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.Api.ShowBasicApi;
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

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShowBasicApiController {
    private final ShowRepository showRepository;
    private final ShowDetailRepository showDetailRepository;
    private final ShowLocationRepository showLocationRepository;

    private static ShowBasicApi showBasicApi = new ShowBasicApi();

    @GetMapping("/getShowBasic")
    public String getLocation(Model model) {
        List<Show> showList = new ArrayList<>();
        List<ShowDetail> detailList = new ArrayList<>();
        List<ShowLocation> locationList = new ArrayList<>();

        showBasicApi.showAndDetailAndLocationApi(showList, detailList, locationList, 1);

        showRepository.saveAll(showList);
        showDetailRepository.saveAll(detailList);
        showLocationRepository.saveAll(locationList);

        model.addAttribute("shows", showList);
        model.addAttribute("showDetails", detailList);
        model.addAttribute("showLocations", locationList);

        return "showBasic";
    }
}