package kr.or.ddit.empl.dy_risk.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dy_risk.service.IDy_riskService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_risk/")
public class Dy_RiskController {
	@Autowired
	IDy_riskService service;
	
	@RequestMapping("dy_riskList")
	public ModelAndView dy_riskList(@RequestParam String prjct_id, ModelAndView andView, String currentPage,
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
		params.put("risk_prjct", prjct_id);
		
		List<RiskVO> riskList = this.service.boardList(params);
		List<SttusVO> sttusList = this.service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		
		andView.addObject("riskList", riskList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.setViewName("empl/dy_risk/dy_riskList");
		return andView;
	}
	

	@RequestMapping("dy_riskForm")
	public ModelAndView dy_riskForm(@RequestParam String prjct_id ,ModelAndView andView, Map<String, String> params)throws Exception{
		params.put("risk_prjct", prjct_id);
		String prjct_nm = service.getPrjctName(params);
		List<IpcrVO> ipcrList = service.getAllIpcr();
		List<SttusVO> sttusList = service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.setViewName("empl/dy_risk/dy_riskForm");
		return andView;
	}
	
	@RequestMapping("dy_riskView")
	public ModelAndView dy_riskView(@RequestParam String risk_id, @RequestParam String prjct_id, 
			ModelAndView andView, Map<String, String> params, RiskVO riskInfo)throws Exception{
		
		params.put("risk_id", risk_id);
		params.put("risk_prjct", prjct_id);
		
		riskInfo = service.boardViewInfo(params);
		String prjct_nm = service.getPrjctName(params);
		List<IpcrVO> ipcrList = service.getAllIpcr();
		List<SttusVO> sttusList = service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("riskInfo", riskInfo);
		
		andView.setViewName("empl/dy_risk/dy_riskView");
		return andView;
	}
	
	@RequestMapping("dy_riskInsert")
	public String dy_riskInsert(RiskVO riskInfo) throws Exception{
		String prjct_id = riskInfo.getRisk_prjct();
		riskInfo.setRisk_cn(riskInfo.getRisk_cn().replaceAll("\r\n\r\n", "<br>"));
	    riskInfo.setRisk_cn(riskInfo.getRisk_cn().replaceAll("\r\n", ""));
	    riskInfo.setRisk_cn(riskInfo.getRisk_cn().replaceAll("<p>&nbsp;</p>", ""));
	    service.insertBoard(riskInfo);
		return "redirect:/empl/dy_risk/dy_riskList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("dy_riskUpdate.do")
	public String dy_riskUpdate(RiskVO riskInfo) throws Exception{
		String prjct_id = riskInfo.getRisk_prjct();
		riskInfo.setRisk_cn(riskInfo.getRisk_cn().replaceAll("\r\n\r\n", "<br>"));
	    riskInfo.setRisk_cn(riskInfo.getRisk_cn().replaceAll("\r\n", ""));
	    riskInfo.setRisk_cn(riskInfo.getRisk_cn().replaceAll("<p>&nbsp;</p>", ""));
	    service.updateBoard(riskInfo);
		return "redirect:/empl/dy_risk/dy_riskList.do?prjct_id=" + prjct_id;
	}
} 
