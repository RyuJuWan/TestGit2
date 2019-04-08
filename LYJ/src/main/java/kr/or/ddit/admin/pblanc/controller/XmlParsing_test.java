package kr.or.ddit.admin.pblanc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import kr.or.ddit.vo.PblancVO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing_test {


	    // tag값의 정보를 가져오는 메소드
		private static String getTagValue(String tag, Element eElement) {
		    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0);
		    if(nValue == null) 
		        return null;
		    return nValue.getNodeValue();
		}

		public static void main(String[] args) {
			int page = 1;	// 페이지 초기값 
			try{
				while(true){
					// parsing할 url 지정(API 키 포함해서)
					String url = "http://apis.data.go.kr/1230000/BidPublicInfoService/"
							+ "getBidPblancListInfoServcPPSSrch?inqryDiv=1&inqryBgnDt=201705010000&inqryEndDt=201705012359&"
							+ "pageNo=1&numOfRows=10&"
							+ "ServiceKey=rgXeP2RFAgaf21m7ni8Inqz4sbT%2BFrKmdakTxcdWvfL5ZO0%2FVT6cs0ESA5SWpYAp4fFOZHrhSf1FxwYrpLyAuA%3D%3D";
					
					DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
					Document doc = dBuilder.parse(url);
					
					// root tag 
					doc.getDocumentElement().normalize();
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
					// 파싱할 tag
					NodeList nList = doc.getElementsByTagName("item");
					//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
					
					String pblanc_nm       ;
					String pblanc_instt    ;
					String pblanc_link     ;
					String pblanc_budget   ;
					
					PblancVO pblancInfo= new PblancVO();
					
					for(int temp = 0; temp < nList.getLength(); temp++){
						Node nNode = nList.item(temp);
						if(nNode.getNodeType() == Node.ELEMENT_NODE){
							
							Element eElement = (Element) nNode;
							System.out.println("######################");
							//System.out.println(eElement.getTextContent());
							System.out.println("공고명  : " + getTagValue("bidNtceNm", eElement));
							System.out.println("공고기관  : " + getTagValue("ntceInsttNm", eElement));
							System.out.println("공고링크 : " + getTagValue("bidNtceDtlUrl", eElement));
							System.out.println("예산  : " + getTagValue("presmptPrce", eElement));
							
							pblanc_nm = getTagValue("bidNtceNm", eElement);
							pblanc_instt = getTagValue("ntceInsttNm", eElement);
							pblanc_link =  getTagValue("bidNtceDtlUrl", eElement);
							pblanc_budget =  getTagValue("presmptPrce", eElement);
							
							pblancInfo.setPblanc_nm(pblanc_nm);
							pblancInfo.setPblanc_instt(pblanc_instt);
							pblancInfo.setPblanc_link(pblanc_link);
							pblancInfo.setPblanc_budget(pblanc_budget);
							
							
							
							
							
						}	// for end
					}	// if end
					
					page += 1;
					System.out.println("page number : "+page);
					if(page > 1){	
						break;
					}
				}	// while end
				
			} catch (Exception e){	
				e.printStackTrace();
			}	// try~catch end
		}	// main end
	}	// class end
