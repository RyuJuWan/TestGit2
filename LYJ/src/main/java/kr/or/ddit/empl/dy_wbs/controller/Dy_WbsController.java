package kr.or.ddit.empl.dy_wbs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dynm.dyWbs.service.IDyWbsService;
import kr.or.ddit.message.service.IMessageService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.SmlCatVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;
import kr.or.ddit.vo.WorkTyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_wbs/")
public class Dy_WbsController {
	
	@Autowired
	private IDyWbsService service;
	
	
	@Autowired
	private IMessageService service2;
	
	
	
	
	@RequestMapping("dy_wbsList")
	public ModelAndView dy_wbsList(
			String currentPage,
			String search_keyword,
			String search_keycode,
			String search,
			HttpServletRequest request,
			ModelAndView andView,
			Map<String, String> params,
			HttpSession session,
			String prjct_id
			) throws Exception{
		
//		if(search != null){
//			session.removeAttribute("currentPage");
//		}
//		
//		if(currentPage == null || currentPage == ""){
//			if(session.getAttribute("currentPage") != null){
//			}else {
//				currentPage = "1";
//			}
//		}
		
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
		
		List<WBSVO> wbsList = this.service.boardList(params);
		
		
		
		andView.addObject("paging", pagingUtil.getPageHtmls());
		andView.addObject("currentPage", currentPage);
		andView.addObject("wbsList", wbsList);
		andView.addObject("prjct_id", prjct_id);
		
		andView.setViewName("empl/dy_wbs/dy_wbsList");
		
		return andView;
	}
	
	@RequestMapping("dy_wbsForm")
	public ModelAndView dy_flawForm(
			@RequestParam String prjct_id ,
			ModelAndView andView,
			Map<String, String> params
			)throws Exception{
		
		params.put("wbs_prjct", prjct_id);
		
		String prjct_nm = service.getPrjctName(params);//프로젝트 이름 (고정)
		
		List<SmlCatVO> smcaList =service.getSmlCat();//소분류
		List<WorkTyVO> workTyList =service.getWorkTy();//일감유형
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);//직원
		List<SttusVO> sttusList = service.getAllSttus();//진행상태
		List<IpcrVO> ipcrList = service.getAllIpcr();//중요도
		
		
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("workTyList",workTyList);
		andView.addObject("smcaList",smcaList);
		
		
		
		andView.setViewName("empl/dy_wbs/dy_wbsForm");
		return andView;
	}
	
	@RequestMapping("dy_wbsView")
	public ModelAndView dy_flawView(
			@RequestParam String wbs_id,
			@RequestParam String prjct_id, 
			ModelAndView andView,
			Map<String, String> params,
			WBSVO wbsInfo
			)throws Exception{
		
		params.put("wbs_id", wbs_id);
		params.put("wbs_prjct", prjct_id);
		
		wbsInfo = service.boardViewInfo(params);
		String prjct_nm = service.getPrjctName(params);//프로젝트 이름 (고정)
		
		List<SmlCatVO> smcaList =service.getSmlCat();//소분류
		List<WorkTyVO> workTyList =service.getWorkTy();//일감유형
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);//직원
		List<SttusVO> sttusList = service.getAllSttus();//진행상태
		List<IpcrVO> ipcrList = service.getAllIpcr();//중요도
		
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("workTyList",workTyList);
		andView.addObject("smcaList",smcaList);
		andView.addObject("wbsInfo", wbsInfo);
		
		params.put("message_cn", wbsInfo.getWbs_id());
		service2.messageDelete(params);
		
		andView.setViewName("empl/dy_wbs/dy_wbsView");
		return andView;
	}
	
	@RequestMapping("dy_wbsInsert")
	public String dy_wbsInsert(WBSVO wbsInfo,
			HttpSession session) throws Exception{
		String prjct_id = wbsInfo.getWbs_prjct();
		wbsInfo.setWbs_work_cn(wbsInfo.getWbs_work_cn().replaceAll("\r\n\r\n", "<br>"));
		wbsInfo.setWbs_work_cn(wbsInfo.getWbs_work_cn().replaceAll("\r\n", ""));
		wbsInfo.setWbs_work_cn(wbsInfo.getWbs_work_cn().replaceAll("<p>&nbsp;</p>", ""));
		
	    String wbs_id=service.insertBoard(wbsInfo);
	    
	    MessageVO messageInfo =new MessageVO();
	    messageInfo.setMessage_rcver(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
	    messageInfo.setMessage_nm("일감");
	    messageInfo.setMessage_cn(wbs_id);
	    
	    service2.messageInsert(messageInfo);
		return "redirect:/empl/dy_wbs/dy_wbsList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("dy_wbsUpdate.do")
	public String dy_wbsUpdate(WBSVO wbsInfo) throws Exception{
		String prjct_id = wbsInfo.getWbs_prjct();
		wbsInfo.setWbs_work_cn(wbsInfo.getWbs_work_cn().replaceAll("\r\n\r\n", "<br>"));
		wbsInfo.setWbs_work_cn(wbsInfo.getWbs_work_cn().replaceAll("\r\n", ""));
		wbsInfo.setWbs_work_cn(wbsInfo.getWbs_work_cn().replaceAll("<p>&nbsp;</p>", ""));
	    service.updateBoard(wbsInfo);
		return "redirect:/empl/dy_wbs/dy_wbsList.do?prjct_id=" + prjct_id;
	}
	
}















