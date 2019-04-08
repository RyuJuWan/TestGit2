package kr.or.ddit.empl.notice.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.file.service.NoticeFileService;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.RqppsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/notice/")
public class NoticeController {
	@Autowired
	private INoticeService service;
	
	@Autowired
	private NoticeFileService fservice;
	
	@RequestMapping("noticeList")
	public ModelAndView noticeList(
			String currentPage,
			String search_keyword,
			String search_keycode, 
			String paging,
			String search,
			HttpServletRequest request, 
			ModelAndView andView, 
			Map<String, String> params,
			HttpSession session
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
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request);
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());

		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<NoticeVO> noticeList = this.service.noticeList(params);
		
		for(NoticeVO noticeInfo : noticeList){
			noticeInfo.setNotice_date(noticeInfo.getNotice_date().substring(0,10));
		}
		
		andView.addObject("noticeList", noticeList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil",pagingUtil.getPageHtmls());
		andView.setViewName("empl/notice/noticeList");
		
		return andView;
	}
	
	@RequestMapping("noticeView")
	public ModelAndView noticeView(
			@RequestParam String notice_id,
			Map<String, String> param,
			Map<String, String> param2,
			HttpSession session,
			HttpServletRequest request, 
			ModelAndView andView ) throws Exception{
		
		param.put("notice_id", notice_id);
		
		service.hit(notice_id);
		NoticeVO noticeInfo = service.noticeInfo(param);
		List<NoticeVO> noticeInfoList = service.noticeList(param);
		
		param2.put("bo_id", notice_id);
		NoticeFileVO noticeFileInfo = fservice.fileItemInfo(param2);
		
		andView.addObject("noticeInfo", noticeInfo);
		andView.addObject("noticeInfoList", noticeInfoList);
		andView.addObject("noticeFileInfo",noticeFileInfo);
		
		andView.setViewName("empl/notice/noticeView");
		
		return andView;
	}
	
	
	
	
}
