package kr.or.ddit.empl.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.or.ddit.dept.service.IDeptService;
import kr.or.ddit.hnfInpt.service.IHnfInptService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.ofcps.service.IOfcpsService;
import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.prjct_hist.service.IPrjctHistService;
import kr.or.ddit.prpsl.service.IPrpslService;
import kr.or.ddit.role.service.IRoleService;
import kr.or.ddit.vo.DeptVO;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.OfcpsVO;
import kr.or.ddit.vo.PrjctHistVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.PrpslVO;
import kr.or.ddit.vo.RoleVO;

import org.apache.taglibs.standard.lang.jstl.AndOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/project/")
public class ProjectController {
	
	@Autowired
	private IPrjctService service;
	
	@Autowired
	private IHnfInptService hservice;
	
	@Autowired
	private IPrpslService pservice;
	
	@Autowired
	private IMemberService mservice;
	
	@Autowired
	private IRoleService rservice;
	
	@Autowired
	private IDeptService dservice;
	
	@Autowired
	private IPrjctHistService phService;
	
	@Autowired
	private IOfcpsService oservice;
	
	@RequestMapping("projectForm")
	public ModelAndView projectForm(
			Map<String, String> params,
			HttpSession session,
			ModelAndView andView) throws Exception{
		List<PrpslVO> prpslList =this.pservice.getPrpslId();
		
		andView.addObject("prpslList",prpslList);
		
		return andView;
	}
	
	@RequestMapping("projectView")
	public ModelAndView projectView(
			Map<String, String> params,
			@RequestParam String prjct_id,
			ModelAndView andView
			) throws Exception{
		
		params.put("prjct_id", prjct_id);
		PrjctVO projectInfo = service.projectInfo(params);
		andView.addObject("projectInfo",projectInfo); 
		
		List<PrpslVO> prpslList =this.pservice.getPrpslId();
		
		andView.addObject("prpslList",prpslList);
		andView.addObject("prjct_id",prjct_id);
		
		andView.setViewName("empl/project/projectView");
		return andView;
	}
	
	@RequestMapping("emplManage")
	public ModelAndView emplManage(
			ModelAndView andView,
			Map<String,String> params,
			String prjct_id
			) throws Exception{
		params.put("prjct_id", prjct_id);
		
		List<EmplVO> emplList = mservice.emplList();
		List<RoleVO> roleList = rservice.roleList();
		List<DeptVO> deptList = dservice.deptList();
		List<OfcpsVO> ofcpsList = oservice.ofcpsList();
		
		PrjctVO prjctInfo = service.projectInfo(params);
		List<PrjctHistVO> prjctHistList = phService.prjctMemberList(params);
	
		
		andView.addObject("emplList", emplList);
		andView.addObject("roleList", roleList);
		andView.addObject("deptList", deptList);
		andView.addObject("ofcpsList", ofcpsList);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("prjctInfo", prjctInfo);
		andView.addObject("prjctHistList1", prjctHistList);
		
		andView.setViewName("empl/project/emplManage");
		return andView;
	}
	
	@RequestMapping("emplManageModal")
	public ModelAndView emplManage(Map<String, String> params,
			Map<String, String> params2,
			String empl_dept, String prjct_id,
			ModelAndView andView) throws Exception{

		params.put("empl_dept", empl_dept);
		List<EmplVO> emplInfo = mservice.selectDeptEmpl(params);
		
		andView.addObject("emplInfo",emplInfo);
		
		andView.setViewName("jsonConvertView");
		return andView;
	}
	
	
	@RequestMapping("insertPrjctMember")
	public String insertPrjctMember(
			PrjctHistVO prjctHistInfo,String prjct_id, 
			HttpSession session) throws Exception{
		phService.insertPrjctHist(prjctHistInfo);
		return "redirect:/empl/project/emplManage.do?prjct_id="+prjct_id;
	}
	
	@RequestMapping("insertProject")
	public String insertProject(
			PrjctVO projectInfo, 
			HttpSession session) throws Exception{

		projectInfo.setPrjct_cn(projectInfo.getPrjct_cn().replaceAll("\r\n\r\n", "<br>"));
	    projectInfo.setPrjct_cn(projectInfo.getPrjct_cn().replaceAll("\r\n", ""));
	    projectInfo.setPrjct_cn(projectInfo.getPrjct_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
		service.insertProject(projectInfo);
		return "redirect:/empl/main.do";
	}
	@RequestMapping("updateProject")
	public String updateProject(
			PrjctVO projectInfo, 
			@RequestParam String prjct_id,
			Map<String, String> params
			) throws Exception{
		
		projectInfo.setPrjct_cn(projectInfo.getPrjct_cn().replaceAll("\r\n\r\n", "<br>"));
		projectInfo.setPrjct_cn(projectInfo.getPrjct_cn().replaceAll("\r\n", ""));
		projectInfo.setPrjct_cn(projectInfo.getPrjct_cn().replaceAll("<p>&nbsp;</p>", ""));
		    
		service.updateProject(projectInfo);
		
		return "redirect:/empl/project/projectView.do?prjct_id="+prjct_id;
	}
	

}

















