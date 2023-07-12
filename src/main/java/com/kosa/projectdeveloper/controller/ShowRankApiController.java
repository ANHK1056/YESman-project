package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.Api.Api;
import com.kosa.projectdeveloper.Api.ShowRankApi;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowLocation;
import com.kosa.projectdeveloper.domain.ShowRank;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowLocationRepository;
import com.kosa.projectdeveloper.repository.ShowRankRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import com.kosa.projectdeveloper.service.ShowRankService;
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

    private static Api api = new Api();


    @GetMapping("/getShowRank")
    public String getRank(Model model) {
        // TODO: 2023-07-12 showRank에서 show 테이블, showLocation 테이블에 추가 코드 작성 필요 
        List<String> rankIdList = new ArrayList<>();
        List<ShowDetail> detailList = new ArrayList<>();
        List<Show> showList = new ArrayList<>();
        List<ShowLocation> locationList = new ArrayList<>();

        rankApi.showRankApi(rankIdList, detailList, showList, locationList);

        List<ShowRank> showRankList = new ArrayList<>();

        for (int i = 0; i < rankIdList.size(); i++){
            Show savedShow = showRepository.findById(showList.get(i).getShow_id()).orElse(null);
            ShowDetail savedShowDetail = showDetailRepository.findById(showList.get(i).getShow_id()).orElse(null);
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
