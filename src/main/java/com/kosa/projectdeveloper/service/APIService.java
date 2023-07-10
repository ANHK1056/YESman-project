package com.kosa.projectdeveloper.service;



import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.dto.ShowDetailRequest;
import com.kosa.projectdeveloper.dto.ShowRequest;
import com.kosa.projectdeveloper.repository.ApiRespository;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class APIService {

    private  final ShowRepository showRepository;
    private  final ShowDetailRepository showDetailRepository;
    public Show save(ShowRequest request){
        return showRepository.save(request.toEntity());
    }

    public List<Show> saveAll(List<Show> list) {
        return showRepository.saveAll(list);
    }
    public List<Show> findAllShows(){return showRepository.findAll(); }


    public ShowDetail save(ShowDetailRequest request) {
        return showDetailRepository.save(request.toEntity());
    }

    public List<ShowDetail> saveDetailAll(List<ShowDetail> showDetailList) {
        return showDetailRepository.saveAll(showDetailList);

    }

    public  List<ShowDetail> findAllShow() {
        return showDetailRepository.findAll();
    }

}
