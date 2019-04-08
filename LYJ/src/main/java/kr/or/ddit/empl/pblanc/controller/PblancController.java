package kr.or.ddit.empl.pblanc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.pblanc.service.IpblancService;
import kr.or.ddit.utils.RolePagingUtil;
import kr.or.ddit.vo.PblancVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/empl/pblanc/")
public class PblancController {
	
	@Resource
	private IpblancService service;
	
	
	@RequestMapping("pblancList")
	public ModelAndView pblancList(String currentPage,
			String search_keyword, String search_keycode, String paging,
			String search, HttpServletRequest request, HttpSession session,
			ModelAndView andView, Map<String, String> params)throws Exception{
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
		
		List<PblancVO> pblancList =this.service.pblancList(params);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		andView.addObject("currentPage", currentPage);

		andView.addObject("paging", pagingUtil.getPageHtmls());
		
		andView.addObject("pblancList",pblancList);
		andView.setViewName("empl/pblanc/pblancList");
		
		
		
		return andView;
	}

 
}
