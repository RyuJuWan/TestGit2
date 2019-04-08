package kr.or.ddit.empl.frb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.answer.service.IDyAnswerService;
import kr.or.ddit.frb.service.IFrbService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FrbVO;
import kr.or.ddit.vo.RqppsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/frb/")
public class FrbController {
	@Autowired
	private IFrbService service;
	
	@Autowired
	private IDyAnswerService service2;
	
	@Autowired
	private IMemberService service3;
	
	@RequestMapping("frbList")
	public ModelAndView frbList(String currentPage,
			String search_keyword,
			String search_keycode,
			String search,
			HttpServletRequest request,
			ModelAndView andView,
			Map<String, String> params,
			HttpSession session,
			FrbVO frbInfo) throws Exception{
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
		
//		for(FrbVO frbDate : frbList){
//			frbDate.setFrb_day(frbDate.getFrb_day().substring(0, 10));
//		}
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request);
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<FrbVO> frbList = this.service.frbList(params);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("frbInfo", frbInfo);
		andView.addObject("currentPage", currentPage);
		andView.addObject("frbList", frbList);
		andView.setViewName("empl/frb/frbList");
		
		return andView;
	}
	
	@RequestMapping("frbForm")
	public ModelAndView frbForm(
			Map<String, String> params,
			ModelAndView andView) throws Exception{
		
		andView.setViewName("empl/frb/frbForm");
		return andView;
	}
	
	@RequestMapping("insertFrb")
	public String insertFrb(FrbVO frbInfo) throws Exception{
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		frbInfo.setFrb_day(today);
		
		service.insertFrb(frbInfo);
		
		return "redirect:/empl/frb/frbList.do";
	}
	
	@RequestMapping("frbView")
	public ModelAndView frbView(@RequestParam String frb_id,
			Map<String, String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView,
			String prjct_id) throws Exception{
		param.put("prjct_id", prjct_id);
		param.put("frb_id", frb_id);
		
		FrbVO frbInfo = this.service.frbInfo(param);
		this.service.frbView(param);
		
		frbInfo.setFrb_cn(frbInfo.getFrb_cn().replaceAll("\r\n\r\n", "<br>"));
	    frbInfo.setFrb_cn(frbInfo.getFrb_cn().replaceAll("\r\n", ""));
	    frbInfo.setFrb_cn(frbInfo.getFrb_cn().replaceAll("<p>&nbsp;</p>", ""));
		
	    List<AnswerVO> answerList =new ArrayList<AnswerVO>();
		answerList = service2.frbList(param);
		
		List<EmplVO> emplList = new ArrayList<EmplVO>();
		emplList =service3.emplList();
		
		andView.addObject("emplList", emplList);
		andView.addObject("answerList", answerList);
		andView.addObject("frbInfo", frbInfo);
		andView.setViewName("empl/frb/frbView");
		
		return andView;
	}
	
	@RequestMapping("deleteFrbInfo")
	public String deleteFrbInfo(@RequestParam String frb_id) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("frb_id", frb_id);
		
		service.deleteFrb(params);
		
		return "redirect:/empl/frb/frbList.do";
	}
	
	@RequestMapping("modifyFrbInfo")
	public String modifyFrb(FrbVO frbInfo,
			Map<String, String> params) throws Exception{
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		int totalCount = service.totalCount(params);
		
	    frbInfo.setFrb_cn(frbInfo.getFrb_cn().replaceAll("\r\n\r\n", "<br>"));
	    frbInfo.setFrb_cn(frbInfo.getFrb_cn().replaceAll("\r\n", ""));
	    frbInfo.setFrb_cn(frbInfo.getFrb_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		frbInfo.setFrb_day(today);
		
		service.modifyFrb(frbInfo);
		
		return "redirect:/empl/frb/frbList.do";
	}
	
	@RequestMapping("insertAnswer")
	public String insertAnswer(String answer_cn,
			HttpSession session,
			@RequestParam String frb_id,
			String prjct_id) throws Exception{
		
		AnswerVO dyAnswerInfo =new AnswerVO();
		dyAnswerInfo.setAnswer_cn(answer_cn);
		dyAnswerInfo.setAnswer_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		dyAnswerInfo.setAnswer_grp(frb_id);
		
		service2.insertFrb(dyAnswerInfo);
		
		return "redirect:/empl/frb/frbView.do?frb_id="+frb_id;
	}
	
	
	@RequestMapping("deleteAnswerInfo")
	public String deleteAnswerInfo(
			Map<String, String> params,
			HttpSession session,
			String prjct_id,
			@RequestParam String answer_id,
			@RequestParam String frb_id
			) throws Exception{
		
		
		params.put("answer_id", answer_id);
	
		service2.deleteFrb(params);
		
		return "redirect:/empl/frb/frbView.do?frb_id="+frb_id;
	}
}















