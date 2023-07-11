package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.Api.Api;
import com.kosa.projectdeveloper.Api.ShowRankApi;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowRank;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
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

    private static ShowRankApi rankApi = new ShowRankApi();

    private static Api api = new Api();

    @GetMapping("/getRank")
    public String getRank(Model model) {
        // TODO: 2023-07-12 showRank에서 show 테이블, showLocation 테이블에 추가 코드 작성 필요 
        List<String> rankIdList = new ArrayList<>();
        List<String> showIdList = new ArrayList<>();

        rankApi.showRankApi(rankIdList, showIdList);

        List<ShowRank> showRankList = new ArrayList<>();

        for (int i = 0; i < rankIdList.size(); i++){
            ShowDetail savedShowDetail = showDetailRepository.findById(showIdList.get(i)).orElse(null);
            if (savedShowDetail == null){
                savedShowDetail = showDetailRepository.save(
                        api.ShowDetailAPI(new ArrayList<ShowDetail>(), showIdList.get(i)).get(0));
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
