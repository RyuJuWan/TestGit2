package kr.or.ddit.admin.pblanc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import kr.or.ddit.pblanc.service.IpblancService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.PblancVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Controller
@RequestMapping("/admin/pblanc/")
public class APblancController {
	
	@Resource
	private IpblancService service;
	
	
	@RequestMapping("pblancList")
	public ModelAndView pblancList(String currentPage,
			String search_keyword, String search_keycode, String paging,
			String search, HttpServletRequest request, HttpSession session,
			ModelAndView andView, Map<String, String> params)throws Exception{
		if (search != null) {
			session.removeAttribute("currentPage");
		}

		if (currentPage == null || currentPage == "") {
			if (session.getAttribute("currentPage") != null) {
				currentPage = (String) session.getAttribute("currentPage");
			} else {
				currentPage = "1";
			}
		}

		if (search_keycode == null) {
			search_keycode = (String) session.getAttribute("search_keycode");
		}
		if (search_keyword == null) {
			search_keyword = (String) session.getAttribute("search_keyword");
		}
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);

		int totalCount = service.totalCount(params);

		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount,
				Integer.parseInt(currentPage), request);

		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<PblancVO> pblancList =this.service.pblancList(params);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		andView.addObject("currentPage", currentPage);

		andView.addObject("paging", pagingUtil.getPageHtmls());
		
		andView.addObject("pblancList",pblancList);
		andView.setViewName("admin/pblanc/pblancList");
		
		
		
		return andView;
	}
	
	@RequestMapping("pblancView")
	public ModelAndView prpslView(@RequestParam String pblanc_id,
			Map<String, String> param,
			HttpSession session, HttpServletRequest request,
			ModelAndView andView) throws Exception{
		param.put("pblanc_id", pblanc_id);

		PblancVO pblancInfo = service.pblancInfo(param);
//		List<RqppsVO> rqppsInfoList =  service2.rqppsList(param);
//		List<SanctnLineVO> sanctnlineList =  service3.sanctnlineList(param);
//		List<SanctnPapersTyVO> sanctnpaperstyList =  service4.sanctnpaperstyList(param);
		
		

		andView.addObject("pblancInfo", pblancInfo);
//		andView.addObject("rqppsInfoList",rqppsInfoList);
//		andView.addObject("sanctnlineList",sanctnlineList);
//		andView.addObject("sanctnpaperstyList",sanctnpaperstyList);
		
//		andView.addObject("rnum", rnum);
		andView.setViewName("admin/pblanc/pblancView");

		return andView;
	}
	@RequestMapping("pblancModify")
	public String pblancModify(PblancVO pblancInfo)throws Exception{
		
		
		
////		작성일자
//		Date now = new Date();
//		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String today = sf.format(now);
//		sf = new SimpleDateFormat("yyyy-MM-dd");
//		today = sf.format(now);
		
//		pblancInfo.setPrpsl_wrting_date(today);
//		pblancInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("\r\n\r\n", "<br>"));
//		pblancInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("\r\n", ""));
////		prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("<br><br>", "<br>"));
//		pblancInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		service.pblancModify(pblancInfo);
		
		return "redirect:/admin/pblanc/pblancList.do";
		
		
	}
	
	@RequestMapping("pblancDelete")
	public String pblancDelete(@RequestParam String pblanc_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("pblanc_id", pblanc_id);
		
		service.deletePblanc(params);
		
		return "redirect:/admin/pblanc/pblancList.do";
	}
	
	
	@RequestMapping("pblancForm")
	public ModelAndView pblancForm(
			Map<String, String> params,
			String pblanc_id,
			ModelAndView andView) throws Exception{
		
		params.put("pblanc_id", pblanc_id);
		PblancVO pblancInfo = service.pblancInfo(params);
		//모달창으로 공고 링크 띄우기
		
		
		
//		andView.setViewName("admin/pblanc/pblancForm");
		
		return andView;
	}
	
	@RequestMapping("pblancInsert")
	public String pblancInsert(PblancVO pblancInfo) throws Exception{
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
						
						
						pblancInfo.setPblanc_nm(getTagValue("bidNtceNm", eElement));
						pblancInfo.setPblanc_instt(getTagValue("ntceInsttNm", eElement));
						pblancInfo.setPblanc_link(getTagValue("bidNtceDtlUrl", eElement));
						pblancInfo.setPblanc_budget(getTagValue("presmptPrce", eElement));
						pblancInfo.setPblanc_clos("19/05/23");
						pblancInfo.setPblanc_bid("입찰자격");
						
					}	// for end
					service.pblancInsert(pblancInfo);
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

	      
	      
		
		return "redirect:/admin/pblanc/pblancList.do";
	}
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
 
}
