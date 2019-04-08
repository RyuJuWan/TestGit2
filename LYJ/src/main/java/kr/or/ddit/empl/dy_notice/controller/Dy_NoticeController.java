package kr.or.ddit.empl.dy_notice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dynm.dyNotice.service.IDyNoticeService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.DynmNoticeVO;
import kr.or.ddit.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_notice/")
public class Dy_NoticeController {
	
	@Autowired
	private IDyNoticeService service;
	
	
	@RequestMapping("dy_noticeList")
	public ModelAndView noticeList(
			String currentPage,
			String search_keyword,
			String search_keycode, 
			String paging,
			String search,
			HttpServletRequest request, 
			ModelAndView andView, 
			Map<String, String> params,
			HttpSession session,
			String prjct_id
			) throws Exception{
		
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
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, 10, 5, "prjct_id=" + prjct_id + "&");
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());

		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<DynmNoticeVO> dyNoticeList = this.service.noticeList(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("dyNoticeList", dyNoticeList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil",pagingUtil.getPageHtmls());
		andView.setViewName("empl/dy_notice/dy_noticeList");
		
		return andView;
	}
	
	@RequestMapping("noticeView")
	public ModelAndView noticeView(
			@RequestParam String dynm_notice_id,
			Map<String, String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView
			)throws Exception{
		param.put("dynm_notice_id", dynm_notice_id);
		
		service.hit(dynm_notice_id);
		DynmNoticeVO dyNoticeInfo = service.noticeInfo(param);
		List<DynmNoticeVO> dyNoticeInfoList = service.noticeList(param);
		
		andView.addObject("dyNoticeInfo", dyNoticeInfo);
		andView.addObject("dyNoticeInfoList", dyNoticeInfoList);
		
		andView.setViewName("empl/dy_notice/dy_noticeView");
		
		return andView;
	}
	
}















