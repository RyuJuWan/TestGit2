package kr.or.ddit.empl.prpsl.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.file.service.PrpslFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.prpsl.service.IPrpslService;
import kr.or.ddit.rqpps.service.IRqppsService;
import kr.or.ddit.sanctn_line.service.ISanctnlineService;
import kr.or.ddit.sanctn_papert_ty.service.ISanctnpaperstyService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.PrpslFileVO;
import kr.or.ddit.vo.PrpslVO;
import kr.or.ddit.vo.RqppsVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/prpsl/")
public class PrpslController {
	
	@Autowired
	private IPrpslService service;
	
	@Autowired
	private IRqppsService service2;
	
	@Autowired
	private ISanctnlineService service3;
	
	@Autowired
	private ISanctnpaperstyService service4;
	
	@Autowired
	private PrpslFileService fservice;
	
	
	@RequestMapping("prpslList")
	public ModelAndView prpslList(String currentPage,
			String search_keyword, String search_keycode, String paging,
			String search, HttpServletRequest request, HttpSession session,
			ModelAndView andView, Map<String, String> params) throws Exception{
		
		if (search != null) {
			session.removeAttribute("currentPage");
		}

		if (currentPage == null || currentPage == "") {
			if (session.getAttribute("currentPage") != null) {
				currentPage = (String) session.getAttribute("currentPage");
			} else {
				currentPage = "1";
			}
		}

		if (search_keycode == null) {
			search_keycode = (String) session.getAttribute("search_keycode");
		}
		if (search_keyword == null) {
			search_keyword = (String) session.getAttribute("search_keyword");
		}
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);

		int totalCount = service.totalCount(params);

		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount,
				Integer.parseInt(currentPage), request);

		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<PrpslVO> prpslList =this.service.prpslList(params);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		andView.addObject("currentPage", currentPage);

		andView.addObject("paging", pagingUtil.getPageHtmls());
		
		andView.addObject("prpslList",prpslList);
		andView.setViewName("empl/prpsl/prpslList");
		
		return andView;
	}
	
	@RequestMapping("prpslView")
	public ModelAndView prpslView(@RequestParam String prpsl_id,
			Map<String, String> param,
			Map<String, String> param2,
			HttpSession session, 
			HttpServletRequest request,
			PrpslVO prpslInfo,
			ModelAndView andView) throws Exception{
		param.put("prpsl_id", prpsl_id);
		prpslInfo = service.prpsInfo(param);
		
		
		param2.put("bo_id", prpsl_id );
		PrpslFileVO prpslFileInfo = fservice.fileItemInfo(param2);
//		param.put("startCount", "1");
//		param.put("endCount", "1");
		
		List<RqppsVO> rqppsInfoList =  service2.rqppsList(param);
		List<SanctnLineVO> sanctnlineList =  service3.sanctnlineList(param);
		List<SanctnPapersTyVO> sanctnpaperstyList =  service4.sanctnpaperstyList(param);
		
		

		andView.addObject("prpslInfo", prpslInfo);
		andView.addObject("prpslFileInfo", prpslFileInfo);
		andView.addObject("rqppsInfoList",rqppsInfoList);
		andView.addObject("sanctnlineList",sanctnlineList);
		andView.addObject("sanctnpaperstyList",sanctnpaperstyList);
		
		andView.setViewName("empl/prpsl/prpslView");

		return andView;
	}
	
	
	@RequestMapping("prpslModify")
	public String prpslModify(PrpslVO prpslInfo,
			Map<String,String> params)throws Exception{
		
		
		
//		작성일자
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		prpslInfo.setPrpsl_wrting_date(today);
		prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("\r\n\r\n", "<br>"));
		prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("\r\n", ""));
//		prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("<br><br>", "<br>"));
		prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("<p>&nbsp;</p>", ""));
		String prpsl= prpslInfo.getPrpsl_id();
		
		params.put("bo_id", prpsl);
		service.prpslModify(prpslInfo,params);
		
		return "redirect:/empl/prpsl/prpslList.do";
		
		
	}
	
	@RequestMapping("prpslDelete")
	public String prpslDelete(@RequestParam String prpsl_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("prpsl_id", prpsl_id);
		
		service.deletePrpsl(params);
		
		return "redirect:/empl/prpsl/prpslList.do";
	}
	
	
	@RequestMapping("prpslForm")
	public ModelAndView prpslForm(
			Map<String, String> params,
			ModelAndView andView) throws Exception{
		
		List<RqppsVO> rqppsInfoList =  service2.rqppsList(params);
		List<SanctnLineVO> sanctnlineList =  service3.sanctnlineList(params);
		List<SanctnPapersTyVO> sanctnpaperstyList =  service4.sanctnpaperstyList(params);
		
		

		andView.addObject("rqppsInfoList", rqppsInfoList);
		andView.addObject("sanctnpaperstyList", sanctnpaperstyList);
		andView.addObject("sanctnlineList", sanctnlineList);
		
		andView.setViewName("empl/prpsl/prpslForm");
		
		return andView;
	}
	
	@RequestMapping("prpslInsert")
	public String prpslInsert(PrpslVO prpslInfo, HttpSession session) throws Exception{
	//      작성일자
	      Date now = new Date();
	      SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	      String today = sf.format(now);
	      sf = new SimpleDateFormat("yyyy-MM-dd");
	      today = sf.format(now);
	      
	      prpslInfo.setPrpsl_wrting_date(today);
	      prpslInfo.setPrpsl_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());

	      prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("\r\n\r\n", "<br>"));
	      prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("\r\n", ""));
//			prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("<br><br>", "<br>"));
	      prpslInfo.setPrpsl_cn(prpslInfo.getPrpsl_cn().replaceAll("<p>&nbsp;</p>", ""));

	      
	      service.prpslInsert(prpslInfo);
		
		return "redirect:/empl/prpsl/prpslList.do";
	}
	
	
	@RequestMapping("fileExistence")
	public ModelAndView fileExistence(ModelAndView andView) throws Exception{
		andView.setViewName("jsonConvertView");
		return andView;
	}
	
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(PrpslFileVO fileItemVO, @RequestParam String prpsl, ModelAndView andView, Map<String, String> params) throws Exception{
		andView.setViewName("downloadView");
		params.put("bo_id", prpsl);
		fileItemVO = this.fservice.fileItemInfo(params);
		String fileName = fileItemVO.getPrpsl_file_nm();
		String fileSaveName = fileItemVO.getPrpsl_file_save_nm();
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		andView.addObject("downloadFile", downloadFile);
		andView.addObject("fileName", fileName);
		return andView;
	}
}

