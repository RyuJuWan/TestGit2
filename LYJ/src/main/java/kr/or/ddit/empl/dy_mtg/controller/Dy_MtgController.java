package kr.or.ddit.empl.dy_mtg.controller;

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
import kr.or.ddit.dy_mtg.service.IDy_mtgService;
import kr.or.ddit.file.service.IDy_mtgFileService;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.sanctn_line.service.ISanctnlineService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.EmplVO;
import kr.or.ddit.vo.MtgFileVO;
import kr.or.ddit.vo.MtgVO;
import kr.or.ddit.vo.SanctnLineVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_mtg/")
public class Dy_MtgController {
	
	@Autowired
	private IDy_mtgService mtgService;
	
	@Autowired
	private ISanctnlineService sanctnlineService;
	
	@Autowired
	private IDy_mtgFileService mtgFileService;
	
	@Autowired
	private IMemberService memberService;
	
	private int blockCount = 10;
	private int blockPage = 5;
	
	@RequestMapping("dy_mtgList")
	public ModelAndView dy_mtgList(ModelAndView andView, HttpSession session, HttpServletRequest request,
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
		int totalCount = this.mtgService.totalCount(params);
		RolePagingUtil pagingUtil = new RolePagingUtil(totalCount, Integer.parseInt(currentPage), request, this.blockCount, this.blockPage);
		
		String startCount = String.valueOf(pagingUtil.getStartCount());
		String endCount = String.valueOf(pagingUtil.getEndCount());
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		List<MtgVO> mtgPageList = this.mtgService.mtgPageList(params);
		for(MtgVO mtgInfo : mtgPageList){
			if(mtgInfo.getMtg_dt() != null) mtgInfo.setMtg_dt(mtgInfo.getMtg_dt().substring(0, 10));
			if(mtgInfo.getMtg_date() != null) mtgInfo.setMtg_date(mtgInfo.getMtg_date().substring(0, 10));
		}
		
		andView.addObject("mtgPageList", mtgPageList);
		andView.addObject("pagingUtil", pagingUtil.getPageHtmls());
		andView.setViewName("empl/dy_mtg/dy_mtgList");
		return andView;
	}
	
	@RequestMapping("dy_mtgForm")
	public ModelAndView dy_mtgForm(ModelAndView andView, Map<String, String> params,
			@RequestParam String prjct_id) throws Exception{
		
		List<SanctnLineVO> sanctnLineList = this.sanctnlineService.sanctnlineList(params);
		
		andView.addObject("sanctnLineList", sanctnLineList);
		andView.addObject("prjct_id", prjct_id);
		andView.setViewName("empl/dy_mtg/dy_mtgForm");
		
		return andView;
	}
	
	@RequestMapping("insertDy_mtg")
	public String insertDy_mtg(MtgVO mtgInfo, HttpSession session, 
			@RequestParam String prjct_id) throws Exception{
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String today = sf.format(now);
		
		mtgInfo.setMtg_prjct(prjct_id);
		mtgInfo.setMtg_empl(((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id());
		mtgInfo.setMtg_date(today);
		if(mtgInfo.getMtg_dt() != null) mtgInfo.setMtg_dt(mtgInfo.getMtg_dt().substring(0, 10));
		
		mtgInfo.setMtg_cn(mtgInfo.getMtg_cn().replaceAll("\r\n\r\n", "<br>"));
	    mtgInfo.setMtg_cn(mtgInfo.getMtg_cn().replaceAll("\r\n", ""));
	    mtgInfo.setMtg_cn(mtgInfo.getMtg_cn().replaceAll("<p>&nbsp;</p>", ""));
		
//		String path = session.getServletContext().getRealPath("");
	    String path = "D:\\temp\\fileDocBase";
	    
		Workflow workflow = new Workflow(path);
		workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
		workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), "conf/plugin/SupplementPlugin/PlainTextProcessor/InformalSentenceFilter.json");
		workflow.appendPosProcessor(new NounExtractor(), "conf/plugin/SupplementPlugin/PosProcessor/NounExtractor.json");
		
		workflow.activateWorkflow(true);
		
		String document = mtgInfo.getMtg_cn();
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
		
		this.mtgService.insertDy_mtg(mtgInfo, nounList);
		
		return "redirect:/empl/dy_mtg/dy_mtgList.do?prjct_id=" + prjct_id;
	}
	
	@RequestMapping("dy_mtgView")
	public ModelAndView dy_mtgView(@RequestParam String prjct_id, @RequestParam String mtg_id, MtgVO mtgInfo,
			Map<String, String> params, ModelAndView andView, HttpSession session) throws Exception{
		String empl_id = ((EmplVO)session.getAttribute("LOGIN_EMPLINFO")).getEmpl_id();
		params.put("empl_id", empl_id);
		EmplVO emplInfo = this.memberService.emplInfo(params);
		
		params.put("mtg_id", mtg_id);
		mtgInfo = this.mtgService.mtgView(params);
		mtgInfo.setMtg_dt(mtgInfo.getMtg_dt().substring(0, 10));
		mtgInfo.setMtg_date(mtgInfo.getMtg_date().substring(0, 10));
		MtgFileVO mtgFileInfo = this.mtgFileService.fileItemInfo(params);
		
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("emplInfo", emplInfo);
		andView.addObject("mtgInfo", mtgInfo);
		andView.addObject("mtgFileInfo", mtgFileInfo);
		andView.setViewName("empl/dy_mtg/dy_mtgView");
		
		return andView;
	}
	
	@RequestMapping("fileDownload")
	public ModelAndView fileDownload(MtgFileVO mtgFileInfo, @RequestParam String mtg, 
			ModelAndView andView, Map<String, String> params) throws Exception{
		params.put("mtg_id", mtg);
		mtgFileInfo = this.mtgFileService.fileItemInfo(params);
		String fileName = mtgFileInfo.getMtg_file_nm();
		String fileSaveName = mtgFileInfo.getMtg_file_save_nm();
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
	
	@RequestMapping("updateDy_mtg")
	public String updateDy_mtg(MtgVO mtgInfo, @RequestParam String prjct_id,
			HttpSession session) throws Exception{
		mtgInfo.setMtg_cn(mtgInfo.getMtg_cn().replaceAll("\r\n\r\n", "<br>"));
	    mtgInfo.setMtg_cn(mtgInfo.getMtg_cn().replaceAll("\r\n", ""));
	    mtgInfo.setMtg_cn(mtgInfo.getMtg_cn().replaceAll("<p>&nbsp;</p>", ""));
	    
//	    String path = session.getServletContext().getRealPath("");
	    String path = "D:\\temp\\fileDocBase";
	    
	    Workflow workflow = new Workflow(path);
		workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
		workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), "conf/plugin/SupplementPlugin/PlainTextProcessor/InformalSentenceFilter.json");
		workflow.appendPosProcessor(new NounExtractor(), "conf/plugin/SupplementPlugin/PosProcessor/NounExtractor.json");
		
		workflow.activateWorkflow(true);
		
		String document = mtgInfo.getMtg_cn();
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
		
		this.mtgService.updateDy_mtg(mtgInfo, nounList);
		
		return "redirect:/empl/dy_mtg/dy_mtgList.do?prjct_id=" + prjct_id;
		
	}
	
	@RequestMapping("deleteMtg")
	public String deleteMtg(@RequestParam String prjct_id, @RequestParam String mtg_id,
			Map<String, String> params) throws Exception{
		params.put("mtg_id", mtg_id);
		this.mtgService.deleteMtg(params);
		
		return "redirect:/empl/dy_mtg/dy_mtgList.do?prjct_id=" + prjct_id;
	}
}















