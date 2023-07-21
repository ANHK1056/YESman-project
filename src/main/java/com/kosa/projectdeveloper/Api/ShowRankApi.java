package com.kosa.projectdeveloper.Api;

import com.kosa.projectdeveloper.domain.Show;
import com.kosa.projectdeveloper.domain.ShowDetail;
import com.kosa.projectdeveloper.domain.ShowLocation;
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

    public static String showUrl   = "http://kopis.or.kr/openApi/restful/pblprfr";

    public static String showRankUrl   = "http://kopis.or.kr/openApi/restful/boxoffice";

    public static ShowBasicApi showBasicApi = new ShowBasicApi();

    // 공연 랭킹 목록 API 가져오는 메서드
    // 공연 랭킹 목록 API의 공연 ID를 통해 공연 상세/공연 목록/공연 시설에 대한 API 가져오는 메서드 호출
    public static void showRankApi(List<String> rankIdList, List<ShowDetail> detailList, List<Show> showList, List<ShowLocation> locationList) {
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(showRankUrl);
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

                    // 공연 랭킹 목록 API의 공연 ID를 통해 공연 상세/공연 목록/공연 시설에 대한 API 가져오는 메서드 호출
                    showDetailAndShowAndLocationApi(detailList, showList, locationList, showId);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ShowBasicApi에서는 공연목록-공연상세-공연시설 순으로 API 가져오는 메서드를 호출했으나
    // ShowRankApi는 연극 목록이 아닌 연극 상세와 조인했기 때문에
    // 공연상세 API를 가져오고 공연 상세 API의 정보를 토대로 API를 다시 가져오지 않고 공연 목록 엔티티를 저장한 후
    // ShowBasicApi의 공연 시설 API 가져오는 메서드 호출
    public static List<ShowDetail> showDetailAndShowAndLocationApi(List<ShowDetail> detailList, List<Show> showList, List<ShowLocation> locationList, String fshow_id) {
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
                    String showOpenRun = getTagValue("openrun", eElement);

                    ShowDetail showDetail= new ShowDetail(showId,facilityId,showName,showStartDate,showEndDate, facilityName
                            ,showActor,showAge,runtime,company,showPrice,poster,showGenre,showState,showImage[0],showImage[1],
                            showImage[2],showImage[3], showDate,showContent);

                    detailList.add(showDetail);

                    //공연 상세 API의 정보를 토대로 API를 다시 가져오지 않고 공연 목록 엔티티를 저장
                    Show show= new Show(showId,showName,showStartDate,showEndDate,
                            facilityName, showOpenRun, poster,  showGenre, showState);

                    showList.add(show);

                    // ShowBasicApi의 공연 시설 API 가져오는 메서드 호출
                    showBasicApi.showLocationApi(locationList, showDetail, facilityId);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailList;
    }

    // XML 파일의 태그 파싱 메서드
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

    // XML 파일의 태그가 여러 개일 때 파싱하는 메서드
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
