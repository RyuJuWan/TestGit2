package kr.or.ddit.empl.hnfInpt.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.file.service.IHnfInptFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.hnfInpt.service.IHnfInptService;
import kr.or.ddit.utils.CryptoGenerator;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.HnfInptFileVO;
import kr.or.ddit.vo.HnfInptPlanVO;
import kr.or.ddit.vo.HnfInptVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.PrpslVO;
import kr.or.ddit.vo.SanctnLineVO;
import kr.or.ddit.vo.SanctnPapersTyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/hnfInpt/")
public class HnfInptController {
	@Autowired
	private IHnfInptService service;
	
	@Autowired
	private IHnfInptFileService fservice;
	
	@RequestMapping("hnfInptList")
	public ModelAndView hnfInptList(ModelAndView andView, String currentPage, HttpServletRequest request,
			HttpSession session, Map<String, String> params)throws Exception{
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		int totalCount = service.totalCount();
		
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request);
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<HnfInptVO> hnfInptList = this.service.boardList(params);
		andView.addObject("hnfInptList", hnfInptList);
		andView.addObject("currentPage", currentPage);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.setViewName("empl/hnfInpt/hnfInptList");
		
		return andView;
	}
	
	@RequestMapping("hnfInptForm")
	public ModelAndView hnfInptForm(Map<String,String> params, ModelAndView andView, HttpSession session)throws Exception{
		List<HnfInptPlanVO> planList = this.service.getAllHnfInptPlanList();
		List<PrjctVO> prjctList = this.service.getAllPrjct();
		List<PrpslVO> prpslList = this.service.getAllPrpsl();
		List<SanctnLineVO> sanctnLineList = this.service.getAllSanctn_Line();
		List<SanctnPapersTyVO> sanctnPapersTyList = this.service.getAllSanctn_Papers_Ty();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		andView.addObject("planList", planList);
		andView.addObject("prjctList", prjctList);
		andView.addObject("prpslList", prpslList);
		andView.addObject("sanctnLineList", sanctnLineList);
		andView.addObject("sanctnPapersTyList", sanctnPapersTyList);
		andView.addObject("today", today);
		
		return andView;
	}
	
	@RequestMapping("hnfInptView")
	public ModelAndView hnfInptView(@RequestParam String hnfID,
			Map<String, String> params,
			Map<String, String> params2,
			Map<String, String> params3,
			ModelAndView andView,
			HnfInptVO hnfInptInfo)throws Exception{
		params.put("hnfID", hnfID);
		hnfInptInfo = service.boardView(params);
		
		params2.put("bo_id", hnfInptInfo.getHnf_inpt_actpln_id());
		HnfInptFileVO hnfInptFileInfo = fservice.fileItemInfo(params2);
		
		params3.put("hnf_inpt_prjct_id", hnfInptInfo.getHnf_inpt_prjct_id());
		String prjctNM = service.getPrjctName(params3);
		
		andView.addObject("hnfInptInfo", hnfInptInfo);
		andView.addObject("hnfInptFileInfo", hnfInptFileInfo);
		andView.addObject("prjctNM", prjctNM);
		andView.setViewName("empl/hnfInpt/hnfInptView");
		return andView;
	}
	
	@RequestMapping("insertHnfInpt")
	public String insertHnfInpt(HnfInptVO hnfInptInfo) throws Exception{
		this.service.insertBoard(hnfInptInfo);
		return "redirect:/empl/hnfInpt/hnfInptList.do";
	}
	
	@RequestMapping("updateHnfInpt")
	public String updateHnfInpt(HnfInptVO hnfInptInfo,
			Map<String, String> params
			) throws Exception{
		String hnf_inpt = hnfInptInfo.getHnf_inpt_actpln_id(); 
		params.put("bo_id", hnf_inpt);
		this.service.updateBoard(hnfInptInfo, params);
		return "redirect:/empl/hnfInpt/hnfInptList.do";
	}
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(HnfInptFileVO fileItemVO, @RequestParam String hnf_inpt, ModelAndView andView, Map<String, String> params) throws Exception{
		andView.setViewName("downloadView");
		params.put("bo_id", hnf_inpt);
		fileItemVO = this.fservice.fileItemInfo(params);
		String fileName = fileItemVO.getHnf_inpt_file_nm();
		String fileSaveName = fileItemVO.getHnf_inpt_file_save_nm();
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		andView.addObject("downloadFile", downloadFile);
		andView.addObject("fileName", fileName);
		return andView;
	}
	
	@RequestMapping("fileExistence")
	public ModelAndView fileExistence(ModelAndView andView) throws Exception{
		andView.setViewName("jsonConvertView");
		return andView;
	}
}
