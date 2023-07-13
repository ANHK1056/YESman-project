package com.kosa.projectdeveloper.Api;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.dto.ShowRequest;
import com.kosa.projectdeveloper.repository.ShowDetailRepository;
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
import java.util.ArrayList;
import java.util.List;


public class Api {

    public static String key = "2d46a5d3c8ba49ff945546fa7e925398";
//    http://www.kopis.or.kr/openApi/restful/pblprfr?service={SeriveKey}&stdate=20160601&eddate=20160630&cpage=1&rows=5
    public static String showUrl   = "http://kopis.or.kr/openApi/restful/pblprfr";

    private ShowDetailRepository showDetailRepository ;

    public static List<Show> ShowAPI(List<Show> list, int pageNo) {
//        http://www.kopis.or.kr/openApi/restful/pblprfr?service=
        // {SeriveKey}&stdate=20160601&eddate=20160630&cpage=1&rows=5
        // &prfstate=02&signgucode=11&signgucodesub=1111&kidstate=Y
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(showUrl);
        urlBuffer.append("?" + "service=" + key);
        urlBuffer.append("&" + "cpage=" + pageNo);
        urlBuffer.append("&" + "stdate=" + "20230101");
        urlBuffer.append("&" + "eddate=" + "20230630");
        urlBuffer.append("&" + "rows=" + "14");
        urlBuffer.append("&" + "shcate=" + "AAAA");

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

                    String showId = getTagValue("mt20id", eElement);
                    String showName = getTagValue("prfnm", eElement);
                    String showStartDate = getTagValue("prfpdfrom", eElement);
                    String showEndDate = getTagValue("prfpdto", eElement);
                    String facilityName = getTagValue("fcltynm", eElement);
                    String poster = getTagValue("poster", eElement);
                    String showGenre = getTagValue("genrenm", eElement);
                    String showState = getTagValue("prfstate", eElement);
                    String showOpenRun = getTagValue("openrun", eElement);

                    List<ShowDetail> detailListist = new ArrayList<ShowDetail>();

                    ShowDetail showDetail;

                    detailListist = ShowDetailAPI(detailListist, showId);
                    showDetail = detailListist.get(0);

//                    showDetailRepository.save(showDetail);

                    Show show= new Show(showId,showName,showStartDate,showEndDate,
                          facilityName, showOpenRun, poster, showGenre, showState);
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
        urlBuffer.append("/" + fshow_id);
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

                    String showId = getTagValue("mt20id", eElement);
                    String showName = getTagValue("prfnm", eElement);
                    String showStartDate = getTagValue("prfpdfrom", eElement);
                    String showEndDate = getTagValue("prfpdto", eElement);
                    String facilityName = getTagValue("fcltynm", eElement);
                    String showActor = getTagValue("prfcast", eElement);
                    String showDate = getTagValue("dtguidance", eElement);
                    String runtime = getTagValue("prfruntime", eElement);
                    String showAge = getTagValue("prfage", eElement);
                    String company = getTagValue("entrpsnm", eElement);
                    String showPrice = getTagValue("pcseguidance", eElement);
                    String poster = getTagValue("poster", eElement);
                    String showContent = getTagValue("sty", eElement);
                    String showGenre = getTagValue("genrenm", eElement);
                    String showState= getTagValue("prfstate", eElement);
                    String facilityId = getTagValue("mt10id", eElement);
                    String[] showImage = getTagValues("styurl", eElement);

                    ShowDetail showDetail= new ShowDetail(showId,facilityId,showName,showStartDate,showEndDate, facilityName
                            ,showActor,showAge,runtime,company,showPrice,poster,showGenre,showState,showImage[0],showImage[1],
                            showImage[2],showImage[3], showDate,showContent);
                    detailList.add(showDetail);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailList;
    }

    public static void ShowAndDetailAPI(List<Show> list, List<ShowDetail> detailList, int pageNo) {
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(showUrl);
        urlBuffer.append("?" + "service=" + key);
        urlBuffer.append("&" + "cpage=" + pageNo);
        urlBuffer.append("&" + "stdate=" + "20230101");
        urlBuffer.append("&" + "eddate=" + "20230630");
        urlBuffer.append("&" + "rows=" + "10");
        urlBuffer.append("&" + "shcate=" + "AAAA");

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

                    String showId = getTagValue("mt20id", eElement);
                    String showName = getTagValue("prfnm", eElement);
                    String showStartDate = getTagValue("prfpdfrom", eElement);
                    String showEndDate = getTagValue("prfpdto", eElement);
                    String facilityName = getTagValue("fcltynm", eElement);
                    String poster = getTagValue("poster", eElement);
                    String showGenre = getTagValue("genrenm", eElement);
                    String showState = getTagValue("prfstate", eElement);
                    String showOpenRun = getTagValue("openrun", eElement);

                    detailList = ShowDetailAPI(detailList, showId);

                    Show show= new Show(showId,showName,showStartDate,showEndDate,
                            facilityName,showOpenRun, poster,showGenre,showState);
                    list.add(show);

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

    private static String[] getTagValues(String tag, Element eElement) {
//        String[] nValues = new String[eElement.getElementsByTagName(tag).getLength()];
        String[] nValues = new String[4];
        int max_i = 0;

        if (eElement.getElementsByTagName(tag).getLength() > 4) max_i = 4;
        else max_i = eElement.getElementsByTagName(tag).getLength();

        for (int i = 0 ; i < max_i; i++) {
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
