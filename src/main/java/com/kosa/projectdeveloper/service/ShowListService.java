package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.PageInfo;
import com.kosa.projectdeveloper.repository.ShowListRespositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShowListService {

    @Autowired
    private ShowListRespositroy showListRespositroy;

    public int getResCount(Map<String, String> param) {
        // 여기에 필요한 구현을 추가하세요.
        // 예를 들어, repository 메서드를 사용하여 원하는 결과 개수를 얻을 수 있습니다.
        return showListRespositroy.getResCount(param);
    }

    public List<Show> selectRes(PageInfo pageInfo, Map<String, String> param) {
        // 여기에 필요한 구현을 추가하세요.
        // 예를 들어, repository 메서드와 인자로 전달된 PageInfo와 param을 사용하여 원하는 결과 목록을 얻을 수 있습니다.
        return showListRespositroy.selectRest(pageInfo, param);
    }

}
