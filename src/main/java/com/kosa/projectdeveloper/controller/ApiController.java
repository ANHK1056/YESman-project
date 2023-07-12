package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.Api.Api;
import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
import com.kosa.projectdeveloper.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private static Api api = new Api();
    private  final ShowRepository showRepository;
    private  final ShowDetailRepository showDetailRepository;

    @GetMapping("/test")
    public ResponseEntity<List<Show>> initShow() {
        List<Show> list = new ArrayList<Show>();


        list = api.ShowAPI(list, 1);
//        for (int pageNo = 1; pageNo < 4; pageNo++) {
//            list = api.ShowAPI(list, pageNo);
//        }


        List<Show> result = showRepository.saveAll(list);
        return ResponseEntity.ok()
                .body(list);
    }

    @GetMapping("/test2/{show_id}")
    public ResponseEntity<List<ShowDetail>> DetailIninShow (@PathVariable String show_id) {
        List<ShowDetail> detailListist = new ArrayList<ShowDetail>();

        detailListist = api.ShowDetailAPI(detailListist, show_id);

        List<ShowDetail> detailResult = showDetailRepository.saveAll(detailListist);

        return  ResponseEntity.ok()
                .body(detailListist);
    }

    @GetMapping("/test3")
    public ResponseEntity<List<Show>> showAndDetail () {
        List<ShowDetail> detailList = new ArrayList<ShowDetail>();
        List<Show> list = new ArrayList<Show>();

        int pageNo = 1;
        api.ShowAndDetailAPI(list, detailList, pageNo);

        List<Show> savedList = showRepository.saveAll(list);
        List<ShowDetail> savedDetailList = showDetailRepository.saveAll(detailList);

        return ResponseEntity.ok()
                .body(savedList);
    }

}