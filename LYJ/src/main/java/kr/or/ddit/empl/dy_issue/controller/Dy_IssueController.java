package kr.or.ddit.empl.dy_issue.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dy_issue.service.IDy_issueService;
import kr.or.ddit.message.service.IMessageService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.IpcrVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.MessageVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.SttusVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_issue/")
public class Dy_IssueController {
	
	@Autowired
	private IDy_issueService service;
	
	@Autowired
	private IMessageService service2;
	
	
	
	@RequestMapping("dy_issueList")
	public ModelAndView dy_issueList(@RequestParam String prjct_id,ModelAndView andView, String currentPage, 
			HttpServletRequest request, HttpSession session, Map<String, String> params, String search_keycode, 
			String search_keyword) throws Exception{
		// 
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		session.setAttribute("search_keycode", search_keycode);
		session.setAttribute("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, 10, 5, "prjct_id=" + prjct_id + "&");
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		params.put("prjct_id", prjct_id);
		params.put("issue_prjct", prjct_id);
		
		List<IssueVO> issueList = this.service.boardList(params);
		List<SttusVO> sttusList = this.service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		List<RiskVO> riskList = service.getAllRisk(params);
		
		andView.addObject("riskList", riskList);
		andView.addObject("issueList", issueList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.setViewName("empl/dy_issue/dy_issueList");
		
		return andView;
	}
	
	@RequestMapping("sttusIssueList")
	public ModelAndView sttusIssueList(@RequestParam String prjct_id, @RequestParam String issue_sttus,ModelAndView andView, 
			String currentPage, HttpServletRequest request, HttpSession session, Map<String, String> params, String search_keycode, String search_keyword) throws Exception{
		// 
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		if(session.getAttribute("search_keyword") != null || session.getAttribute("search_keycode") != null){
			session.removeAttribute("search_keyword");
			session.removeAttribute("search_keycode");
		}
		
		params.put("search_keycode", "");
		params.put("search_keyword", "");
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, 10, 5, "prjct_id=" + prjct_id + "&");
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		params.put("issue_sttus", issue_sttus);
		params.put("prjct_id", prjct_id);
		params.put("issue_prjct", prjct_id);
		
		List<IssueVO> issueList = this.service.selectSttueBoardList(params);
		List<SttusVO> sttusList = this.service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		List<RiskVO> riskList = service.getAllRisk(params);
		
		andView.addObject("riskList", riskList);
		andView.addObject("issueList", issueList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil", pagingUtil);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("prjct_id", prjct_id);
		andView.setViewName("empl/dy_issue/dy_issueList");
		
		return andView;
	}
	
	@RequestMapping("dy_issueForm")
	public ModelAndView dy_issueForm(@RequestParam String prjct_id, ModelAndView andView, Map<String, String> params) throws Exception{
		params.put("issue_prjct", prjct_id);
		String prjct_nm = service.getPrjctName(params);
		List<IpcrVO> ipcrList = service.getAllIpcr();
		List<SttusVO> sttusList = service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		List<RiskVO> riskList = service.getAllRisk(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("riskList", riskList);
		andView.setViewName("empl/dy_issue/dy_issueForm");
		return andView;
	}
	
	@RequestMapping("dy_issueView")
	public ModelAndView dy_issueView(@RequestParam String issue_id, @RequestParam String prjct_id,ModelAndView andView, Map<String, String> params, IssueVO issueInfo) throws Exception{
		params.put("issue_id", issue_id);
		params.put("issue_prjct", prjct_id);
		
		issueInfo = service.boardViewInfo(params);
		String prjct_nm = service.getPrjctName(params);
		List<IpcrVO> ipcrList = service.getAllIpcr();
		List<SttusVO> sttusList = service.getAllSttus();
		List<EmplVO> prjctEmpl = service.getPrjctEmpl(params);
		List<RiskVO> riskList = service.getAllRisk(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjct_nm", prjct_nm);
		andView.addObject("ipcrList", ipcrList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("riskList", riskList);
		andView.addObject("issueInfo", issueInfo);
		
		params.put("message_cn", issueInfo.getIssue_id());
		service2.messageDelete(params);
		
		andView.setViewName("empl/dy_issue/dy_issueView");
		return andView;
	}
	
	@RequestMapping("dy_issueInsert")
	public String dy_issueInsert(IssueVO issueInfo,
			HttpSession session) throws Exception{
		String prjct_id = issueInfo.getIssue_prjct();
		issueInfo.setIssue_cn(issueInfo.getIssue_cn().replaceAll("\r\n\r\n", "<br>"));
	    issueInfo.setIssue_cn(issueInfo.getIssue_cn().replaceAll("\r\n", ""));
	    issueInfo.setIssue_cn(issueInfo.getIssue_cn().replaceAll("<p>&nbsp;</p>", ""));
		String issue_id = service.insertBoard(issueInfo);
		
		MessageVO messageInfo =new MessageVO();
		messageInfo.setMessage_rcver(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		messageInfo.setMessage_nm("이슈");
		messageInfo.setMessage_cn(issue_id);
		
		service2.messageInsert(messageInfo);
		
		
		return "redirect:/empl/dy_issue/dy_issueList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("dy_issueUpdate")
	public String dy_issueUpdate(IssueVO issueInfo) throws Exception{
		String prjct_id = issueInfo.getIssue_prjct();
		issueInfo.setIssue_cn(issueInfo.getIssue_cn().replaceAll("\r\n\r\n", "<br>"));
	    issueInfo.setIssue_cn(issueInfo.getIssue_cn().replaceAll("\r\n", ""));
	    issueInfo.setIssue_cn(issueInfo.getIssue_cn().replaceAll("<p>&nbsp;</p>", ""));
		service.updateBoard(issueInfo);
		return "redirect:/empl/dy_issue/dy_issueList.do?prjct_id=" + prjct_id;
	}
}
