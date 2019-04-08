package kr.or.ddit.admin.pblanc.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Craw {
   public static void main(String[] args) throws Exception {
      // 위키피디아 최상위 페이지
//      String url = "http://dart.fss.or.kr/dsaf001/main.do?rcpNo=20180402003796";
//      String url = "https://ko.wikipedia.org/wiki/%EC%9C%84%ED%82%A4%EB%B0%B1%EA%B3%BC";
      String url = "http://rfp.g2b.go.kr:8426/index.do#";
      
      // GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
      Document doc = Jsoup.connect(url).get();
      
      // HTML 문서의 타이틀 추출하기
      System.out.println("HTML TITLE : " + doc.title()); 
      
      // CSS 선택자를 사용해 링크 추출하기 "새로들어온 소식 영역"
      Elements newsHeadlines = doc.select(".header");
//      Elements newsHeadlines = doc.select("#mp-itn ul b a");
//      Elements newsHeadlines = doc.select("#mobileScroll");
      
      // 반복문 적용하기
      for(Element headline : newsHeadlines) {
         
         // 링크의 "title" 속성 값 추출하기
         String title = headline.text();
         
         // 링크의 URL 추출하기 (절대경로)
         String nextUrl = headline.absUrl("href");
         
         // log
         System.out.println(title); 
         System.out.println(nextUrl);
         // 링크 대상 페이지에 접근하기
//         Document nextDoc = Jsoup.connect(nextUrl).get();
         
//         String nextTitle = nextDoc.title();
         // 상세 내용 추출하기
//         String logo = nextDoc.select(".cont box>.logo").html();
//         Elements logo = nextDoc.select("#"+title);
//         String type = nextDoc.select("div dd").html();
//         String b = nextDoc.select(".logo").attr("src");
//         String a = nextDoc.select("dd").text();
         
      }
   }
}
