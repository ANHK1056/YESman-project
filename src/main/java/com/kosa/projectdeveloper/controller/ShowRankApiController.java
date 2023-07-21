package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.Api.ShowRankApi;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowLocation;
import com.kosa.projectdeveloper.domain.ShowRank;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowLocationRepository;
import com.kosa.projectdeveloper.repository.ShowRankRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShowRankApiController {

    private final ShowRankRepository showRankRepository;

    private final ShowDetailRepository showDetailRepository;

    private final ShowRepository showRepository;

    private final ShowLocationRepository showLocationRepository;

    private static ShowRankApi rankApi = new ShowRankApi();

    // 공연 랭크 API 가져오는 페이지 매핑
    @GetMapping("/api/getShowRank")
    public String getRank(Model model) {
        List<String> rankIdList = new ArrayList<>();
        List<ShowDetail> detailList = new ArrayList<>();
        List<Show> showList = new ArrayList<>();
        List<ShowLocation> locationList = new ArrayList<>();

        rankApi.showRankApi(rankIdList, detailList, showList, locationList);

        List<ShowRank> showRankList = new ArrayList<>();

        for (int i = 0; i < rankIdList.size(); i++){
            Show savedShow = showRepository.findById(showList.get(i).getShowId()).orElse(null);
            ShowDetail savedShowDetail = showDetailRepository.findById(showList.get(i).getShowId()).orElse(null);
            if (savedShow == null){
                savedShow = showRepository.save(showList.get(i));
                savedShowDetail = showDetailRepository.save(detailList.get(i));
                showLocationRepository.save(locationList.get(i));
            }

            ShowRank showRank = showRankRepository.save(ShowRank.builder()
                            .showDetail(savedShowDetail)
                            .rankId(rankIdList.get(i))
                            .build());

            showRankList.add(showRank);
        }

        model.addAttribute("showRanks", showRankList);

        return "showRank";
    }

}
