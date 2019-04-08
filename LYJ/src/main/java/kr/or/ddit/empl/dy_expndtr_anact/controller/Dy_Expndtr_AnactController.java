package kr.or.ddit.empl.dy_expndtr_anact.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.expndtr_anact.service.IExpndtrAnactService;
import kr.or.ddit.file.service.ExpndtrAnactFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.prjct.service.IPrjctService;
import kr.or.ddit.sanctn_line.service.ISanctnlineService;
import kr.or.ddit.sanctn_papert_ty.service.ISanctnpaperstyService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.AdminVO;
import kr.or.ddit.vo.ExpndtrAnactFileVO;
import kr.or.ddit.vo.ExpndtrAnactVO;
import kr.or.ddit.vo.NoticeVO;
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
@RequestMapping("/empl/dy_expndtr_anact/")
public class Dy_Expndtr_AnactController {
	
	@Autowired
	private IExpndtrAnactService service; 
	
	@Autowired
	private ISanctnlineService service2;
	
	@Autowired
	private ISanctnpaperstyService service3; 
	
	@Autowired
	private IPrjctService pService;
	
	@Autowired
	private ExpndtrAnactFileService fService;
	
	@RequestMapping("dy_expndtr_anactList")
	public ModelAndView dy_expndtr_anactList(
			String currentPage,
			String search_keyword,
			String search_keycode, 
			String paging,
			String search,
			HttpServletRequest request, 
			@RequestParam String prjct_id,
			ModelAndView andView, 
			Map<String, String> params,
			HttpSession session
			) throws Exception{
		
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		if(search_keycode == null){
			search_keycode = (String) session.getAttribute("search_keycode");
		}
		if(search_keyword == null){
			search_keyword = (String) session.getAttribute("search_keyword");
		}
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		int totalCount = service.totalCount(params);
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, 10, 5, "prjct_id=" + prjct_id + "&");
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());

		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		List<ExpndtrAnactVO> expndtrAnactList = this.service.expndtrAnactList(params);
		
		andView.addObject("expndtrAnactList",expndtrAnactList);
		andView.addObject("prjct_id",prjct_id);
		andView.addObject("currentPage",currentPage);
		andView.addObject("pagingUtil",pagingUtil.getPageHtmls());
		andView.setViewName("empl/dy_expndtr_anact/dy_expndtr_anactList");
		
		return andView;
	}
	
	@RequestMapping("dy_expndtr_anactView")
	public ModelAndView expndtrAnactView(
			@RequestParam String expndtr_anact_id, 
			@RequestParam String prjct_id,
			Map<String, String> param,
			Map<String, String> param2,
			HttpSession session, 
			HttpServletRequest request, 
			ModelAndView andView 
			) throws Exception{
		
		param.put("expndtr_anact_id", expndtr_anact_id);
		ExpndtrAnactVO expndtrAnactInfo = service.expndtrAnactInfo(param);
		
		param2.put("bo_id", expndtr_anact_id);
		ExpndtrAnactFileVO expFileInfo = fService.fileItemInfo(param2);
		
		List<ExpndtrAnactVO> expndtrAnactList = service.expndtrAnactList(param);
		
		andView.addObject("expFileInfo",expFileInfo);
		andView.addObject("expndtrAnactInfo",expndtrAnactInfo);
		andView.addObject("expndtrAnactList",expndtrAnactList);
		andView.addObject("prjct_id",prjct_id);
		andView.setViewName("empl/dy_expndtr_anact/dy_expndtr_anactView");
		
		return andView;
	}
	
	@RequestMapping("dy_expndtr_anactForm")
	public ModelAndView expndtrAnactForm(
			Map<String, String> params,
			@RequestParam String prjct_id,
			ModelAndView andView
			) throws Exception{
		List<SanctnLineVO> sanctnlineList = this.service2.sanctnlineList(params);
		List<SanctnPapersTyVO> sanctnpaperstyList = this.service3.sanctnpaperstyList(params);
		
		andView.addObject("sanctnlineList", sanctnlineList);
		andView.addObject("sanctnpaperstyList", sanctnpaperstyList);

		params.put("prjct_id", prjct_id);
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		List<PrjctVO> projectInfo = pService.prjctList();
		
		andView.addObject("projectInfo",projectInfo);
		andView.addObject("today", today);
		andView.addObject("prjct_id",prjct_id);
		
		andView.setViewName("empl/dy_expndtr_anact/dy_expndtr_anactForm");
		return andView;
	}
	
	@RequestMapping("insertExpndtrAnact")
	public String insertExpndtrAnact(
			ExpndtrAnactVO expndtrAnactInfo,
			@RequestParam String prjct_id,
			HttpSession session) throws Exception{
		  //      작성일자
	      Date now = new Date();
	      SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	      String today = sf.format(now);
	      sf = new SimpleDateFormat("yyyy-MM-dd");
	      today = sf.format(now);
	      
	      expndtrAnactInfo.setExpndtr_anact_date(today);
	      
	      expndtrAnactInfo.setExpndtr_anact_cn(expndtrAnactInfo.getExpndtr_anact_cn().replaceAll("\r\n\r\n", "<br>"));
	      expndtrAnactInfo.setExpndtr_anact_cn(expndtrAnactInfo.getExpndtr_anact_cn().replaceAll("\r\n", ""));
	      expndtrAnactInfo.setExpndtr_anact_cn(expndtrAnactInfo.getExpndtr_anact_cn().replaceAll("<p>&nbsp;</p>", ""));
	      
	      service.insertExpndtrAnact(expndtrAnactInfo);
	      
		return "redirect:/empl/dy_expndtr_anact/dy_expndtr_anactList.do?prjct_id="+prjct_id;
	}
	
	@RequestMapping("updateExpndtrAnact")
	public String updateExpndtrAnact(
			ExpndtrAnactVO expndtrAnactInfo,
			@RequestParam String expndtr_anact_id, 
			@RequestParam String prjct_id,
			Map<String,String> params 
			)throws Exception{
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = sf.format(now);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		today = sf.format(now);
		
		expndtrAnactInfo.setExpndtr_anact_date(today);
		expndtrAnactInfo.setExpndtr_anact_cn(expndtrAnactInfo.getExpndtr_anact_cn().replaceAll("\r\n\r\n", "<br>"));
		expndtrAnactInfo.setExpndtr_anact_cn(expndtrAnactInfo.getExpndtr_anact_cn().replaceAll("\r\n", ""));
		expndtrAnactInfo.setExpndtr_anact_cn(expndtrAnactInfo.getExpndtr_anact_cn().replaceAll("<p>&nbsp;</p>", ""));
		String exp = expndtrAnactInfo.getExpndtr_anact_id();
		
		params.put("bo_id", exp);
		service.updateExpndtrAnact(expndtrAnactInfo,params);
		
		return "redirect:/empl/dy_expndtr_anact/dy_expndtr_anactView.do?prjct_id="+prjct_id+"&expndtr_anact_id="+expndtr_anact_id;
	}
	
	@RequestMapping("dy_expndtr_anactUpdate")
	public ModelAndView expndtrAnactUpdateForm(
			Map<String, String> params,
			Map<String, String> param2,
			@RequestParam String expndtr_anact_id, 
			@RequestParam String prjct_id,
			ModelAndView andView
			) throws Exception{
		
		List<SanctnLineVO> sanctnlineList = this.service2.sanctnlineList(params);
		List<SanctnPapersTyVO> sanctnpaperstyList = this.service3.sanctnpaperstyList(params);
		
		params.put("expndtr_anact_id", expndtr_anact_id);
		ExpndtrAnactVO expndtrAnactInfo = service.expndtrAnactInfo(params);
		
		param2.put("bo_id", expndtr_anact_id);
		ExpndtrAnactFileVO expFileInfo = fService.fileItemInfo(param2);
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		List<PrjctVO> projectInfo = pService.prjctList();
		
		andView.addObject("expFileInfo",expFileInfo);
		andView.addObject("expndtrAnactInfo",expndtrAnactInfo);
		andView.addObject("sanctnlineList", sanctnlineList);
		andView.addObject("sanctnpaperstyList", sanctnpaperstyList);
		
		andView.addObject("projectInfo",projectInfo);
		andView.addObject("prjct_id",prjct_id);
		andView.addObject("today", today);
		andView.addObject("expndtr_anact_id",expndtr_anact_id);
		
		andView.setViewName("empl/dy_expndtr_anact/dy_expndtr_anactUpdate");
		return andView;
	}
	
	@RequestMapping("deleteExpndtrAnact")
	public String deleteExpndtrAnact(	
			@RequestParam String prjct_id,
			@RequestParam String expndtr_anact_id) throws Exception{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("expndtr_anact_id", expndtr_anact_id);
		
		service.deleteExpndtrAnact(params);
		
		return "redirect:/empl/dy_expndtr_anact/dy_expndtr_anactList.do?prjct_id="+prjct_id;
	}
	
	@RequestMapping("fileExistence")
	public ModelAndView fileExistence(ModelAndView andView) throws Exception{
		andView.setViewName("jsonConvertView");
		return andView;
	}
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(ExpndtrAnactFileVO fileItemVO,
			@RequestParam String exp, 
			ModelAndView andView,
			Map<String,String> params ) 
		throws Exception{
		
		andView.setViewName("downloadView");
		params.put("bo_id", exp);
		fileItemVO =this.fService.fileItemInfo(params);
		String fileName= fileItemVO.getExpndtr_anact_file_nm();
		String fileSaveName= fileItemVO.getExpndtr_anact_file_save_nm();
		
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		andView.addObject("downloadFile", downloadFile);
		andView.addObject("fileName",  fileName);
		return andView;
	}
	
}















