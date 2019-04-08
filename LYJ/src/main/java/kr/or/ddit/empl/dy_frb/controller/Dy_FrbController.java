package kr.or.ddit.empl.dy_frb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import kr.or.ddit.answer.service.IDyAnswerService;
import kr.or.ddit.dynm.dyFrb.service.IDyFrbService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.DynmFrbVO;
import kr.or.ddit.vo.EmplVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_frb/")
public class Dy_FrbController {
	
	@Autowired
	private IDyFrbService service;
	
	@Autowired
	private IMemberService service2;
	
	@Autowired
	private IDyAnswerService service3;
	
	@RequestMapping("dy_frbList")
	public ModelAndView dy_frbList(String currentPage,
			String search_keyword,
			String search_keycode,
			String search,
			HttpServletRequest request,
			ModelAndView andView,
			Map<String, String> params,
			HttpSession session,
			DynmFrbVO dyFrbInfo,
			String prjct_id)throws Exception{
		
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
		params.put("prjct_id", prjct_id);
		
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, 10, 5, "prjct_id=" + prjct_id + "&");
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<DynmFrbVO> dyFrbList = this.service.frbList(params);
		
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("dyFrbInfo", dyFrbInfo);
		andView.addObject("currentPage", currentPage);
		andView.addObject("dyFrbList", dyFrbList);
		andView.addObject("prjct_id", prjct_id);
		
		
		
		andView.setViewName("empl/dy_frb/dy_frbList");
		
		return andView;
		
	}
	
	//dy_frbView
	@RequestMapping("dy_frbView")
	public ModelAndView frbView(@RequestParam String dynm_frb_id,
			Map<String, String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView,
			String prjct_id
			) throws Exception{
		param.put("dynm_frb_id", dynm_frb_id);
		param.put("prjct_id", prjct_id);
		
		DynmFrbVO dyFrInfo = this.service.frbInfo(param);
		this.service.frbView(param);
		
		dyFrInfo.setDynm_frb_cn(dyFrInfo.getDynm_frb_cn().replaceAll("\r\n\r\n", "<br>"));
		dyFrInfo.setDynm_frb_cn(dyFrInfo.getDynm_frb_cn().replaceAll("\r\n", ""));
		dyFrInfo.setDynm_frb_cn(dyFrInfo.getDynm_frb_cn().replaceAll("<p>&nbsp;</p>", ""));
		List<AnswerVO> answerList =new ArrayList<AnswerVO>();
		answerList = service3.frbList(param);
		
		
		List<EmplVO> emplList =new ArrayList<EmplVO>();
		emplList =service2.emplList();
		
		andView.addObject("dyFrInfo", dyFrInfo);
		andView.addObject("emplList", emplList);
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("answerList", answerList);
		
		andView.setViewName("empl/dy_frb/dy_frbView");
		
		return andView;
	}
	@RequestMapping("frbForm")
	public ModelAndView frbForm(
			Map<String, String> params,
			ModelAndView andView,
			String prjct_id) throws Exception{
		
		andView.addObject("prjct_id", prjct_id);
		andView.setViewName("empl/dy_frb/dy_frbForm");
		return andView;
	}
	
	@RequestMapping("insertFrb")
	public String insertFrb(DynmFrbVO dyFrbInfo,
			HttpSession session,
			String prjct_id) throws Exception{
		
		
		dyFrbInfo.setDynm_frb_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		dyFrbInfo.setPrjct_id(prjct_id);
		
		
		service.insertFrb(dyFrbInfo);
		
		return "redirect:/empl/dy_frb/dy_frbList.do";
	}
	
	
	@RequestMapping("deleteFrbInfo")
	public String deleteFrbInfo(@RequestParam String dynm_frb_id,
		 String prjct_id) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("dynm_frb_id", dynm_frb_id);
		
		service.deleteFrb(params);
		
		return "redirect:/empl/dy_frb/dy_frbList.do";
	}
	
	@RequestMapping("modifyFrbInfo")
	public String modifyFrb(DynmFrbVO dyFrbInfo,
			Map<String, String> params,
			HttpSession session,
			String prjct_id) throws Exception{
		
		dyFrbInfo.setDynm_frb_cn(dyFrbInfo.getDynm_frb_cn().replaceAll("\r\n\r\n", "<br>"));
		dyFrbInfo.setDynm_frb_cn(dyFrbInfo.getDynm_frb_cn().replaceAll("\r\n", ""));
		dyFrbInfo.setDynm_frb_cn(dyFrbInfo.getDynm_frb_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		dyFrbInfo.setDynm_frb_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		dyFrbInfo.setPrjct_id(prjct_id);
		
		service.modifyFrb(dyFrbInfo);
		
		return "redirect:/empl/dy_frb/dy_frbList.do";
	}
	
	@RequestMapping("insertAnswer")
	public String insertAnswer(String answer_cn,
			HttpSession session,
			@RequestParam String dynm_frb_id,
			String prjct_id) throws Exception{
		
		
		
		AnswerVO dyAnswerInfo =new AnswerVO();
		dyAnswerInfo.setAnswer_cn(answer_cn);
		dyAnswerInfo.setAnswer_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		dyAnswerInfo.setAnswer_grp(dynm_frb_id);
		
		service3.insertFrb(dyAnswerInfo);
		
		return "redirect:/empl/dy_frb/dy_frbView.do?dynm_frb_id="+dynm_frb_id;
	}
	
	
	@RequestMapping("deleteAnswerInfo")
	public String deleteAnswerInfo(
			Map<String, String> params,
			HttpSession session,
			String prjct_id,
			@RequestParam String answer_id,
			@RequestParam String dynm_frb_id
			
			) throws Exception{
		
		
		params.put("answer_id", answer_id);
	
		service3.deleteFrb(params);
		
		return "redirect:/empl/dy_frb/dy_frbView.do?dynm_frb_id="+dynm_frb_id;
	}
	
	
	
}















