package com.kosa.projectdeveloper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.lang.model.element.Element;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class ApiController {

    @GetMapping("/test")
    public String callApiWithXml() {
        StringBuffer result = new StringBuffer();
        try {
            String apiUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr/PF132236?" +
                    "service=cabcdf578a394c1cbfca801665c8447c" +
                    "&numOfRows=10" +
                    "&pageNo=4";
//            String apiUrl = "https://www.kopis.or.kr/openApi/restful/pblprfr?" +
//                    "service=2d46a5d3c8ba49ff945546fa7e925398&stdate=20160601&eddate=20160630&cpage=1&rows=700";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            result.append("<xmp>");
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result + "</xmp>";
    }


}

