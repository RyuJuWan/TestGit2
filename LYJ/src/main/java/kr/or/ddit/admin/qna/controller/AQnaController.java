package kr.or.ddit.admin.qna.controller;

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
@RequestMapping("/admin/qna/")
public class AQnaController {
	@Autowired
	private IQnaService service;
	
	@RequestMapping("qnaList")
	public ModelAndView qnaList(String currentPage,
			String search_keyword,
			String search_keycode,
			String search,
			String qna_id,
			HttpServletRequest request,
			ModelAndView andView,
			Map<String, String> params,
			HttpSession session,
			QnaVO qnaInfo) throws Exception{
		if(search != null){
			session.removeAttribute("currentPage");
		}
		
		if(currentPage == null || currentPage == ""){
			if(session.getAttribute("currentPage") != null){
			}else {
				currentPage = "1";
			}
		}
		
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
		
		andView.addObject("qna_id", qna_id);
		andView.addObject("qnaInfo", qnaInfo);
		andView.addObject("currentPage", currentPage);
		andView.addObject("qnaList", qnaList);
		andView.setViewName("admin/qna/qnaList");
		
		return andView;
	}
	
	@RequestMapping("qnaView")
	public ModelAndView qnaView(String qna_id,
			Map<String, String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView) throws Exception{
		param.put("qna_id", qna_id);
		service.qnaView(param);
		
		QnaVO qnaInfo = service.qnaInfo(param);
		
		qnaInfo.setQna_day(qnaInfo.getQna_day().substring(0, 10));
		
		qnaInfo.setQna_cn(qnaInfo.getQna_cn().replaceAll("\r\n\r\n", "<br>"));
		qnaInfo.setQna_cn(qnaInfo.getQna_cn().replaceAll("\r\n", ""));
		qnaInfo.setQna_cn(qnaInfo.getQna_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		andView.addObject("qnaInfo", qnaInfo);
		andView.addObject("qna_id", qna_id);
		
		
		andView.setViewName("admin/qna/qnaView");
		
		return andView;
	}
	
	@RequestMapping("qnaReplyForm")
	public ModelAndView qnaReplyForm(@RequestParam Map<String, String> params,
			ModelAndView andView,
			String qna_id) throws Exception{
		
		andView.addObject("qna_id", qna_id);
		System.out.println(qna_id);
		andView.setViewName("admin/qna/qnaReplyForm");
		
		return andView;
	}
	
	@RequestMapping("insertReplyQna")
	public String insertReplyQna(String qna_grp,
			@RequestParam String qna_id,
			QnaVO qnaInfo,
			Map<String, String> params) throws Exception{
		params.put("qna_id", qna_id);
		service.qnaInfo(params);
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		qnaInfo.setQna_day(today);
		
		service.insertQnaReply(qnaInfo);
		
		return "redirect:/admin/qna/qnaList.do";
	}
	
	@RequestMapping("modifyQnaInfo")
	public String modifyQna(QnaVO qnaInfo,
			Map<String, String> params) throws Exception{
		
		int totalCount = service.totalCount(params);
		
		service.modifyQna(qnaInfo);
		
		return "redirect:/admin/qna/qnaList.do";
	}
	
	@RequestMapping("deleteQnaInfo")
	public String deleteQnaInfo(@RequestParam String qna_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("qna_id", qna_id);
		
		service.deleteQna(params);
		
		return "redirect:/admin/qna/qnaList.do";
	}
}














