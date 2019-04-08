package kr.or.ddit.empl.dy_schdul.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dy_flaw.service.IDy_flawService;
import kr.or.ddit.dy_issue.service.IDy_issueService;
import kr.or.ddit.dynm.dyWbs.service.IDyWbsService;
import kr.or.ddit.vo.AllListVO;
import kr.or.ddit.vo.FlawVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.WBSVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/dy_schdul/")
public class Dy_schdulController {
	
	@Autowired
	private IDyWbsService service;
	
	@Autowired
	private IDy_issueService iservice;
	
	@Autowired
	private IDy_flawService fservice;
	
	@RequestMapping("dy_schdulView")
	public ModelAndView dy_shcdulView(@RequestParam String prjct_id, @RequestParam String LoginId, ModelAndView andView, Map<String, String> params)throws Exception{
		andView.addObject("prjct_id", prjct_id);
		andView.addObject("LoginId", LoginId);
		return andView;
	}
	
	@ResponseBody
	@RequestMapping("date")
	public List<AllListVO> dy_date(@RequestParam String prjct_id, @RequestParam String LoginId, Map<String, String> params) throws Exception{
		params.put("wbs_prjct", prjct_id);
		params.put("wbs_chrg", LoginId);
		params.put("issue_prjct", prjct_id);
		params.put("issue_chrg", LoginId);
		params.put("flaw_prjct", prjct_id);
		params.put("flaw_chrg", LoginId);
		
		List<WBSVO> wbsList = service.wbsListByPrjctID(params);
		List<IssueVO> issueList = iservice.selectListSchdul(params);
		List<FlawVO> flawList = fservice.selectListSechdul(params);
		List<AllListVO> allList = new ArrayList<AllListVO>();
		
		if(wbsList.size() != 0){
			for(int i = 0; i < wbsList.size(); i++){
				AllListVO allListInfo = new AllListVO();
				allListInfo.setWbs_compt(wbsList.get(i).getWbs_compt());
				allListInfo.setWbs_nm(wbsList.get(i).getWbs_work_nm());
				allListInfo.setWbs_strt(wbsList.get(i).getWbs_strt());
				allList.add(allListInfo);
			}
		}
		
		if(issueList.size() != 0){
			for(int i = 0; i < issueList.size(); i++){
				AllListVO allListInfo = new AllListVO();
				allListInfo.setIssue_compt(issueList.get(i).getIssue_compt());
				allListInfo.setIssue_nm(issueList.get(i).getIssue_nm());
				allListInfo.setIssue_regist_day(issueList.get(i).getIssue_regist_day());
				allList.add(allListInfo);
			}
		}
		
		if(flawList.size() != 0){
			for(int i = 0; i < flawList.size(); i++){
				AllListVO allListInfo = new AllListVO();
				allListInfo.setFlaw_compt(flawList.get(i).getFlaw_compt());
				allListInfo.setFlaw_nm(flawList.get(i).getFlaw_nm());
				allListInfo.setFlaw_regist_day(flawList.get(i).getFlaw_regist_day());
				allList.add(allListInfo);
			}
		}
		
		return allList;
	}
	
}
