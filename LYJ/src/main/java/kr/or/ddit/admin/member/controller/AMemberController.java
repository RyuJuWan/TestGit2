package kr.or.ddit.admin.member.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
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
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/member/")
public class AMemberController {
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private IOfcpsService ofcpsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
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
	 * 사원 목록 
	 */
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
		andView.setViewName("admin/member/emplList");
		
		return andView;
	}
	
	/**
	 * 사원 목록 -> 사원 등록 
	 */
	@RequestMapping("insertEmpl")
	public String insertEmpl(EmplVO emplInfo) throws Exception{
		String tempPass = makeTempPass(6);
		
		String empl_pass = this.passwordEncoder.encode(tempPass);
		emplInfo.setEmpl_pass(empl_pass);
		
		this.memberService.insertEmpl(emplInfo);
		
		try {
			MimeMessage mimeMsg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
			
			msgHelper.setFrom("remindPMS@gmail.com");
			msgHelper.setTo(emplInfo.getEmpl_mail());
			msgHelper.setSubject("remind(PMS)에 가입되었습니다.");
			msgHelper.setText("<html><body><img src='cid:remind'><br/>"
					+ "<h1>회원님의 아이디는 <mark>" + emplInfo.getEmpl_id() + "</mark> 이고,"
					+ "비밀번호는 <mark>" + tempPass + "</mark> 입니다.</h1></body></html>", true);
			
			FileSystemResource res = new FileSystemResource(new File("D:\\temp\\fileDocBase\\remind.jpg"));
			msgHelper.addInline("remind", res);
			
			mailSender.send(mimeMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/member/emplList.do";
	}
	
	/**
	 * 사원 목록 -> 사원 조회 
	 */
	@RequestMapping("emplView")
	public ModelAndView emplView(ModelAndView andView, String crqfcCurrentPage, String prjctHistCurrentPage,
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
		andView.setViewName("admin/member/emplView");
		
		return andView;
	}
	
	/**
	 * 사원 목록 -> 사원 조회 -> 사원 정보 수정
	 */
	@RequestMapping("updateEmpl")
	public String updateEmpl(EmplVO emplInfo, HttpSession session) throws Exception{
		String empl_pass = this.passwordEncoder.encode(emplInfo.getEmpl_pass());
		emplInfo.setEmpl_pass(empl_pass);
		
		if(emplInfo.getEmpl_bir() != null) emplInfo.setEmpl_bir(emplInfo.getEmpl_bir().substring(0, 10));
		if(emplInfo.getEmpl_ecny() != null) emplInfo.setEmpl_ecny(emplInfo.getEmpl_ecny().substring(0, 10));
		
		this.memberService.updateEmplInfo(emplInfo);
		
		return "redirect:/admin/member/emplView.do?empl_id=" + emplInfo.getEmpl_id();
	}
	
	/**
	 * 사원 목록 -> 사원 조회 -> 자격증 등록 
	 */
	@RequestMapping("insertCrqfcHold")
	public String insertCrqfc(CrqfcHoldVO crqfcHoldInfo, @RequestParam String empl_id) throws Exception{
		crqfcHoldInfo.setCrqfc_hold_empl(empl_id);
		
		this.crqfcService.insertCrqfcHold(crqfcHoldInfo);
		
		return "redirect:/admin/member/emplView.do?empl_id=" + empl_id;
	}
	
	/**
	 * 사원 목록 -> 사원 조회 -> 자격증 조회 -> 자격증 삭제
	 */
	@RequestMapping("deleteCrqfcHold")
	public String deleteCrqfcHold(CrqfcHoldVO crqfcHoldInfo) throws Exception{
		String empl_id = crqfcHoldInfo.getCrqfc_hold_empl();
		this.crqfcService.deleteCrqfcHold(crqfcHoldInfo);
		
		return "redirect:/admin/member/emplView.do?empl_id" + empl_id;
	}
	
	/**
	 * 사원 목록 -> 사원 조회 -> 프로젝트 이력 등록
	 */
	@RequestMapping("insertPrjctHist")
	public String insertPrjctHist(PrjctHistVO prjctHistInfo) throws Exception{
		String empl_id = prjctHistInfo.getPrjct_hist_empl();
		this.prjctHistService.insertPrjctHist(prjctHistInfo);
		
		return "redirect:/admin/member/emplView.do?empl_id=" + empl_id;
	}
	
	/**
	 * 사원 목록 -> 사원 조회 -> 프로젝트 이력 조회
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
	 * 사원 목록 -> 사원 조회 -> 프로젝트 이력 삭제
	 */
	@RequestMapping("deletePrjctHist")
	public String deletePrjctHist(Map<String, String> params, @RequestParam String prjct_hist_id, 
			@RequestParam String empl_id) throws Exception{
		params.put("prjct_hist_id", prjct_hist_id);
		
		this.prjctHistService.deletePrjctHist(params);
		
		return "redirect:/admin/member/emplView.do?empl_id" + empl_id;
	}
	
	public static String makeTempPass(int size){
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		String[] randomChars = 
				"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
		
		for(int i = 0; i < size; i++){
			buffer.append(randomChars[random.nextInt(randomChars.length)]);
		}
		
		return buffer.toString();
	}
	
	
}
