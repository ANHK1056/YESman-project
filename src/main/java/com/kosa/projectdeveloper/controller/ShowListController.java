package com.kosa.projectdeveloper.controller;


import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.PageInfo;
import com.kosa.projectdeveloper.service.ShowListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/Show")
@Controller
public class ShowListController {
    @Autowired
    private ShowListService showListService;

    @GetMapping("/test14")
    public String list(Model model, @RequestParam Map<String, String> param) {
        int page = 1;
        String local = param.get("local");

        if(local == null) {
            local="";
        }

        if(param.containsKey("page") == true) {
            try {
                page = Integer.parseInt(param.get("page"));
            } catch (Exception e) {}
        }

        PageInfo pageInfo = new PageInfo(page, 10, showListService.getResCount(param), 10);
        List<Show> list = showListService.selectRes(pageInfo, param);

        model.addAttribute("list", list);
        model.addAttribute("param", param);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("local", local);

        return "/Restaurant/RestaurantList";
    }



    }


