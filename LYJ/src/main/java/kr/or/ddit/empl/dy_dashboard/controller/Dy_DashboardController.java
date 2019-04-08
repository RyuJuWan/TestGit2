package kr.or.ddit.empl.dy_dashboard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dept.service.IDeptService;
import kr.or.ddit.dy_flaw.service.IDy_flawService;
import kr.or.ddit.dy_issue.service.IDy_issueService;
import kr.or.ddit.dy_risk.service.IDy_riskService;
import kr.or.ddit.dynm.dyNotice.service.IDyNoticeService;
import kr.or.ddit.dynm.dyWbs.service.IDyWbsService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.ofcps.service.IOfcpsService;
import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.prjct_hist.service.IPrjctHistService;
import kr.or.ddit.role.service.IRoleService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.DeptVO;
import kr.or.ddit.vo.DynmNoticeVO;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.OfcpsVO;
import kr.or.ddit.vo.PrjctHistVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.RiskVO;
import kr.or.ddit.vo.RoleVO;
import kr.or.ddit.vo.SttusVO;
import kr.or.ddit.vo.WBSVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/empl/dy_dashboard/")
public class Dy_DashboardController {
	
	@Autowired
	private IDy_issueService issueService;
	
	@Autowired
	private IDyWbsService wbsService;
	
	@Autowired
	private IDy_flawService fservice;
	
	@Autowired
	private IMemberService mservice;
	
	@Autowired
	private IRoleService rservice;
	
	@Autowired
	private IDeptService dservice;
	
	@Autowired
	private IOfcpsService oservice;
	
	@Autowired
	private IPrjctService pservice;
	
	@Autowired
	private IPrjctHistService phService;
	
	@Autowired
	private IDy_riskService riskService;
	
	@Autowired
	private IDyNoticeService nservice;
	
	@RequestMapping("dashboardView")
	public ModelAndView dashboardView(
			String prjct_id,
			String issue_sttus,
			HttpSession session, 
			HttpServletRequest request, 
			Map<String, String> params,
			Map<String, String> params2,
			Map<String, String> params3,
			Map<String, String> riskparams,
			ModelAndView andView,
			 String currentPage,
			 String search_keycode, 
			String search_keyword) throws Exception{
		
		////////////////////이슈/////////////////////////////////////////////////
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		session.setAttribute("search_keycode", search_keycode);
		session.setAttribute("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(5, Integer.parseInt(currentPage), request);
		
		String issueStartCount = String.valueOf(pagingUtil.getStartCount());
		String issueEndCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", issueStartCount);
		params.put("endCount", issueEndCount);
		params.put("prjct_id", prjct_id);
		params.put("issue_prjct", prjct_id);
		
		List<IssueVO> issueList = issueService.boardList(params);
		List<SttusVO> sttusList = issueService.getAllSttus();
		List<EmplVO> prjctEmpl = issueService.getPrjctEmpl(params);
		List<RiskVO> riskList = issueService.getAllRisk(params);
		andView.addObject("prjctEmpl", prjctEmpl);
		andView.addObject("issueList", issueList);
		andView.addObject("sttusList", sttusList);
		andView.addObject("riskList", riskList);
		
		////////////////////////리스크//////////////////////////////////////
		
		RolePagingUtil pagingUtil5 = new RolePagingUtil(5, Integer.parseInt(currentPage), request);
		
		String riskStartCount = String.valueOf(pagingUtil5.getStartCount());
		String riskEndCount = String.valueOf(pagingUtil5.getEndCount());
		riskparams.put("startCount", riskStartCount);
		riskparams.put("endCount", riskEndCount);
		riskparams.put("prjct_id", prjct_id);
		riskparams.put("risk_prjct", prjct_id);
		
		List<RiskVO> riskList2 = riskService.boardList(riskparams);
		List<SttusVO> sttusList2 = riskService.getAllSttus();
		List<EmplVO> prjctEmpl2 = riskService.getPrjctEmpl(riskparams);
		
		andView.addObject("riskList2", riskList2);
		andView.addObject("sttusList2", sttusList2);
		andView.addObject("prjctEmpl2", prjctEmpl2);
		
		//////////////////////////////////업무관리게시판////////////////////////////////////
		
		session.setAttribute("search_keycode", search_keycode);
		session.setAttribute("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		RolePagingUtil pagingUtil2 = new RolePagingUtil(5, Integer.parseInt(currentPage), request);
		
		String wbsStartCount = String.valueOf(pagingUtil2.getStartCount());
		String wbsEndCount = String.valueOf(pagingUtil2.getEndCount());
		params.put("startCount", wbsStartCount);
		params.put("endCount", wbsEndCount);
		List<WBSVO> wbsList = wbsService.boardList(params);
		
		//////////////////////////////////공지사항///////////////////////////////////////////

		session.setAttribute("search_keycode", search_keycode);
		session.setAttribute("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		RolePagingUtil pagingUtil3 = new RolePagingUtil(5, Integer.parseInt(currentPage), request);
		
		String noStartCount = String.valueOf(pagingUtil3.getStartCount());
		String noEndCount = String.valueOf(pagingUtil3.getEndCount());
		params.put("startCount", noStartCount);
		params.put("endCount", noEndCount);
		List<DynmNoticeVO> dyNoticeList = nservice.noticeList(params);
		///////////////////////////////////////////////////////////////////////////////
		
		params.put("prjct_id", prjct_id);
		List<EmplVO> emplList = mservice.emplList();
		List<RoleVO> roleList = rservice.roleList();
		List<DeptVO> deptList = dservice.deptList();
		List<OfcpsVO> ofcpsList = oservice.ofcpsList();
		
		List<PrjctHistVO> prjctHistList = phService.prjctMemberList(params);
		andView.addObject("prjctHistList1", prjctHistList);
		andView.addObject("emplList", emplList);
		andView.addObject("roleList", roleList);
		andView.addObject("deptList", deptList);
		andView.addObject("ofcpsList", ofcpsList);
		
		
		////////////////////결함게시판//////////////////////////////////////////////////
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		session.setAttribute("search_keycode", search_keycode);
		session.setAttribute("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		RolePagingUtil pagingUtil4 = new RolePagingUtil(5, Integer.parseInt(currentPage), request);
		
		String flawStartCount = String.valueOf(pagingUtil4.getStartCount());
		String flawEndCount = String.valueOf(pagingUtil4.getEndCount());
		params.put("startCount", flawStartCount);
		params.put("endCount", flawEndCount);
		params.put("flaw_prjct", prjct_id);
		List<FlawVO> flawList = fservice.boardList(params);
		List<SttusVO> sttusList3 = fservice.getAllSttus();
		List<EmplVO> prjctEmpl3 = fservice.getPrjctEmpl(params);
		///////////////////////////////////////////////////////////////////////////////////////
		
		andView.addObject("dyNoticeList", dyNoticeList);
		andView.addObject("flawList", flawList);
		andView.addObject("wbsList", wbsList);
		
		andView.addObject("sttusList3", sttusList3);
		
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.addObject("prjct_id", prjct_id);
	
		andView.addObject("prjctEmpl3", prjctEmpl3);
		
		params2.put("issue_sttus", "st001");
		int issueCount1 = issueService.sttusCount(params2);
		
		params2.put("issue_sttus", "st002");
		int issueCount2 = issueService.sttusCount(params2);
		
		params2.put("issue_sttus", "st003");
		int issueCount3 = issueService.sttusCount(params2);
		
		params2.put("issue_sttus", "st004");
		int issueCount4 = issueService.sttusCount(params2);
		
		params2.put("issue_sttus", "st005");
		int issueCount5 = issueService.sttusCount(params2);
		
		andView.addObject("issueCount1", issueCount1);
		andView.addObject("issueCount2", issueCount2);
		andView.addObject("issueCount3", issueCount3);
		andView.addObject("issueCount4", issueCount4);
		andView.addObject("issueCount5", issueCount5);
		///////////////////////////////////////////////////////////////////////////
		
		params3.put("flaw_sttus", "st001");
		int flawCount1 = fservice.flawSttusCount(params3);
		
		params3.put("flaw_sttus", "st002");
		int flawCount2 = fservice.flawSttusCount(params3);
		
		params3.put("flaw_sttus", "st003");
		int flawCount3 = fservice.flawSttusCount(params3);
		
		params3.put("flaw_sttus", "st004");
		int flawCount4 = fservice.flawSttusCount(params3);
		
		params3.put("flaw_sttus", "st005");
		int flawCount5 = fservice.flawSttusCount(params3);
		
		andView.addObject("flawCount1",flawCount1);
		andView.addObject("flawCount2",flawCount2);
		andView.addObject("flawCount3",flawCount3);
		andView.addObject("flawCount4",flawCount4);
		andView.addObject("flawCount5",flawCount5);
		
		///////////////////////////////////////////////////////////////////////////
		
		params3.put("wbs_progrs", "st001");
		int wbsCount1 = wbsService.wbsSttusCount(params);
		
		params3.put("wbs_progrs", "st002");
		int wbsCount2 = wbsService.wbsSttusCount(params);
		
		params3.put("wbs_progrs", "st003");
		int wbsCount3 = wbsService.wbsSttusCount(params);
		
		params3.put("wbs_progrs", "st004");
		int wbsCount4 = wbsService.wbsSttusCount(params);
		
		params3.put("wbs_progrs", "st005");
		int wbsCount5 = wbsService.wbsSttusCount(params);
		
		andView.addObject("wbsCount1",wbsCount1);
		andView.addObject("wbsCount2",wbsCount2);
		andView.addObject("wbsCount3",wbsCount3);
		andView.addObject("wbsCount4",wbsCount4);
		andView.addObject("wbsCount5",wbsCount5);
		
		andView.setViewName("empl/dy_dashboard/dashboardView");
		
		return andView;
	}
 
}















