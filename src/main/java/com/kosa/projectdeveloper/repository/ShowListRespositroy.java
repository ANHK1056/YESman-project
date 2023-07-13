package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Map;

public interface ShowListRespositroy extends PagingAndSortingRepository<Show, String> {

    Show selectByResNo(String showId);
    List<Show> selectRes(PageInfo pageInfo, Map<String, String> param);
    int getResCount(Map<String, String> param);
    List<Show> selectRest(PageInfo pageInfo, Map<String, String> param);
    Page<Show> findAll(Pageable pageable);
}
