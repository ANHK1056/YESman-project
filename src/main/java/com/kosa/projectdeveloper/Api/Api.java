package com.kosa.projectdeveloper.Api;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.dto.ShowRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class Api {

    public static String key = "2d46a5d3c8ba49ff945546fa7e925398";
    public static String showUrl   = "http://kopis.or.kr/openApi/restful/pblprfr";

    public static List<Show> ShowAPI(List<Show> list, int pageNo) {
//        http://www.kopis.or.kr/openApi/restful/pblprfr?service=
        // {SeriveKey}&stdate=20160601&eddate=20160630&cpage=1&rows=5
        // &prfstate=02&signgucode=11&signgucodesub=1111&kidstate=Y
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(showUrl);
        urlBuffer.append("?" + "service=" + key);
        urlBuffer.append("&" + "cpage=" + pageNo);
        urlBuffer.append("&" + "stdate=" + "20160601");
        urlBuffer.append("&" + "eddate=" + "20160630");
        urlBuffer.append("&" + "rows=" + "5");

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
            System.out.println("doc: " + doc);

            doc.getDocumentElement().normalize();

            System.out.println("doc: " + doc);

            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("db");

            System.out.println("nListLength: " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    System.out.println("mt20id: " + getTagValue("mt20id", eElement));

                    String show_id = getTagValue("mt20id", eElement);
                    String show_name = getTagValue("prfnm", eElement);
                    String show_start_date = getTagValue("prfpdfrom", eElement);
                    String show_end_date = getTagValue("prfpdto", eElement);
                    String facility_id = getTagValue("fcltynm", eElement);
                    String location = getTagValue("poster", eElement);
                    String show_hall = getTagValue("genrenm", eElement);
                    String show_genre = getTagValue("prfstate", eElement);
                    String show_state = getTagValue("openrun", eElement);


                  Show show= new Show(show_id,show_name,show_start_date,show_end_date,facility_id,show_hall,show_genre,show_state);
                  list.add(show);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // tag값의 정보를 가져오는 메소드
//    private static String getTagValue(String tag, Element eElement) {
//        if (eElement.getElementsByTagName(tag).item(0) != null) {
//            NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
//            Node nValue = (Node) nList.item(0);
//            if (nValue == null) {
//                return null;
//            }
//            return nValue.getNodeValue();
//        } else {
//            return null;
//        }
//    }


    public static List<ShowDetail> ShowDetailAPI(List<ShowDetail> detailList, String fshow_id) {
        StringBuffer urlBuffer = new StringBuffer();
//        http://kopis.or.kr/openApi/restful/pblprfr/{공연아이디}
        urlBuffer.append(showUrl);
        urlBuffer.append("/" + "PF132236");
        urlBuffer.append("?" + "service=" + key);


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
            System.out.println("doc: " + doc);

            doc.getDocumentElement().normalize();

            System.out.println("doc: " + doc);

            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("db");

            System.out.println("nListLength: " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    System.out.println("mt20id: " + getTagValue("mt20id", eElement));

                    String show_id = getTagValue("mt20id", eElement);
                    String show_name = getTagValue("prfnm", eElement);
                    String show_start_date = getTagValue("prfpdfrom", eElement);
                    String show_end_date = getTagValue("prfpdto", eElement);
                    String show_hall = getTagValue("fcltynm", eElement);
                    String show_actor = getTagValue("prfcast", eElement);
                    String show_time = getTagValue("dtguidance", eElement);
                    String show_age = getTagValue("prfage", eElement);
                    String company = getTagValue("entrpsnm", eElement);
                    String show_price = getTagValue("pcseguidance", eElement);
                    String location = getTagValue("poster", eElement);
                    String show_content = getTagValue("sty", eElement);
                    String show_genre = getTagValue("genrenm", eElement);
                    String show_state= getTagValue("prfstate", eElement);
                    String facility_id = getTagValue("mt10id", eElement);
//                    String show_image1 = getTagValue("styurl", eElement);
//                    String show_image2 = getTagValues("styurl", eElement);
//                    String show_image3 = getTagValue("styurl", eElement);
//                    String show_image4 = getTagValue("styurl", eElement);
                    String[] show_image = getTagValues("styurl", eElement);
//                    NodeList styurls = doc.getElementsByTagName("styurl");
//                    System.out.println("styurls: " + styurls.getLength());
//                    for (int j = 0 ; j < styurls.getLength(); j++) {
//                        Node styurlsNode = styurls.item(j);
//
//                        System.out.println("styurlsNode: " + styurlsNode.getNodeValue());
//
//                        if (styurlsNode.getNodeType() == Node.ELEMENT_NODE) {
//                            Element styurlseElement = (Element) styurlsNode;
//
//                            NodeList nList2 = styurlseElement.getElementsByTagName("styurl").item(j).getChildNodes();
//                            Node nValue = (Node) nList2.item(j);
//                            show_image[j] = nValue.getNodeValue();
//                            }
//                    }

//                    ShowDetail showDetail= new ShowDetail(show_id,facility_id,show_name,show_start_date,show_end_date,show_hall
//                    ,show_actor,show_age,company,show_price,location,show_genre,show_state,show_image1,show_image2,show_image3,show_image4,
//                            show_time,show_content);

                    ShowDetail showDetail= new ShowDetail(show_id,facility_id,show_name,show_start_date,show_end_date,show_hall
                            ,show_actor,show_age,company,show_price,location,show_genre,show_state,show_image[0],show_image[1],
                            show_image[2],show_image[3], show_time,show_content);
                    detailList.add(showDetail);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailList;
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

    private static String[] getTagValues(String tag, Element eElement) {
        String[] nValues = new String[eElement.getElementsByTagName(tag).getLength()];
        for (int i = 0 ; i < eElement.getElementsByTagName(tag).getLength(); i++) {
            if (eElement.getElementsByTagName(tag).item(i) != null) {
                NodeList nList = eElement.getElementsByTagName(tag).item(i).getChildNodes();
                Node nValue = (Node) nList.item(0);
                if (nValue == null) {
                    return null;
                }
                nValues[i] = nValue.getNodeValue();
            } else {
                return null;
            }
        }
        return nValues;
    }

}
