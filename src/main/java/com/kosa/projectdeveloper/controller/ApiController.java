package com.kosa.projectdeveloper.controller;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.dto.ShowDto;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
public class ApiController {


    @PostMapping("/test")
    public String load_save(@RequestParam("date") String date, Show show){
        String result = "";

        try {
            String requestDate=date;
            URL url = new URL("http://openapi.seoul.go.kr:8088/" + "받은인증키/" +
                    "json/CardSubwayStatsNew/1/700/"+requestDate);
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();

            JSONParser jsonParser = new JSONParser(result);
            JSONObject jsonObject = (JSONObject)jsonParser.parse();
            JSONObject CardSubwayStatsNew = (JSONObject)jsonObject.get("CardSubwayStatsNew");
            Long totalCount=(Long)CardSubwayStatsNew.get("list_total_count");

            JSONObject subResult = (JSONObject)CardSubwayStatsNew.get("RESULT");
            JSONArray infoArr = (JSONArray) CardSubwayStatsNew.get("row");

            for(int i=0;i<infoArr.size();i++){
                JSONObject tmp = (JSONObject)infoArr.get(i);
//                ShowDto showDto =new ShowDto((String)tmp.get("show_id"), (String)tmp.get("facility_id"),(String)tmp.get("show_name"));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/findname";
    }
}
