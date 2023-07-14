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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class ShowSearchController {

    private final ShowLocationRepository showLocationRepository;
    private final ShowRepository showRepository;
    private final ShowDetailRepository showDetailRepository;


    @GetMapping("/searchInput")
    public String intoSearch() {
        return "showSearchInput";
    }

    @RequestMapping("/showSearch")
    public String showSearch(@RequestParam(name = "searchWord", required = false) String searchWord,
                             @RequestParam(name = "range", required = false) String range, Model model) {

        List<Show> showList = new ArrayList<>();
        List<ShowDetail> showDetailList = new ArrayList<>();
        List<ShowLocation> showLocationList = new ArrayList<>();

        if (searchWord.isEmpty() || searchWord.isBlank()) searchWord = "아야어여오요우유으이";

        if (range.equals("actorName")){
            showDetailList = showDetailRepository.findByShowActorContaining(searchWord);

            for (int i = 0 ; i < showDetailList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }
        } else if (range.equals("showName")) {
            showDetailList = showDetailRepository.findByShowNameContaining(searchWord);

            for (int i = 0 ; i < showDetailList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }
        } else if (range.equals("locationName")) {
            showDetailList = showDetailRepository.findByFacilityNameContaining(searchWord);

            for (int i = 0 ; i < showLocationList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }
        } else {
            showDetailList = showDetailRepository.findByShowActorContaining(searchWord);

            showDetailList.addAll(showDetailRepository.findByShowNameContaining(searchWord));

            showDetailList.addAll(showDetailRepository.findByFacilityNameContaining(searchWord));

            for (int i = 0 ; i < showDetailList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }

            // List를 Set으로 변경
            Set<Show> showSet = new HashSet<Show>(showList);

            // Set을 List로 변경
            showList =new ArrayList<Show>(showSet);

            // List를 Set으로 변경
            Set<ShowDetail> showDetailSet = new HashSet<ShowDetail>(showDetailList);

            // Set을 List로 변경
            showDetailList =new ArrayList<ShowDetail>(showDetailSet);

        }

        model.addAttribute("searchWord", searchWord);
        model.addAttribute("range", range);
        model.addAttribute("shows", showList);
        model.addAttribute("showDetails", showDetailList);
        model.addAttribute("showLocations", showLocationList);

        return "showSearchView";
    }

}
