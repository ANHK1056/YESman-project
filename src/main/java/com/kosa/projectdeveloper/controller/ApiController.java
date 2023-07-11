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
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private static Api api = new Api();
    private  final ShowRepository showRepository;
    private  final ShowDetailRepository showDetailRepository;

    @GetMapping("/test")
    public ResponseEntity<List<Show>> initShow() {
        List<Show> list = new ArrayList<Show>();

        for (int pageNo = 1; pageNo < 4; pageNo++) {
            list = api.ShowAPI(list, pageNo);
        }


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

}