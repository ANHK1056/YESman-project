//package com.kosa.projectdeveloper.dto;
//
//import com.kosa.projectdeveloper.domain.Show;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.lang.model.element.Element;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//
//
//public class Api {
//
//    public static String key = "2d46a5d3c8ba49ff945546fa7e925398";
//    public static String showUrl   = "http://kopis.or.kr/openApi/restful/pblprfr";
//
//    public static List<Show> ShowAPI(List<Show> list, int pageNo) { // 축제
//        StringBuffer urlBuffer = new StringBuffer();
//        urlBuffer.append(showUrl);
//        urlBuffer.append("?" + "service=" + key);
//        urlBuffer.append("&" + "pageNo=" + pageNo);
//
//        try {
//            URL url = new URL(urlBuffer.toString());
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/xml");
//            int respCode = conn.getResponseCode();
//
//            if (respCode < 200 || respCode > 300) {
//                throw new Exception("리퀘스트 실패");
//            }
//
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(conn.getInputStream());
//            doc.getDocumentElement().normalize();
//
//            NodeList nList = doc.getElementsByTagName("item");
//
//            for (int i = 0; i < nList.getLength(); i++) {
//                Node node = nList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) node;
//
//                    String show_id = getTagValue("mt20id", eElement);
//                    String show_name = getTagValue("prfnm", eElement);
//                    String show_start_date = getTagValue("prfpdfrom", eElement);
//                    String show_end_date = getTagValue("prfpdto", eElement);
//                    String facility_id = getTagValue("fcltynm", eElement);
//                    String show_hall = getTagValue("PLACE", eElement);
//                    String show_actor = getTagValue("TITLE", eElement);
//                    String show_age = getTagValue("SUBTITLE", eElement);
//                    String fesMainPlace = getTagValue("MAIN_PLACE", eElement);
//                    String fesAddr1 = getTagValue("ADDR1", eElement);
//                    String fesAddr2 = getTagValue("ADDR2", eElement);
//                    String fesTel = getTagValue("CNTCT_TEL", eElement);
//                    String fesHomePageUrl = getTagValue("HOMEPAGE_URL", eElement);
//                    String fesTrfcInfo = getTagValue("TRFC_INFO", eElement);
//                    String fesUsageDay = getTagValue("USAGE_DAY", eElement);
//                    String fesUsageDayAndTime = getTagValue("USAGE_DAY_WEEK_AND_TIME", eElement);
//                    String fesUsageAmount = getTagValue("USAGE_AMOUNT", eElement);
//                    String fesImgNormal = getTagValue("MAIN_IMG_NORMAL", eElement);
//                    String fesImgThumb = getTagValue("MAIN_IMG_THUMB", eElement);
//                    String fesContent = getTagValue("ITEMCNTNTS", eElement);
//
////                  ShowDto showDto = new ShowDto(fesNo, fesMainTitle, fesGugun, fesLat, fesLng, fesPlace, fesTitle, fesSubtitle, fesMainPlace, fesAddr1,
////                            fesAddr2, fesTel, fesHomePageUrl, fesTrfcInfo, fesUsageDay, fesUsageDayAndTime, fesUsageAmount, fesImgNormal, fesImgThumb, fesContent);
////                    list.add(showDto);
//
//
//
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//
//    private static String getTagValue(String tag, Element eElement) {
//        NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
//        Node nValue = (Node) nList.item(0);
//        if (nValue == null) {
//            return null;
//        }
//        return nValue.getNodeValue();
//    }
//
//}
