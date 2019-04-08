package kr.or.ddit.empl.prjct_hist.controller;

import kr.or.ddit.prjct_hist.service.IPrjctHistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/prjctHist/")
public class PrjctHistController {
	
	@Autowired
	private IPrjctHistService service;
	
}
