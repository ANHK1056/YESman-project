package com.kosa.projectdeveloper.Api;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ShowRankApi {

    public static String key = "2d46a5d3c8ba49ff945546fa7e925398";
    public static String showUrl   = "http://kopis.or.kr/openApi/restful/boxoffice";

    public static void showRankApi(List<String> rankIdList, List<String> showIdList) {
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(showUrl);
        urlBuffer.append("?" + "service=" + key);
        urlBuffer.append("&" + "ststype=" + "month");
        urlBuffer.append("&" + "date=" + "20230601");
        urlBuffer.append("&" + "catecode=" + "AAAA");

        System.out.println("urlBuffer: " + urlBuffer);
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
            NodeList nList = doc.getElementsByTagName("boxof");

            System.out.println("nListLength: " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    System.out.println("mt20id: " + getTagValue("mt20id", eElement));


                    String rankId = getTagValue("rnum", eElement);
                    String showId = getTagValue("mt20id", eElement);

                    rankIdList.add(rankId);
                    showIdList.add(showId);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String tag, Element eElement) {
        if (eElement.getElementsByTagName(tag).item(0) != null) {
            NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
            Node nValue = (Node) nList.item(0);
            if (nValue == null) {
                return null;
            }
            return nValue.getNodeValue();
        } else {
            return null;
        }
    }
}
