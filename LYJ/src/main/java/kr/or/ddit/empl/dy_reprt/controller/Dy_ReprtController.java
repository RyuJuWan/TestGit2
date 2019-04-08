package kr.or.ddit.empl.dy_reprt.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.MorphAnalyzer.ChartMorphAnalyzer.ChartMorphAnalyzer;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.PosTagger.HmmPosTagger.HMMTagger;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PlainTextProcessor.InformalSentenceFilter.InformalSentenceFilter;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PosProcessor.NounExtractor.NounExtractor;
import kr.or.ddit.dy_reprt.service.IDy_reprtService;
import kr.or.ddit.file.service.IDy_reprtFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.sanctn_line.service.ISanctnlineService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.ReprtFileVO;
import kr.or.ddit.vo.ReprtVO;
import kr.or.ddit.vo.SanctnLineVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_reprt/")
public class Dy_ReprtController {
	
	@Autowired
	private IDy_reprtService reprtService;
	
	@Autowired
	private ISanctnlineService sanctnlineService;
	
	@Autowired
	private IDy_reprtFileService reprtFileService;
	
	@Autowired
	private IMemberService memberService;
	
	private int blockCount = 10;
	private int blockPage = 5;
	
	@RequestMapping("dy_weekReprtList")
	public ModelAndView dy_weekReprtList(ModelAndView andView, HttpSession session, HttpServletRequest request,
			String currentPage, Map<String, String> params, @RequestParam String prjct_id,
			String search_keyword, String search_keycode) throws Exception{
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		if(search_keycode == null){
			search_keycode = (String) session.getAttribute("search_keycode");
		} else session.setAttribute("search_keycode", search_keycode);
		
		if(search_keyword == null){
			search_keyword = (String) session.getAttribute("search_keyword");
		} else session.setAttribute("search_keyword", search_keyword);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		params.put("prjct_id", prjct_id);
		params.put("reprt_ty_id", "week");
		int totalCount = this.reprtService.totalCount(params);
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, this.blockCount, this.blockPage);
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		List<ReprtVO> weekReprtPageList = this.reprtService.reprtPageList(params);
		for(ReprtVO reprtInfo : weekReprtPageList){
			if(reprtInfo.getReprt_date() != null) reprtInfo.setReprt_date(reprtInfo.getReprt_date().substring(0, 10));
			if(reprtInfo.getReprt_start() != null) reprtInfo.setReprt_start(reprtInfo.getReprt_start().substring(0, 10));
			if(reprtInfo.getReprt_clos() != null) reprtInfo.setReprt_clos(reprtInfo.getReprt_clos().substring(0, 10));
		}
		
		andView.addObject("weekReprtPageList", weekReprtPageList);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.setViewName("empl/dy_reprt/dy_weekReprtList");
		
		return andView;
	}
	
	@RequestMapping("dy_mnthngReprtList")
	public ModelAndView dy_mnthngReprtList(ModelAndView andView, HttpSession session, HttpServletRequest request,
			String currentPage, Map<String, String> params, @RequestParam String prjct_id,
			String search_keyword, String search_keycode) throws Exception{
		if(currentPage == null){
			if(session.getAttribute("currentPage") == null) currentPage = "1";
			else currentPage = (String) session.getAttribute("currentPage");
		} else session.setAttribute("currentPage", currentPage);
		
		if(search_keycode == null){
			search_keycode = (String) session.getAttribute("search_keycode");
		} else session.setAttribute("search_keycode", search_keycode);
		
		if(search_keyword == null){
			search_keyword = (String) session.getAttribute("search_keyword");
		} else session.setAttribute("search_keyword", search_keyword);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		params.put("prjct_id", prjct_id);
		params.put("reprt_ty_id", "month");
		int totalCount = this.reprtService.totalCount(params);
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, this.blockCount, this.blockPage);
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		List<ReprtVO> mnthngReprtPageList = this.reprtService.reprtPageList(params);
		for(ReprtVO reprtInfo : mnthngReprtPageList){
			if(reprtInfo.getReprt_date() != null) reprtInfo.setReprt_date(reprtInfo.getReprt_date().substring(0, 10));
			if(reprtInfo.getReprt_start() != null) reprtInfo.setReprt_start(reprtInfo.getReprt_start().substring(0, 10));
			if(reprtInfo.getReprt_clos() != null) reprtInfo.setReprt_clos(reprtInfo.getReprt_clos().substring(0, 10));
		}
		
		andView.addObject("mnthngReprtPageList", mnthngReprtPageList);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.setViewName("empl/dy_reprt/dy_mnthngReprtList");
		
		return andView;
	}
	
	@RequestMapping("dy_weekReprtForm")
	public ModelAndView dy_weekReprtForm(ModelAndView andView, Map<String, String> params,
			@RequestParam String prjct_id) throws Exception{
		List<SanctnLineVO> sanctnLineList = this.sanctnlineService.sanctnlineList(params);
		
		andView.addObject("sanctnLineList", sanctnLineList);
		andView.addObject("prjct_id", prjct_id);
		andView.setViewName("empl/dy_reprt/dy_weekReprtForm");
		
		return andView;
	}
	
	@RequestMapping("dy_mnthngReprtForm")
	public ModelAndView dy_mnthngReprtForm(ModelAndView andView, Map<String, String> params,
			@RequestParam String prjct_id) throws Exception{
		List<SanctnLineVO> sanctnLineList = this.sanctnlineService.sanctnlineList(params);
		
		andView.addObject("sanctnLineList", sanctnLineList);
		andView.addObject("prjct_id", prjct_id);
		andView.setViewName("empl/dy_reprt/dy_mnthngReprtForm");
		
		return andView;
	}
	
	@RequestMapping("insertDy_weekReprt")
	public String insertDy_weekReprt(ReprtVO reprtInfo, HttpSession session, 
			@RequestParam String prjct_id) throws Exception{
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		
		reprtInfo.setReprt_prjct(prjct_id);
		reprtInfo.setReprt_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		reprtInfo.setReprt_date(today);
		if(reprtInfo.getReprt_start() != null) reprtInfo.setReprt_start(reprtInfo.getReprt_start().substring(0, 10));
		if(reprtInfo.getReprt_clos() != null) reprtInfo.setReprt_clos(reprtInfo.getReprt_clos().substring(0, 10));
		reprtInfo.setReprt_ty_id("week");
		
		reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n\r\n", "<br>"));
		reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n", ""));
	    reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
	    String path = "D:\\temp\\fileDocBase";
	    
	    Workflow workflow = new Workflow(path);
		workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
		workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), "conf/plugin/SupplementPlugin/PlainTextProcessor/InformalSentenceFilter.json");
		workflow.appendPosProcessor(new NounExtractor(), "conf/plugin/SupplementPlugin/PosProcessor/NounExtractor.json");
		
		workflow.activateWorkflow(true);
		
		String document = reprtInfo.getReprt_cn();
		workflow.analyze(document);
		
		LinkedList<Sentence> resultList = workflow.getResultOfDocument(new Sentence(0, 0, false));
		String[] morphemes = null;
		List<String> morphemesList = new ArrayList<String>();
		
		for(Sentence s : resultList){
			Eojeol[] eojeolArray = s.getEojeols();
			for(int i = 0; i < eojeolArray.length; i++){
				if(eojeolArray[i].length > 0){
					morphemes = eojeolArray[i].getMorphemes();
					 for (int j = 0; j < morphemes.length; j++) {
						 morphemesList.add(morphemes[j]);
					 }
				}
			}
		}
		
		Set<String> nounSet = new HashSet<String>();
		Map<String, Integer> nounCount = new HashMap<String, Integer>();
		
		for(String noun : morphemesList){
			if(noun.equals("p") || noun.equals("br")) continue;
			
			if(nounSet.contains(noun)) nounCount.put(noun, nounCount.get(noun) + 1);
			else nounCount.put(noun, 1);
			
			nounSet.add(noun);
		}
		
		List<Map<String, Object>> nounList = new ArrayList<Map<String, Object>>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		titleMap.put("noun", "noun");
		titleMap.put("frequency", "frequency");
		nounList.add(titleMap);
		
		for(String noun : nounSet){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("noun", noun);
			map.put("frequency", nounCount.get(noun));
			
			nounList.add(map);
		}
		
		workflow.close();
		
		this.reprtService.insertDy_reprt(reprtInfo, nounList);
		
		return "redirect:/empl/dy_reprt/dy_weekReprtList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("insertDy_mnthngReprt")
	public String insertDy_mnthngReprt(ReprtVO reprtInfo, HttpSession session, 
			@RequestParam String prjct_id) throws Exception{
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		
		reprtInfo.setReprt_prjct(prjct_id);
		reprtInfo.setReprt_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		reprtInfo.setReprt_date(today);
		if(reprtInfo.getReprt_start() != null) reprtInfo.setReprt_start(reprtInfo.getReprt_start().substring(0, 10));
		if(reprtInfo.getReprt_clos() != null) reprtInfo.setReprt_clos(reprtInfo.getReprt_clos().substring(0, 10));
		reprtInfo.setReprt_ty_id("month");
		
		reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n\r\n", "<br>"));
		reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n", ""));
	    reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
	    String path = "D:\\temp\\fileDocBase";
	    
	    Workflow workflow = new Workflow(path);
		workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
		workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), "conf/plugin/SupplementPlugin/PlainTextProcessor/InformalSentenceFilter.json");
		workflow.appendPosProcessor(new NounExtractor(), "conf/plugin/SupplementPlugin/PosProcessor/NounExtractor.json");
		
		workflow.activateWorkflow(true);
		
		String document = reprtInfo.getReprt_cn();
		workflow.analyze(document);
		
		LinkedList<Sentence> resultList = workflow.getResultOfDocument(new Sentence(0, 0, false));
		String[] morphemes = null;
		List<String> morphemesList = new ArrayList<String>();
		
		for(Sentence s : resultList){
			Eojeol[] eojeolArray = s.getEojeols();
			for(int i = 0; i < eojeolArray.length; i++){
				if(eojeolArray[i].length > 0){
					morphemes = eojeolArray[i].getMorphemes();
					 for (int j = 0; j < morphemes.length; j++) {
						 morphemesList.add(morphemes[j]);
					 }
				}
			}
		}
		
		Set<String> nounSet = new HashSet<String>();
		Map<String, Integer> nounCount = new HashMap<String, Integer>();
		
		for(String noun : morphemesList){
			if(noun.equals("p") || noun.equals("br")) continue;
			
			if(nounSet.contains(noun)) nounCount.put(noun, nounCount.get(noun) + 1);
			else nounCount.put(noun, 1);
			
			nounSet.add(noun);
		}
		
		List<Map<String, Object>> nounList = new ArrayList<Map<String, Object>>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		titleMap.put("noun", "noun");
		titleMap.put("frequency", "frequency");
		nounList.add(titleMap);
		
		for(String noun : nounSet){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("noun", noun);
			map.put("frequency", nounCount.get(noun));
			
			nounList.add(map);
		}
		
		workflow.close();
		
		this.reprtService.insertDy_reprt(reprtInfo, nounList);
		
		return "redirect:/empl/dy_reprt/dy_mnthngReprtList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("dy_weekReprtView")
	public ModelAndView dy_weekReprtView(@RequestParam String prjct_id, @RequestParam String reprt_id, ReprtVO reprtInfo,
			Map<String, String> params, ModelAndView andView, HttpSession session) throws Exception{
		String empl_id = (((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		params.put("empl_id", empl_id);
		EmplVO emplInfo = this.memberService.emplInfo(params);
		
		params.put("reprt_id", reprt_id);
		reprtInfo = this.reprtService.reprtView(params);
		reprtInfo.setReprt_date(reprtInfo.getReprt_date().substring(0, 10));
		reprtInfo.setReprt_start(reprtInfo.getReprt_start().substring(0, 10));
		reprtInfo.setReprt_clos(reprtInfo.getReprt_clos().substring(0, 10));
		ReprtFileVO reprtFileInfo = this.reprtFileService.fileItemInfo(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("emplInfo", emplInfo);
		andView.addObject("reprtInfo", reprtInfo);
		andView.addObject("reprtFileInfo", reprtFileInfo);
		andView.setViewName("empl/dy_reprt/dy_weekReprtView");
		
		return andView;
	}
	
	@RequestMapping("dy_mnthngReprtView")
	public ModelAndView dy_mnthngReprtView(@RequestParam String prjct_id, @RequestParam String reprt_id, ReprtVO reprtInfo,
			Map<String, String> params, ModelAndView andView, HttpSession session) throws Exception{
		String empl_id = (((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		params.put("empl_id", empl_id);
		EmplVO emplInfo = this.memberService.emplInfo(params);
		
		params.put("reprt_id", reprt_id);
		reprtInfo = this.reprtService.reprtView(params);
		reprtInfo.setReprt_date(reprtInfo.getReprt_date().substring(0, 10));
		reprtInfo.setReprt_start(reprtInfo.getReprt_start().substring(0, 10));
		reprtInfo.setReprt_clos(reprtInfo.getReprt_clos().substring(0, 10));
		ReprtFileVO reprtFileInfo = this.reprtFileService.fileItemInfo(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("emplInfo", emplInfo);
		andView.addObject("reprtInfo", reprtInfo);
		andView.addObject("reprtFileInfo", reprtFileInfo);
		andView.setViewName("empl/dy_reprt/dy_mnthngReprtView");
		
		return andView;
	}
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(ReprtFileVO reprtFileInfo, @RequestParam String reprt,
			ModelAndView andView, Map<String, String> params) throws Exception {
		params.put("reprt_id", reprt);
		reprtFileInfo = this.reprtFileService.fileItemInfo(params);
		String fileName = reprtFileInfo.getReprt_file_nm();
		String fileSaveName = reprtFileInfo.getReprt_file_save_nm();
		File downloadFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		
		andView.addObject("downloadFile", downloadFile);
		andView.addObject("fileName", fileName);
		andView.setViewName("downloadView");
		
		return andView;
	}
	
	@RequestMapping("fileExistence")
	public ModelAndView fileExistence(ModelAndView andView) throws Exception{
		andView.setViewName("jsonConvertView");
		return andView;
	}
	
	@RequestMapping("updateDy_weekReprt")
	public String updateDy_weekReprt(ReprtVO reprtInfo, @RequestParam String prjct_id,
			HttpSession session) throws Exception{
		reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n\r\n", "<br>"));
	    reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n", ""));
	    reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
	    String path = "D:\\temp\\fileDocBase";
	    
	    Workflow workflow = new Workflow(path);
		workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
		workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), "conf/plugin/SupplementPlugin/PlainTextProcessor/InformalSentenceFilter.json");
		workflow.appendPosProcessor(new NounExtractor(), "conf/plugin/SupplementPlugin/PosProcessor/NounExtractor.json");
		
		workflow.activateWorkflow(true);
		
		String document = reprtInfo.getReprt_cn();
		workflow.analyze(document);
		
		LinkedList<Sentence> resultList = workflow.getResultOfDocument(new Sentence(0, 0, false));
		String[] morphemes = null;
		List<String> morphemesList = new ArrayList<String>();
		
		for(Sentence s : resultList){
			Eojeol[] eojeolArray = s.getEojeols();
			for(int i = 0; i < eojeolArray.length; i++){
				if(eojeolArray[i].length > 0){
					morphemes = eojeolArray[i].getMorphemes();
					 for (int j = 0; j < morphemes.length; j++) {
						 morphemesList.add(morphemes[j]);
					 }
				}
			}
		}
		
		Set<String> nounSet = new HashSet<String>();
		Map<String, Integer> nounCount = new HashMap<String, Integer>();
		
		for(String noun : morphemesList){
			if(noun.equals("p") || noun.equals("br") || noun.equals("ul") || noun.equals("li")) continue;
			
			if(nounSet.contains(noun)) nounCount.put(noun, nounCount.get(noun) + 1);
			else nounCount.put(noun, 1);
			
			nounSet.add(noun);
		}
		
		List<Map<String, Object>> nounList = new ArrayList<Map<String, Object>>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		titleMap.put("noun", "noun");
		titleMap.put("frequency", "frequency");
		nounList.add(titleMap);
		
		for(String noun : nounSet){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("noun", noun);
			map.put("frequency", nounCount.get(noun));
			
			nounList.add(map);
		}
		
		workflow.close();
		
		this.reprtService.updateDy_reprt(reprtInfo, nounList);
		
		return "redirect:/empl/dy_reprt/dy_weekReprtList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("updateDy_mnthngReprt")
	public String updateDy_mnthngReprt(ReprtVO reprtInfo, @RequestParam String prjct_id,
			HttpSession session) throws Exception{
		reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n\r\n", "<br>"));
	    reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("\r\n", ""));
	    reprtInfo.setReprt_cn(reprtInfo.getReprt_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
	    String path = "D:\\temp\\fileDocBase";
	    
	    Workflow workflow = new Workflow(path);
		workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
		workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), "conf/plugin/SupplementPlugin/PlainTextProcessor/InformalSentenceFilter.json");
		workflow.appendPosProcessor(new NounExtractor(), "conf/plugin/SupplementPlugin/PosProcessor/NounExtractor.json");
		
		workflow.activateWorkflow(true);
		
		String document = reprtInfo.getReprt_cn();
		workflow.analyze(document);
		
		LinkedList<Sentence> resultList = workflow.getResultOfDocument(new Sentence(0, 0, false));
		String[] morphemes = null;
		List<String> morphemesList = new ArrayList<String>();
		
		for(Sentence s : resultList){
			Eojeol[] eojeolArray = s.getEojeols();
			for(int i = 0; i < eojeolArray.length; i++){
				if(eojeolArray[i].length > 0){
					morphemes = eojeolArray[i].getMorphemes();
					 for (int j = 0; j < morphemes.length; j++) {
						 morphemesList.add(morphemes[j]);
					 }
				}
			}
		}
		
		Set<String> nounSet = new HashSet<String>();
		Map<String, Integer> nounCount = new HashMap<String, Integer>();
		
		for(String noun : morphemesList){
			if(noun.equals("p") || noun.equals("br") || noun.equals("ul") || noun.equals("li")) continue;
			
			if(nounSet.contains(noun)) nounCount.put(noun, nounCount.get(noun) + 1);
			else nounCount.put(noun, 1);
			
			nounSet.add(noun);
		}
		
		List<Map<String, Object>> nounList = new ArrayList<Map<String, Object>>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		titleMap.put("noun", "noun");
		titleMap.put("frequency", "frequency");
		nounList.add(titleMap);
		
		for(String noun : nounSet){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("noun", noun);
			map.put("frequency", nounCount.get(noun));
			
			nounList.add(map);
		}
		
		workflow.close();
		
		this.reprtService.updateDy_reprt(reprtInfo, nounList);
		
		return "redirect:/empl/dy_reprt/dy_mnthngReprtList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("deleteWeekReprt")
	public String deleteWeekReprt(@RequestParam String prjct_id, @RequestParam String reprt_id,
			Map<String, String> params) throws Exception{
		params.put("reprt_id", reprt_id);
		this.reprtService.deleteReprt(params);
		
		return "redirect:/empl/dy_mtg/dy_weekReprtList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("deleteMnthngReprt")
	public String deleteMnthngReprt(@RequestParam String prjct_id, @RequestParam String reprt_id,
			Map<String, String> params) throws Exception{
		params.put("reprt_id", reprt_id);
		this.reprtService.deleteReprt(params);
		
		return "redirect:/empl/dy_mtg/dy_mnthngReprtList.do?prjct_id=" + prjct_id;
	}
}















