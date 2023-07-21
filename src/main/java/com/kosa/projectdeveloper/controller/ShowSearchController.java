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

    // 공연 검색에 대한 매핑
    // 검색어, 검색범위에 대한 인자를 받아 진행
    @RequestMapping("/showSearch")
    public String showSearch(@RequestParam(name = "searchWord", required = false) String searchWord,
                             @RequestParam(name = "range", required = false) String range, Model model) {

        List<Show> showList = new ArrayList<>();
        List<ShowDetail> showDetailList = new ArrayList<>();
        List<ShowLocation> showLocationList = new ArrayList<>();

        // 검색어 입력이 없을 경우 검색값이 없게 설정
        // 시간 부족으로 인해 테스트값 그대로하여 제출
        if (searchWord.isEmpty() || searchWord.isBlank()) searchWord = "아야어여오요우유으이";

        if (range.equals("actorName")){
            showDetailList = showDetailRepository.findByShowActorContaining(searchWord);

            range = "배우명";

            for (int i = 0 ; i < showDetailList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }
        } else if (range.equals("showName")) {
            showDetailList = showDetailRepository.findByShowNameContaining(searchWord);

            range = "연극명";

            for (int i = 0 ; i < showDetailList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }
        } else if (range.equals("locationName")) {
            showDetailList = showDetailRepository.findByFacilityNameContaining(searchWord);

            for (int i = 0 ; i < showLocationList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }
        } else {

            showDetailList.addAll(showDetailRepository.findByShowNameContainingOrShowActorContainingOrFacilityNameContaining(searchWord, searchWord, searchWord));

            range = "통합 검색";

            for (int i = 0 ; i < showDetailList.size(); i++){
                showList.add(showRepository.findById(showDetailList.get(i).getShowId()).orElse(null));
            }

        }

        model.addAttribute("searchWord", searchWord);
        model.addAttribute("range", range);
        model.addAttribute("shows", showList);
        model.addAttribute("showDetails", showDetailList);
        model.addAttribute("showLocations", showLocationList);

        return "showSearchView";
    }

}
