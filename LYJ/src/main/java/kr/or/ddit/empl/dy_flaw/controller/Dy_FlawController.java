package kr.or.ddit.empl.dy_flaw.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dy_flaw.service.IDy_flawService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.SttusVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_flaw/")
public class Dy_FlawController {
	
	@Autowired
	private IDy_flawService service;
	
	@RequestMapping("dy_flawList")
	public ModelAndView dy_issueList(@RequestParam String prjct_id, ModelAndView andView, String currentPage,
			 HttpServletRequest request, HttpSession session, Map<String, String> params) throws Exception{
		
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, 10, 5, "prjct_id=" + prjct_id + "&");
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		params.put("prjct_id", prjct_id);
		params.put("flaw_prjct", prjct_id);
		
		List<FlawVO> flawList = this.service.boardList(params);
		List<SttusVO> sttusList = this.service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		
		andView.addObject("flawList", flawList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjctEmpl", prjctEmpl);
		
		andView.setViewName("empl/dy_flaw/dy_flawList");
		return andView;
	}
	
	@RequestMapping("dy_flawForm")
	public ModelAndView dy_flawForm(@RequestParam String prjct_id ,ModelAndView andView, Map<String, String> params)throws Exception{
		params.put("flaw_prjct", prjct_id);
		String prjct_nm = service.getPrjctName(params);
		List<IpcrVO> ipcrList = service.getAllIpcr();
		List<SttusVO> sttusList = service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.setViewName("empl/dy_flaw/dy_flawForm");
		return andView;
	}
	
	@RequestMapping("dy_flawView")
	public ModelAndView dy_flawView(@RequestParam String flaw_id, @RequestParam String prjct_id, 
			ModelAndView andView, Map<String, String> params, FlawVO flawInfo)throws Exception{
		
		params.put("flaw_id", flaw_id);
		params.put("flaw_prjct", prjct_id);
		
		flawInfo = service.boardViewInfo(params);
		String prjct_nm = service.getPrjctName(params);
		List<IpcrVO> ipcrList = service.getAllIpcr();
		List<SttusVO> sttusList = service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("flawInfo", flawInfo);
		
		andView.setViewName("empl/dy_flaw/dy_flawView");
		return andView;
	}
	
	@RequestMapping("dy_flawInsert")
	public String dy_flawInsert(FlawVO flawInfo) throws Exception{
		String prjct_id = flawInfo.getFlaw_prjct();
		flawInfo.setFlaw_cn(flawInfo.getFlaw_cn().replaceAll("\r\n\r\n", "<br>"));
	    flawInfo.setFlaw_cn(flawInfo.getFlaw_cn().replaceAll("\r\n", ""));
	    flawInfo.setFlaw_cn(flawInfo.getFlaw_cn().replaceAll("<p>&nbsp;</p>", ""));
	    service.insertBoard(flawInfo);
		return "redirect:/empl/dy_flaw/dy_flawList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("dy_flawUpdate.do")
	public String dy_flawUpdate(FlawVO flawInfo) throws Exception{
		String prjct_id = flawInfo.getFlaw_prjct();
		flawInfo.setFlaw_cn(flawInfo.getFlaw_cn().replaceAll("\r\n\r\n", "<br>"));
	    flawInfo.setFlaw_cn(flawInfo.getFlaw_cn().replaceAll("\r\n", ""));
	    flawInfo.setFlaw_cn(flawInfo.getFlaw_cn().replaceAll("<p>&nbsp;</p>", ""));
	    service.updateBoard(flawInfo);
		return "redirect:/empl/dy_flaw/dy_flawList.do?prjct_id=" + prjct_id;
	}
}















