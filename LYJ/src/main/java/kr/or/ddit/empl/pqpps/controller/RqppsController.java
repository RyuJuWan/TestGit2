package kr.or.ddit.empl.pqpps.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.rqpps.service.IRqppsService;
import kr.or.ddit.sanctn_line.service.ISanctnlineService;
import kr.or.ddit.sanctn_papert_ty.service.ISanctnpaperstyService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.RqppsVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/rqpps/")
public class RqppsController {
	@Autowired
	private IRqppsService service;
	@Autowired
	private ISanctnlineService service2;
	@Autowired
	private ISanctnpaperstyService service3;
	
	@RequestMapping("rqppsList")
	public ModelAndView rqppsList(String currentPage,
			String search_keyword,
			String search_keycode, 
			String paging,
			String search,
			HttpServletRequest request,
			ModelAndView andView,
			Map<String, String> params,
			HttpSession session)throws Exception{
		
		if(search != null){
			session.removeAttribute("currentPage");
		}
		
		if(currentPage == null || currentPage == ""){
			if(session.getAttribute("currentPage") != null){
				currentPage = (String) session.getAttribute("currentPage");
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
		
//		for(RqppsVO rqppsInfo : rqppsList){
//			rqppsInfo.setRqpps_wrting_date(rqppsInfo.getRqpps_wrting_date().substring(0, 10));
//			rqppsInfo.setRqpps_prjct_start(rqppsInfo.getRqpps_prjct_start().substring(0, 10));
//			rqppsInfo.setRqpps_prjct_clos(rqppsInfo.getRqpps_prjct_clos().substring(0, 10));
//			rqppsInfo.setRqpps_clos_date(rqppsInfo.getRqpps_clos_date().substring(0, 10));
//		}
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request);
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<RqppsVO> rqppsList = this.service.rqppsList(params);
		
		andView.addObject("paging", pagingUtil.getPageHtmls());
		andView.addObject("currentPage", currentPage);
		andView.addObject("rqppsList", rqppsList);
		andView.setViewName("empl/rqpps/rqppsList");
		
		return andView;
	}
	
	@RequestMapping("rqppsForm")
	public ModelAndView rqppsForm(
			Map<String, String> params,
			ModelAndView andView) throws Exception{
		
		List<SanctnPapersTyVO> sanctnpaperstyList = this.service3.sanctnpaperstyList(params);
		List<SanctnLineVO> sanctnlineList = this.service2.sanctnlineList(params);

		andView.addObject("sanctnpaperstyList", sanctnpaperstyList);
		andView.addObject("sanctnlineList", sanctnlineList);
		
		andView.setViewName("empl/rqpps/rqppsForm");
		
		return andView;
	}
	
	@RequestMapping("insertRqpps")
	public String insertRqpps(RqppsVO rqppsInfo) throws Exception{
		
	//      작성일자
	      Date now = new Date();
	      SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	      String today = sf.format(now);
	      sf = new SimpleDateFormat("yyyy-MM-dd");
	      today = sf.format(now);
	      
	      rqppsInfo.setRqpps_wrting_date(today);
	      
	      service.insertRqpps(rqppsInfo);
		
		return "redirect:/empl/rqpps/rqppsList.do";
	}
	
	
	@RequestMapping("rqppsView")
	public ModelAndView rqppsView(@RequestParam String rqpps_id,
			Map<String, String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView)throws Exception{
		param.put("rqpps_id", rqpps_id);
		
		RqppsVO rqppsInfo = service.rqppsInfo(param);
		List<SanctnLineVO> sanctnlineList = service2.sanctnlineList(param);
		List<SanctnPapersTyVO> sanctnpaperstyList = service3.sanctnpaperstyList(param);
		
		rqppsInfo.setRqpps_cn(rqppsInfo.getRqpps_cn().replaceAll("\r\n\r\n", "<br>"));
	    rqppsInfo.setRqpps_cn(rqppsInfo.getRqpps_cn().replaceAll("\r\n", ""));
	    rqppsInfo.setRqpps_cn(rqppsInfo.getRqpps_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
		rqppsInfo.setRqpps_wrting_date(rqppsInfo.getRqpps_wrting_date().substring(0, 10));
		rqppsInfo.setRqpps_prjct_start(rqppsInfo.getRqpps_prjct_start().substring(0, 10));
		rqppsInfo.setRqpps_prjct_clos(rqppsInfo.getRqpps_prjct_clos().substring(0, 10));
		rqppsInfo.setRqpps_clos_date(rqppsInfo.getRqpps_clos_date().substring(0, 10));
		
		andView.addObject("rqppsInfo", rqppsInfo);
		andView.addObject("sanctnlineList", sanctnlineList);
		andView.addObject("sanctnpaperstyList", sanctnpaperstyList);
	
		andView.setViewName("empl/rqpps/rqppsView");
		
		return andView;
	}
	
	@RequestMapping("modifyRqppsInfo")
	public String modifyRqpps(RqppsVO rqppsInfo,
			Map<String, String> params) throws Exception {
		
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		int totalCount = service.totalCount(params);
		
		rqppsInfo.setRqpps_cn(rqppsInfo.getRqpps_cn().replaceAll("\r\n\r\n", "<br>"));
	    rqppsInfo.setRqpps_cn(rqppsInfo.getRqpps_cn().replaceAll("\r\n", ""));
	    rqppsInfo.setRqpps_cn(rqppsInfo.getRqpps_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		rqppsInfo.setRqpps_wrting_date(today);
		service.modifyRqpps(rqppsInfo);

		return "redirect:/empl/rqpps/rqppsList.do";
	}
	
	@RequestMapping("deleteRqppsInfo")
	public String deleteRqpps(@RequestParam String rqpps_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("rqpps_id", rqpps_id);
		
		service.deleteRqpps(params);
		
		return "redirect:/empl/rqpps/rqppsList.do";
	}
}

















