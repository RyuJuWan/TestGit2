package kr.or.ddit.empl.dy_recsroom.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dynm.dyRecsRoom.service.IDyRecsRoomService;
import kr.or.ddit.dynm.dyRecsRoomFile.service.DyRecsRoomFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.DynmFrbVO;
import kr.or.ddit.vo.DynmRecsroomFileVO;
import kr.or.ddit.vo.DynmRecsroomVO;
import kr.or.ddit.vo.EmplVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_recsroom/")
public class Dy_RecsroomController {
	
	@Autowired
	private IDyRecsRoomService service;
	
	@Autowired
	private DyRecsRoomFileService fservice;
	
	@RequestMapping("dy_recsroomList")
	public ModelAndView dy_recsroomList(
			String currentPage,
			String search_keyword,
			String search_keycode,
			String paging,
			String search,
			HttpServletRequest request,
			HttpSession session,
			ModelAndView andView,
			Map<String, String> params,
			String prjct_id
			)throws Exception{
		
//		if (search != null) {
//			session.removeAttribute("currentPage");
//		}
//
//		if (currentPage == null || currentPage == "") {
//			if (session.getAttribute("currentPage") != null) {
//				currentPage = (String) session.getAttribute("currentPage");
//			} else {
//				currentPage = "1";
//			}
//		}
		
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);

		if (search_keycode == null) {
			search_keycode = (String) session.getAttribute("search_keycode");
		}
		if (search_keyword == null) {
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
		
		List<DynmRecsroomVO> recsRoomList =this.service.dyRecsRoomList(params);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		andView.addObject("currentPage", currentPage);

		andView.addObject("paging", pagingUtil.getPageHtmls());
		
		andView.addObject("recsRoomList",recsRoomList);
		andView.addObject("prjct_id",prjct_id);
		andView.setViewName("empl/dy_recsroom/dy_recsroomList");
		
		return andView;
	}
	
	@RequestMapping("dy_recsroomView")
	public ModelAndView dy_recsroomView(
			@RequestParam String dynm_recsroom_id,
			Map<String, String> param,
			Map<String, String> param2,
			HttpSession session, 
			HttpServletRequest request,
			DynmRecsroomVO dyRecsRoomInfo,
			ModelAndView andView) throws Exception{
		
		param.put("dynm_recsroom_id", dynm_recsroom_id);
		this.service.frbView(param);
		dyRecsRoomInfo = service.dyRecsRoomInfo(param);
		
		dyRecsRoomInfo.setDynm_recsroom_cn(dyRecsRoomInfo.getDynm_recsroom_cn().replaceAll("\r\n\r\n", "<br>"));
		dyRecsRoomInfo.setDynm_recsroom_cn(dyRecsRoomInfo.getDynm_recsroom_cn().replaceAll("\r\n", ""));
		dyRecsRoomInfo.setDynm_recsroom_cn(dyRecsRoomInfo.getDynm_recsroom_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		param2.put("bo_id", dynm_recsroom_id );
		DynmRecsroomFileVO dyRecsRoomFileInfo = fservice.fileItemInfo(param2);
		
		
		

		andView.addObject("dyRecsRoomInfo", dyRecsRoomInfo);
		andView.addObject("dyRecsRoomFileInfo", dyRecsRoomFileInfo);
		
//		andView.addObject("rnum", rnum);
		
		andView.setViewName("empl/dy_recsroom/dy_recsroomView");

		return andView;
	}
	
	
	@RequestMapping("dy_recsroomModify")
	public String dy_recsroomModify(
			DynmRecsroomVO dyRecsRoomInfo,
			Map<String,String> params)throws Exception{
		
		
	
		
		String dyRecsRoom= dyRecsRoomInfo.getDynm_recsroom_id();
		
		params.put("bo_id", dyRecsRoom);
		service.dyRecsRoomModify(dyRecsRoomInfo,params);
		
		return "redirect:/empl/dy_recsroom/dy_recsroomList.do";
		
		
	}
	
	@RequestMapping("dy_recsroomDelete")
	public String dy_recsroomDelete(
			@RequestParam String dynm_recsroom_id
			) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("dynm_recsroom_id", dynm_recsroom_id);
		
		service.deleteDyRecsRoom(params);
		
		return "redirect:/empl/dy_recsroom/dy_recsroomList.do";
	}
	
	
	@RequestMapping("dy_recsroomForm")
	public ModelAndView prpslForm(
			Map<String, String> params,
			ModelAndView andView,
			String prjct_id )throws Exception{
		
		
		andView.addObject("prjct_id",prjct_id);
		andView.setViewName("empl/dy_recsroom/dy_recsroomForm");
		
		return andView;
	}
	
	@RequestMapping("dy_recsroomInsert")
	public String dy_recsroomInsert(
			DynmRecsroomVO dyRecsRoomInfo,
			HttpSession session,
			String prjct_id
			) throws Exception{
		dyRecsRoomInfo.setDynm_recsroom_cn(dyRecsRoomInfo.getDynm_recsroom_cn().replaceAll("\r\n\r\n", "<br>"));
		dyRecsRoomInfo.setDynm_recsroom_cn(dyRecsRoomInfo.getDynm_recsroom_cn().replaceAll("\r\n", ""));
		dyRecsRoomInfo.setDynm_recsroom_cn(dyRecsRoomInfo.getDynm_recsroom_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		
		
		
		dyRecsRoomInfo.setDynm_recsroom_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
	    dyRecsRoomInfo.setPrjct_id(prjct_id);
	    
	    service.dyRecsRoomInsert(dyRecsRoomInfo);
		
		return "redirect:/empl/dy_recsroom/dy_recsroomList.do";
	}

	
	@RequestMapping("fileExistence")
	public ModelAndView fileExistence(ModelAndView andView) throws Exception{
		andView.setViewName("jsonConvertView");
		return andView;
	}
	
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(
			DynmRecsroomFileVO fileItemVO,
			@RequestParam String dynm_recsroom,
			ModelAndView andView,
			Map<String, String> params
			) throws Exception{
		andView.setViewName("downloadView");
		params.put("bo_id", dynm_recsroom);
		fileItemVO = this.fservice.fileItemInfo(params);
		String fileName = fileItemVO.getDynm_recsroom_file_nm();
		String fileSaveName = fileItemVO.getDynm_recsroom_file_save_nm();
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		andView.addObject("downloadFile", downloadFile);
		andView.addObject("fileName", fileName);
		return andView;
	}
	
	
}















