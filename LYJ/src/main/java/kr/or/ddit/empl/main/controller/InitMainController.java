package kr.or.ddit.empl.main.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.or.ddit.message.service.IMessageService;
import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.prjct_hist.service.IPrjctHistService;
import kr.or.ddit.reqre_specf.service.IReqreSpecfService;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.PrjctHistVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.ReqreSpecfVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/")
public class InitMainController {
	
	@Autowired
	private IPrjctService prjctService;
	
	
	@Autowired
	private IPrjctHistService prjctHistService;
	
	@Autowired
	private IMessageService messageService;
	
	@RequestMapping("main")
	public ModelAndView initScreen(HttpSession session, Map<String, String> params, 
			ModelAndView andView) throws Exception{
		
		
		
		
		List<PrjctVO> currentPrjctList = prjctService.currentPrjctList();
		session.setAttribute("currentPrjctList", currentPrjctList);
		
		params.put("empl_id", ((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		List<PrjctHistVO> prjctHistList = prjctHistService.prjctHistList(params);
		session.setAttribute("prjctHistList", prjctHistList);
		
		params.put("issue_chrg", ((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		String issCount=messageService.messageIssueCount(params);
		session.setAttribute("issCount",issCount);
		String wbsCount=messageService.messageWbsCount(params);
		session.setAttribute("wbsCount",wbsCount);
		
		int count = Integer.parseInt(issCount)+Integer.parseInt(wbsCount);
		andView.addObject("count", count);
		session.setAttribute("count", count);
		
		andView.setViewName("empl/init/initScreen");
		
		return andView;
	}
	
	@RequestMapping("messageChk")
	public ModelAndView messageChk(HttpSession session, Map<String, String> params,
			ModelAndView andView) throws Exception{
		params.put("issue_chrg", ((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		String issCount = messageService.messageIssueCount(params);
		String wbsCount = messageService.messageWbsCount(params);
		
		
		andView.addObject("issCount2", issCount);
		andView.addObject("wbsCount2", wbsCount);
		
		int count = Integer.parseInt(issCount)+Integer.parseInt(wbsCount);
		andView.addObject("count", count);
		andView.setViewName("jsonConvertView");
		
		return andView;
	}
}
