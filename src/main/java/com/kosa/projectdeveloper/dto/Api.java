package com.kosa.projectdeveloper.dto;

import com.kosa.projectdeveloper.domain.Show;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class Api {

    public static String key = "2d46a5d3c8ba49ff945546fa7e925398";
    public static String showUrl   = "http://kopis.or.kr/openApi/restful/pblprfr";

    public static List<Show> ShowAPI(List<Show> list, int pageNo) {
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(showUrl);
        urlBuffer.append("?" + "service=" + key);
        urlBuffer.append("&" + "pageNo=" + pageNo);

        try {
            // parsing할 url 지정(API 키 포함해서)
            URL url = new URL(urlBuffer.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            int respCode = conn.getResponseCode();

            if (respCode < 200 || respCode > 300) {
                throw new Exception("리퀘스트 실패");
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());
            // root tag
            doc.getDocumentElement().normalize();


            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("item");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    String show_id = getTagValue("mt20id", eElement);
                    String show_name = getTagValue("prfnm", eElement);
                    String show_start_date = getTagValue("prfpdfrom", eElement);
                    String show_end_date = getTagValue("prfpdto", eElement);
                    String facility_id = getTagValue("fcltynm", eElement);
                    String location = getTagValue("poster", eElement);
                    String show_hall = getTagValue("genrenm", eElement);
                    String show_genre = getTagValue("prfstate", eElement);
                    String show_state = getTagValue("openrun", eElement);


//                  Show show= new Show(show_id,show_name,show_start_date,show_end_date,facility_id,show_hall,show_genre,show_state);
                    list.add(show);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nList.item(0);
        if (nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }

}
