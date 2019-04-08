package kr.or.ddit.admin.notice.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.file.service.NoticeFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PrpslFileVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/notice/")
public class ANoticeController {
	
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
		andView.setViewName("admin/notice/noticeList");
		
		return andView;
	}
	
	@RequestMapping("noticeView")
	public ModelAndView noticeView(@RequestParam String notice_id, 
			Map<String, String> param,
			Map<String, String> param2,
			HttpSession session, 
			HttpServletRequest request, ModelAndView andView )
	throws Exception{
		service.hit(notice_id);
		
		param.put("notice_id", notice_id);
		NoticeVO noticeInfo = service.noticeInfo(param);
		
		param2.put("bo_id", notice_id);
		NoticeFileVO noticeFileInfo = fservice.fileItemInfo(param2);
		
		List<NoticeVO> noticeInfoList = service.noticeList(param);
		
		andView.addObject("noticeInfo", noticeInfo);
		andView.addObject("noticeFileInfo", noticeFileInfo);
		andView.addObject("noticeInfoList", noticeInfoList);
		
		andView.setViewName("admin/notice/noticeView");
		
		return andView;
	}
	
	@RequestMapping("noticeForm")
	public ModelAndView noticeForm(	Map<String, String> params,
			ModelAndView andView) throws Exception{
		
		andView.setViewName("admin/notice/noticeForm");
		return andView;
	}
	
	@RequestMapping("insertNotice")
	public String insertNoitce(NoticeVO noticeInfo, HttpSession session) throws Exception{
		  //      작성일자
	      Date now = new Date();
	      SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	      String today = sf.format(now);
	      sf = new SimpleDateFormat("yyyy-MM-dd");
	      today = sf.format(now);
	      
	      noticeInfo.setNotice_date(today);
	      noticeInfo.setNotice_delete("n");
	      noticeInfo.setNotice_inquiry("0");
	      
	      noticeInfo.setNotice_cn(noticeInfo.getNotice_cn().replaceAll("\r\n\r\n", "<br>"));
	      noticeInfo.setNotice_cn(noticeInfo.getNotice_cn().replaceAll("\r\n", ""));
	      noticeInfo.setNotice_cn(noticeInfo.getNotice_cn().replaceAll("<p>&nbsp;</p>", ""));
	      
	      noticeInfo.setNotice_empl(((AdminVO)session.getAttribute("LOGIN_ADMININFO")).getAdmin_id());
	      service.insertNotice(noticeInfo);
	      
		return "redirect:/admin/notice/noticeList.do";
	}
	@RequestMapping("updateNotice")
	public String updateNotice(
			NoticeVO noticeInfo,
			String notice_id,
			Map<String,String> params,
			HttpSession session ) throws Exception{
		 Date now = new Date();
		 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		 String today = sf.format(now);
		 sf = new SimpleDateFormat("yyyy-MM-dd");
		 today = sf.format(now);
      
	     noticeInfo.setNotice_date(today);
	     noticeInfo.setNotice_empl(((AdminVO)session.getAttribute("LOGIN_ADMININFO")).getAdmin_id());
		      
		noticeInfo.setNotice_cn(noticeInfo.getNotice_cn().replaceAll("\r\n\r\n", "<br>"));
		noticeInfo.setNotice_cn(noticeInfo.getNotice_cn().replaceAll("\r\n", ""));
		noticeInfo.setNotice_cn(noticeInfo.getNotice_cn().replaceAll("<p>&nbsp;</p>", ""));
		String notice = noticeInfo.getNotice_id();
		
		params.put("bo_id", notice);
		service.updateNotice(noticeInfo, params);
		
		return "redirect:/admin/notice/noticeView.do?notice_id="+notice_id;
	}
	
	@RequestMapping("noticeUpdate")
	public ModelAndView noticeUpdateForm(
			Map<String, String> params,
			Map<String, String> param2,
			String notice_id, 
			ModelAndView andView
			) throws Exception{
		
		params.put("notice_id", notice_id);
		NoticeVO noticeInfo = service.noticeInfo(params);
		
		param2.put("bo_id", notice_id);
		NoticeFileVO noticeFileInfo = fservice.fileItemInfo(param2);
		
		List<NoticeVO> noticeInfoList = service.noticeList(param2);
		
		andView.addObject("noticeInfo", noticeInfo);
		andView.addObject("noticeFileInfo", noticeFileInfo);
		andView.addObject("noticeInfoList", noticeInfoList);
		
		andView.setViewName("admin/notice/noticeUpdate");
		return andView;
	}
	
	@RequestMapping("deleteNotice")
	public String deleteNotice(@RequestParam String notice_id) throws Exception{
		Map<String, String> params = new HashMap<String, String>();
		params.put("notice_id", notice_id);
		
		service.deleteNotice(params);
		return "redirect:/admin/notice/noticeList.do";
	}
	
	@RequestMapping("fileExistence")
	public ModelAndView fileExistence(ModelAndView andView) throws Exception{
		andView.setViewName("jsonConvertView");
		return andView;
	}
	
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(NoticeFileVO fileItemVO, 
			@RequestParam String notice,
			ModelAndView andView, 
			Map<String, String> params) throws Exception{
		andView.setViewName("downloadView");
		params.put("bo_id", notice);
		fileItemVO = this.fservice.fileItemInfo(params);
		String fileName = fileItemVO.getNotice_file_nm();
		String fileSaveName = fileItemVO.getNotice_file_save_nm();
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		andView.addObject("downloadFile", downloadFile);
		andView.addObject("fileName", fileName);
		return andView;
	}
	
}
