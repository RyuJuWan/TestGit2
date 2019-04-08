package kr.or.ddit.empl.qna.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.qna.service.IQnaService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.QnaVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/qna/")
public class QnaController {
	@Autowired
	private IQnaService service;
	
	@RequestMapping("qnaList")
	public ModelAndView qnaList(String currentPage,
			String search_keyword,
			String search_keycode,
			String search,
			HttpServletRequest request,
			ModelAndView andView,
			Map<String, String> params,
			HttpSession session,
			QnaVO qnaInfo) throws Exception{
		
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		
		if(search_keycode == null){
			search_keycode = (String) session.getAttribute("search_keycode");
		}
		if(search_keyword == null){
			search_keyword = (String) session.getAttribute("search_keyword");
		}
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		int totalCount = service.totalCount(params);
		List<QnaVO> qnaList = this.service.qnaList(params);
		
		for(QnaVO qnaDate : qnaList){
			qnaDate.setQna_day(qnaDate.getQna_day().substring(0, 10));
		}
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request);
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("qnaInfo", qnaInfo);
		andView.addObject("currentPage", currentPage);
		andView.addObject("qnaList", qnaList);
		andView.setViewName("empl/qna/qnaList");
		
		return andView;
	}
	
	@RequestMapping("qnaView")
	public ModelAndView qnaView(@RequestParam String qna_id,
			Map<String, String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView) throws Exception{
		param.put("qna_id", qna_id);
		
		QnaVO qnaInfo = service.qnaInfo(param);
		
		qnaInfo.setQna_day(qnaInfo.getQna_day().substring(0, 10));
		
		qnaInfo.setQna_cn(qnaInfo.getQna_cn().replaceAll("\r\n\r\n", "<br>"));
		qnaInfo.setQna_cn(qnaInfo.getQna_cn().replaceAll("\r\n", ""));
		qnaInfo.setQna_cn(qnaInfo.getQna_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		andView.addObject("qnaInfo", qnaInfo);
		
		andView.setViewName("empl/qna/qnaView");
		
		return andView;
	}
	
	@RequestMapping("qnaForm")
	public ModelAndView qnaForm(Map<String, String> params,
			ModelAndView andView) throws Exception{
		andView.setViewName("empl/qna/qnaForm");
		
		return andView;
	}
	
	@RequestMapping("insertQna")
	public String insertQna(QnaVO qnaInfo) throws Exception{
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		qnaInfo.setQna_day(today);
		
		service.insertQna(qnaInfo);
		
		return "redirect:/empl/qna/qnaList.do";
	}
	
	@RequestMapping("modifyQnaInfo")
	public String modifyQna(QnaVO qnaInfo,
			Map<String, String> params) throws Exception{
		
		int totalCount = service.totalCount(params);
		
		service.modifyQna(qnaInfo);
		
		return "redirect:/empl/qna/qnaList.do";
	}
	
	@RequestMapping("deleteQnaInfo")
	public String deleteQnaInfo(@RequestParam String qna_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("qna_id", qna_id);
		
		service.deleteQna(params);
		
		return "redirect:/empl/qna/qnaList.do";
	}
}














