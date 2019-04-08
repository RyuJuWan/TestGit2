package kr.or.ddit.admin.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.vo.AdminVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/join/")
public class Admin_loginController {
	
	@Autowired
	private IMemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("loginCheck")
	public String loginCheck(Map<String, String> params, String mem_id, String mem_pass, 
			HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		params.put("admin_id", mem_id);
		
		AdminVO adminInfo = this.service.adminInfo(params);
		
		String returnValue = "";
		if(adminInfo == null || !this.passwordEncoder.matches(mem_pass, adminInfo.getAdmin_pass())){
			String message = "로그인 실패";
			try {
				message = URLEncoder.encode(message, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			returnValue = "redirect:/login.do?message=" + message;
		} else {
			session.setAttribute("LOGIN_ADMININFO", adminInfo);
			returnValue = "forward:/admin/main.do";
		}
		
		return returnValue;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login.do";
	}
}
