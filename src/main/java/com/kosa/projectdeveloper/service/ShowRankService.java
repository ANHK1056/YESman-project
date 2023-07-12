package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.ShowRank;
import com.kosa.projectdeveloper.dto.ShowRankRequest;
import com.kosa.projectdeveloper.repository.ShowRankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShowRankService {

    private ShowRankRepository showRankRepository;

    public ShowRank save(ShowRankRequest request) { return showRankRepository.save(request.toEntity());}

    public List<ShowRank> findAll() {return showRankRepository.findAll();}



}
