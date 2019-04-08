package kr.or.ddit.empl.dy_reqre_specf.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.reqre_specf.service.IReqreSpecfService;
import kr.or.ddit.sanctn_line.service.ISanctnlineService;
import kr.or.ddit.sanctn_papert_ty.service.ISanctnpaperstyService;
import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.ReqreSpecfVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_reqre_specf/")
public class Dy_Reqre_SpecfController {
	
	@Autowired
	private IReqreSpecfService service;
	
	@Autowired
	private ISanctnlineService service2;
	
	@Autowired
	private ISanctnpaperstyService service3; 
	
	@Autowired
	private IPrjctService pService;
	
	@RequestMapping("check")
	public String check(Map<String, String> params, @RequestParam String prjct_id) throws Exception{
		params.put("prjct_id", prjct_id);
		String reqreSpecfId = service.getReqreSpecfId(params);
		
		if(reqreSpecfId != null){ //아이디가 있으면 
			return "redirect:/empl/dy_reqre_specf/dy_reqre_specfView.do";
		}else{
			return "forward:/empl/dy_reqre_specf/dy_reqre_specfForm.do?prjct_id="+prjct_id;
		}
	}
	

	
	@RequestMapping("dy_reqre_specfForm")
	public ModelAndView dy_reqre_specfForm(Map<String, String> params,
			@RequestParam String prjct_id,
			ModelAndView andView) throws Exception{
		List<SanctnLineVO> sanctnlineList = this.service2.sanctnlineList(params);
		List<SanctnPapersTyVO> sanctnpaperstyList = this.service3.sanctnpaperstyList(params);

		andView.addObject("sanctnlineList", sanctnlineList);
		andView.addObject("sanctnpaperstyList", sanctnpaperstyList);

		params.put("prjct_id", prjct_id);
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String prjNm = service.getPrjctName(params);
		
		List<PrjctVO> projectInfo = pService.prjctList();
		
		andView.addObject("projectInfo",projectInfo);
		andView.addObject("prjNm",prjNm);
		andView.addObject("today", today);
		andView.addObject("prjct_id",prjct_id);
		
		andView.setViewName("empl/dy_reqre_specf/dy_reqre_specfForm");
		return andView;
	
	}
	
	@RequestMapping("insertReqreSpecf")
	public String insertReqreSpecf(ReqreSpecfVO reqreSpecfInfo, HttpSession session) throws Exception{
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		reqreSpecfInfo.setReqre_specf_wrting_date(today);
		
		reqreSpecfInfo.setReqre_specf_cn(reqreSpecfInfo.getReqre_specf_cn().replaceAll("\r\n\r\n", "<br>"));
		reqreSpecfInfo.setReqre_specf_cn(reqreSpecfInfo.getReqre_specf_cn().replaceAll("\r\n", ""));
		reqreSpecfInfo.setReqre_specf_cn(reqreSpecfInfo.getReqre_specf_cn().replaceAll("<p>&nbsp;</p>", ""));
		
	    service.insertReqreSpecf(reqreSpecfInfo);
		
		return "redirect:/empl/dy_reqre_specf/dy_reqre_specfView.do";
	}
	
	@RequestMapping("updateReqreSpecf")
	public String updateReqreSpecf(
			ReqreSpecfVO reqreSpecfInfo,
			Map<String,String> params, String prjct_id)throws Exception{
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		reqreSpecfInfo.setReqre_specf_wrting_date(today);
		reqreSpecfInfo.setReqre_specf_cn(reqreSpecfInfo.getReqre_specf_cn().replaceAll("\r\n\r\n", "<br>"));
		reqreSpecfInfo.setReqre_specf_cn(reqreSpecfInfo.getReqre_specf_cn().replaceAll("\r\n", ""));
		reqreSpecfInfo.setReqre_specf_cn(reqreSpecfInfo.getReqre_specf_cn().replaceAll("<p>&nbsp;</p>", ""));
		
		service.updateReqreSpecf(reqreSpecfInfo);
		
		return "redirect:/empl/dy_reqre_specf/dy_reqre_specfView.do?prjct_id="+prjct_id;
	}
	
	@RequestMapping("dy_reqre_specfView")
	public ModelAndView dy_reqre_specfView(
			@RequestParam String prjct_id,
			Map<String,String> param,
			HttpSession session,
			HttpServletRequest request,
			ModelAndView andView) throws Exception{
		param.put("prjct_id", prjct_id);
		
		String prjNm = service.getPrjctName(param);
		
		ReqreSpecfVO reqreSpecfInfo = service.reqreSpecfInfo(param);
		List<SanctnLineVO> sanctnlineList = service2.sanctnlineList(param);
		List<SanctnPapersTyVO> sanctnpaperstyList = service3.sanctnpaperstyList(param);
		
		reqreSpecfInfo.setReqre_specf_wrting_date(reqreSpecfInfo.getReqre_specf_wrting_date().substring(0, 10));
		
		andView.addObject("sanctnlineList",sanctnlineList);
		andView.addObject("sanctnpaperstyList",sanctnpaperstyList);
		
		andView.addObject("prjNm",prjNm);
		andView.addObject("prjct_id",prjct_id);
		andView.addObject("reqreSpecfInfo",reqreSpecfInfo);
		andView.setViewName("empl/dy_reqre_specf/dy_reqre_specfView");
		
		return andView;
	}
	 
	
}















