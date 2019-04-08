package kr.or.ddit.empl.member.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.crqfc.service.ICrqfcService;
import kr.or.ddit.dept.service.IDeptService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.ofcps.service.IOfcpsService;
import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.prjct_hist.service.IPrjctHistService;
import kr.or.ddit.role.service.IRoleService;
import kr.or.ddit.tech_class.service.ITechClassService;
import kr.or.ddit.utils.ARolePagingUtilCrqfc;
import kr.or.ddit.utils.ARolePagingUtilPrjctHist;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.utils.RolePagingUtilCrqfc;
import kr.or.ddit.utils.RolePagingUtilPrjctHist;
import kr.or.ddit.vo.CrqfcHoldVO;
import kr.or.ddit.vo.CrqfcVO;
import kr.or.ddit.vo.DeptVO;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.OfcpsVO;
import kr.or.ddit.vo.PrjctHistVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.RoleVO;
import kr.or.ddit.vo.TechClassVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/member/")
public class MemberController {
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IOfcpsService ofcpsService;
	
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private ITechClassService techClassService;
	
	@Autowired
	private ICrqfcService crqfcService;
	
	@Autowired
	private IPrjctService prjctService;
	
	@Autowired
	private IPrjctHistService prjctHistService;
	
	@Autowired
	private IRoleService roleService;
	
	private int blockCount = 3;
	private int blockPage = 3;
	
	/**
	 * 프로필 관리
	 */
	@RequestMapping("emplView")
	public ModelAndView emplView(ModelAndView andView, String crqfcCurrentPage, String prjctHistCurrentPage,
			HttpServletRequest request, HttpSession session, Map<String, String> params) throws Exception{
		if(crqfcCurrentPage == null){
			if(session.getAttribute("crqfcCurrentPage") == null) crqfcCurrentPage = "1";
			else crqfcCurrentPage = (String) session.getAttribute("crqfcCurrentPage");
		} else session.setAttribute("crqfcCurrentPage", crqfcCurrentPage);
		
		if(prjctHistCurrentPage == null){
			if(session.getAttribute("prjctHistCurrentPage") == null) prjctHistCurrentPage = "1";
			else prjctHistCurrentPage = (String) session.getAttribute("prjctHistCurrentPage");
		} else session.setAttribute("prjctHistCurrentPage", prjctHistCurrentPage);
		
		List<OfcpsVO> ofcpsList = this.ofcpsService.ofcpsList();
		List<DeptVO> deptList = this.deptService.deptList();
		List<TechClassVO> techClassList = this.techClassService.techClassList();
		List<CrqfcVO> crqfcList = this.crqfcService.crqfcList();
		List<PrjctVO> prjctList = this.prjctService.prjctList();
		
		EmplVO emplInfo = (EmplVO) session.getAttribute("LOGIN_EMPLINFO");
		params.put("empl_id", emplInfo.getEmpl_id());
		
		List<CrqfcHoldVO> crqfcHoldList = this.crqfcService.crqfcHoldList(params);
		int crqfcTotalCount = this.crqfcService.totalCount(params);
		RolePagingUtilCrqfc crqfcPagingUtil = 
				new RolePagingUtilCrqfc(crqfcTotalCount, Integer.parseInt(crqfcCurrentPage), request, this.blockCount, this.blockPage);
		String crqfcStartCount = String.valueOf(crqfcPagingUtil.getStartCount());
		String crqfcEndCount = String.valueOf(crqfcPagingUtil.getEndCount());
		params.put("crqfcStartCount", crqfcStartCount);
		params.put("crqfcEndCount", crqfcEndCount);
		List<CrqfcHoldVO> crqfcHoldPageList = this.crqfcService.crqfcHoldPageList(params);
		
		List<PrjctHistVO> prjctHistList = this.prjctHistService.prjctHistList(params);
		int prjctHistTotalCount = this.prjctHistService.totalCount(params);
		RolePagingUtilPrjctHist prjctHistPagingUtil = 
				new RolePagingUtilPrjctHist(prjctHistTotalCount, Integer.parseInt(prjctHistCurrentPage), request, this.blockCount, this.blockPage);
		String prjctHistStartCount = String.valueOf(prjctHistPagingUtil.getStartCount());
		String prjctHistEndCount = String.valueOf(prjctHistPagingUtil.getEndCount());
		params.put("prjctHistStartCount", prjctHistStartCount);
		params.put("prjctHistEndCount", prjctHistEndCount);
		List<PrjctHistVO> prjctHistPageList = this.prjctHistService.prjctHistPageList(params);
		for(PrjctHistVO prjctHistInfo : prjctHistPageList){
			prjctHistInfo.setPrjct_hist_inpt(prjctHistInfo.getPrjct_hist_inpt().substring(0, 10));
			prjctHistInfo.setPrjct_hist_clos(prjctHistInfo.getPrjct_hist_clos().substring(0, 10));
		}
		
		List<RoleVO> roleList = this.roleService.roleList();
		
		andView.addObject("ofcpsList", ofcpsList);
		andView.addObject("deptList", deptList);
		andView.addObject("techClassList", techClassList);
		andView.addObject("crqfcList", crqfcList);
		andView.addObject("crqfcHoldList", crqfcHoldList);
		andView.addObject("crqfcHoldPageList", crqfcHoldPageList);
		andView.addObject("crqfcCurrentPage", crqfcCurrentPage);
		andView.addObject("crqfcPagingUtil", crqfcPagingUtil.getPageHtmls());
		andView.addObject("prjctList", prjctList);
		andView.addObject("prjctHistList", prjctHistList);
		andView.addObject("prjctHistPageList", prjctHistPageList);
		andView.addObject("prjctHistCurrentPage", prjctHistCurrentPage);
		andView.addObject("prjctHistPagingUtil", prjctHistPagingUtil.getPageHtmls());
		andView.addObject("roleList", roleList);
		andView.setViewName("empl/member/emplView");
		
		return andView;
	}
	
	/**
	 * 프로필 관리 -> 내 정보 수정
	 */
	@RequestMapping("updateEmpl")
	public String updateEmpl(EmplVO emplInfo, HttpSession session) throws Exception{
		emplInfo.setEmpl_id(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		String empl_pass = this.passwordEncoder.encode(emplInfo.getEmpl_pass());
		emplInfo.setEmpl_pass(empl_pass);
		
		if(emplInfo.getEmpl_bir() != null) emplInfo.setEmpl_bir(emplInfo.getEmpl_bir().substring(0, 10));
		if(emplInfo.getEmpl_ecny() != null) emplInfo.setEmpl_ecny(emplInfo.getEmpl_ecny().substring(0, 10));
		
		this.memberService.updateEmplInfo(emplInfo);
		
		session.setAttribute("LOGIN_EMPLINFO", emplInfo);
		
		return "redirect:/empl/member/emplView.do";
	}
	
	/**
	 * 프로필 관리 -> 자격증 등록
	 */
	@RequestMapping("insertCrqfcHold")
	public String insertCrqfc(CrqfcHoldVO crqfcHoldInfo, HttpSession session) throws Exception{
		crqfcHoldInfo.setCrqfc_hold_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		
		this.crqfcService.insertCrqfcHold(crqfcHoldInfo);
		
		return "redirect:/empl/member/emplView.do";
	}
	
	/**
	 * 프로필 관리 -> 자격증 조회 -> 자격증 삭제
	 */
	@RequestMapping("deleteCrqfcHold")
	public String deleteCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception{
		this.crqfcService.deleteCrqfcHold(crqfcHoldInfo);
		
		return "redirect:/empl/member/emplView.do";
	}
	
	/**
	 * 프로필 관리 -> 프로젝트 이력 등록	 
	 */
	@RequestMapping("insertPrjctHist")
	public String insertPrjctHist(PrjctHistVO prjctHistInfo, HttpSession session) throws Exception{
		prjctHistInfo.setPrjct_hist_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		
		this.prjctHistService.insertPrjctHist(prjctHistInfo);
		
		return "redirect:/empl/member/emplView.do";
	}
	
	/**
	 * 프로필 관리 -> 프로젝트 이력 조회
	 */
	@RequestMapping("prjctHistView")
	public ModelAndView prjctHistView(String prjct_hist_id, 
			Map<String, String> params, ModelAndView andView) throws Exception{
		params.put("prjct_hist_id", prjct_hist_id);
		PrjctHistVO prjctHistInfo = this.prjctHistService.prjctHistView(params);
		prjctHistInfo.setPrjct_hist_inpt(prjctHistInfo.getPrjct_hist_inpt().substring(0, 10));
		prjctHistInfo.setPrjct_hist_clos(prjctHistInfo.getPrjct_hist_clos().substring(0, 10));
		
		andView.addObject("prjctHistInfo", prjctHistInfo);
		andView.setViewName("jsonConvertView");
		
		return andView;
	}
	
	/**
	 * 프로필 관리 -> 프로젝트 이력 조회 -> 프로젝트 이력 삭제
	 */
	@RequestMapping("deletePrjctHist")
	public String deletePrjctHist(Map<String, String> params, @RequestParam String prjct_hist_id) throws Exception{
		params.put("prjct_hist_id", prjct_hist_id);
		
		this.prjctHistService.deletePrjctHist(params);
		
		return "redirect:/empl/member/emplView.do";
	}
	
	@RequestMapping("changeCrqfcPage")
	public ModelAndView changeCrqfcPage(String crqfcCurrentPage, Map<String, String> params, 
			HttpServletRequest request, ModelAndView andView, HttpSession session) throws Exception{
		EmplVO emplInfo = (EmplVO) session.getAttribute("LOGIN_EMPLINFO");
		params.put("empl_id", emplInfo.getEmpl_id());
		
		List<CrqfcVO> crqfcList = this.crqfcService.crqfcList();
		
		List<CrqfcHoldVO> crqfcHoldList = this.crqfcService.crqfcHoldList(params);
		int crqfcTotalCount = this.crqfcService.totalCount(params);
		RolePagingUtilCrqfc crqfcPagingUtil = 
				new RolePagingUtilCrqfc(crqfcTotalCount, Integer.parseInt(crqfcCurrentPage), request, this.blockCount, this.blockPage);
		String crqfcStartCount = String.valueOf(crqfcPagingUtil.getStartCount());
		String crqfcEndCount = String.valueOf(crqfcPagingUtil.getEndCount());
		params.put("crqfcStartCount", crqfcStartCount);
		params.put("crqfcEndCount", crqfcEndCount);
		List<CrqfcHoldVO> crqfcHoldPageList = this.crqfcService.crqfcHoldPageList(params);
		
		andView.addObject("crqfcList", crqfcList);
		andView.addObject("crqfcHoldList", crqfcHoldList);
		andView.addObject("crqfcHoldPageList", crqfcHoldPageList);
		andView.addObject("crqfcCurrentPage", crqfcCurrentPage);
		andView.addObject("crqfcPagingUtil", crqfcPagingUtil.getPageHtmls());
		andView.setViewName("jsonConvertView");
		
		return andView;
	}
	
	@RequestMapping("emplList")
	public ModelAndView emplList(ModelAndView andView, String currentPage, String deptFilter,
			HttpSession session, HttpServletRequest request, Map<String, String> params) throws Exception{
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		if(deptFilter == null){
			if(session.getAttribute("deptFilter") == null) deptFilter = null;
			else deptFilter = (String) session.getAttribute("deptFilter");
		} else session.setAttribute("deptFilter", deptFilter);
		
		params.put("empl_dept", deptFilter);
		
		int emplTotalCount = this.memberService.totalCount(params);
		RolePagingUtil pagingUtil = new RolePagingUtil(emplTotalCount, Integer.parseInt(currentPage), request);
		
		String emplStartCount = String.valueOf(pagingUtil.getStartCount());
		String emplEndCount = String.valueOf(pagingUtil.getEndCount());
		params.put("emplStartCount", emplStartCount);
		params.put("emplEndCount", emplEndCount);
		List<EmplVO> emplPageList = this.memberService.emplPageList(params);
		for(EmplVO emplInfo : emplPageList){
			if(emplInfo.getEmpl_bir() != null) emplInfo.setEmpl_bir(emplInfo.getEmpl_bir().substring(0, 10));
			if(emplInfo.getEmpl_ecny() != null) emplInfo.setEmpl_ecny(emplInfo.getEmpl_ecny().substring(0, 10));
		}
		
		List<DeptVO> deptList = this.deptService.deptList();
		List<Integer> totalCountPerDeptList = new ArrayList<Integer>();
		for(DeptVO deptInfo : deptList){
			params.put("empl_dept", deptInfo.getDept_id());
			totalCountPerDeptList.add(this.memberService.totalCount(params));
		}
		
		List<OfcpsVO> ofcpsList = this.ofcpsService.ofcpsList();
		
		andView.addObject("emplTotalCount", emplTotalCount);
		andView.addObject("totalCountPerDeptList", totalCountPerDeptList);
		andView.addObject("emplPageList", emplPageList);
		andView.addObject("deptList", deptList);
		andView.addObject("ofcpsList", ofcpsList);
		andView.setViewName("empl/member/emplList");
		
		return andView;
	}
	
	@RequestMapping("emplView2")
	public ModelAndView emplView2(ModelAndView andView, String crqfcCurrentPage, String prjctHistCurrentPage,
			@RequestParam String empl_id, HttpSession session, HttpServletRequest request, Map<String, String> params) throws Exception{
		if(crqfcCurrentPage == null){
			if(session.getAttribute("crqfcCurrentPage") == null) crqfcCurrentPage = "1";
			else crqfcCurrentPage = (String) session.getAttribute("crqfcCurrentPage");
		} else session.setAttribute("crqfcCurrentPage", crqfcCurrentPage);
		
		if(prjctHistCurrentPage == null){
			if(session.getAttribute("prjctHistCurrentPage") == null) prjctHistCurrentPage = "1";
			else prjctHistCurrentPage = (String) session.getAttribute("prjctHistCurrentPage");
		} else session.setAttribute("prjctHistCurrentPage", prjctHistCurrentPage);
		
		List<OfcpsVO> ofcpsList = this.ofcpsService.ofcpsList();
		List<DeptVO> deptList = this.deptService.deptList();
		List<TechClassVO> techClassList = this.techClassService.techClassList();
		List<CrqfcVO> crqfcList = this.crqfcService.crqfcList();
		List<PrjctVO> prjctList = this.prjctService.prjctList();
		
		params.put("empl_id", empl_id);
		EmplVO emplInfo = this.memberService.emplInfo(params);
		if(emplInfo.getEmpl_bir() != null) emplInfo.setEmpl_bir(emplInfo.getEmpl_bir().substring(0, 10));
		if(emplInfo.getEmpl_ecny() != null) emplInfo.setEmpl_ecny(emplInfo.getEmpl_ecny().substring(0, 10));
		
		List<CrqfcHoldVO> crqfcHoldList = this.crqfcService.crqfcHoldList(params);
		int crqfcTotalCount = this.crqfcService.totalCount(params);
		ARolePagingUtilCrqfc crqfcPagingUtil = 
				new ARolePagingUtilCrqfc(crqfcTotalCount, Integer.parseInt(crqfcCurrentPage), request, this.blockCount, this.blockPage, empl_id);
		String crqfcStartCount = String.valueOf(crqfcPagingUtil.getStartCount());
		String crqfcEndCount = String.valueOf(crqfcPagingUtil.getEndCount());
		params.put("crqfcStartCount", crqfcStartCount);
		params.put("crqfcEndCount", crqfcEndCount);
		List<CrqfcHoldVO> crqfcHoldPageList = this.crqfcService.crqfcHoldPageList(params);
		
		List<PrjctHistVO> prjctHistList = this.prjctHistService.prjctHistList(params);
		int prjctHistTotalCount = this.prjctHistService.totalCount(params);
		ARolePagingUtilPrjctHist prjctHistPagingUtil = 
				new ARolePagingUtilPrjctHist(prjctHistTotalCount, Integer.parseInt(prjctHistCurrentPage), request, this.blockCount, this.blockPage, empl_id);
		String prjctHistStartCount = String.valueOf(prjctHistPagingUtil.getStartCount());
		String prjctHistEndCount = String.valueOf(prjctHistPagingUtil.getEndCount());
		params.put("prjctHistStartCount", prjctHistStartCount);
		params.put("prjctHistEndCount", prjctHistEndCount);
		List<PrjctHistVO> prjctHistPageList = this.prjctHistService.prjctHistPageList(params);
		for(PrjctHistVO prjctHistInfo : prjctHistPageList){
			prjctHistInfo.setPrjct_hist_inpt(prjctHistInfo.getPrjct_hist_inpt().substring(0, 10));
			prjctHistInfo.setPrjct_hist_clos(prjctHistInfo.getPrjct_hist_clos().substring(0, 10));
		}
		
		List<RoleVO> roleList = this.roleService.roleList();
		
		andView.addObject("emplInfo", emplInfo);
		andView.addObject("ofcpsList", ofcpsList);
		andView.addObject("deptList", deptList);
		andView.addObject("techClassList", techClassList);
		andView.addObject("crqfcList", crqfcList);
		andView.addObject("crqfcHoldList", crqfcHoldList);
		andView.addObject("crqfcHoldPageList", crqfcHoldPageList);
		andView.addObject("crqfcCurrentPage", crqfcCurrentPage);
		andView.addObject("crqfcPagingUtil", crqfcPagingUtil.getPageHtmls());
		andView.addObject("prjctList", prjctList);
		andView.addObject("prjctHistList", prjctHistList);
		andView.addObject("prjctHistPageList", prjctHistPageList);
		andView.addObject("prjctHistCurrentPage", prjctHistCurrentPage);
		andView.addObject("prjctHistPagingUtil", prjctHistPagingUtil.getPageHtmls());
		andView.addObject("roleList", roleList);
		andView.setViewName("empl/member/emplView2");
		
		return andView;
	}
}
