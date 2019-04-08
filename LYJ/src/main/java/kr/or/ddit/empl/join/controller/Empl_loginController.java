package kr.or.ddit.empl.join.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.vo.EmplVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empl/join/")
public class Empl_loginController {
	
	@Autowired
	private IMemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("loginCheck")
	public String loginCheck(Map<String, String> params, String mem_id, String mem_pass,
			HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		params.put("empl_id", mem_id);
		
//		System.out.println(this.passwordEncoder.encode(mem_pass));
		
		EmplVO emplInfo = this.service.emplInfo(params);
		
		String returnValue = "";
		if(emplInfo == null || !this.passwordEncoder.matches(mem_pass, emplInfo.getEmpl_pass())){
			String message = "로그인 실패";
			try {
				message = URLEncoder.encode(message, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			returnValue = "redirect:/login.do?message=" + message;
		}else {
			if(emplInfo.getEmpl_bir() != null) emplInfo.setEmpl_bir(emplInfo.getEmpl_bir().substring(0, 10));
			if(emplInfo.getEmpl_ecny() != null) emplInfo.setEmpl_ecny(emplInfo.getEmpl_ecny().substring(0, 10));
			session.setAttribute("LOGIN_EMPLINFO", emplInfo);
			returnValue = "forward:/empl/main.do";
		}
		
		return returnValue;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login.do";
	}
	
	@RequestMapping("findPass")
	public String findPass(Map<String, String> params, String empl_nm, String empl_id, String empl_mail) throws Exception{
		params.put("empl_id", empl_id);
		params.put("empl_nm", empl_nm);
		
		EmplVO emplInfo = this.service.emplInfo(params);
		
		String returnValue = "";
		if(emplInfo == null){
			String message = "계정 없음";
			try {
				message = URLEncoder.encode(message, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			returnValue = "redirect:/login.do?message=" + message;
		} else {
			String tempPass = makeTempPass(6);
			String message = "해당 이메일로 임시비밀번호가 발급되었습니다.";
			try {
				message = URLEncoder.encode(message, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String empl_pass = this.passwordEncoder.encode(tempPass);
			emplInfo.setEmpl_pass(empl_pass);
			if(emplInfo.getEmpl_bir() != null) emplInfo.setEmpl_bir(emplInfo.getEmpl_bir().substring(0, 10));
			if(emplInfo.getEmpl_ecny() != null) emplInfo.setEmpl_ecny(emplInfo.getEmpl_ecny().substring(0, 10));
			this.service.updateEmplInfo(emplInfo);
			
			try {
				MimeMessage mimeMsg = mailSender.createMimeMessage();
				MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
				
				msgHelper.setFrom("remindPMS@gmail.com");
				msgHelper.setTo(empl_mail);
				msgHelper.setSubject("remind(PMS)의 임시비밀번호가 발급되었습니다.");
				msgHelper.setText("<html><body><img src='cid:remind'><br/>"
						+ "<h1>회원님의 임시 비밀번호는 <mark>" + tempPass + "</mark> 입니다.</h1></body></html>", true);
				
				FileSystemResource res = new FileSystemResource(new File("D:\\temp\\fileDocBase\\remind.jpg"));
				msgHelper.addInline("remind", res);
				
				mailSender.send(mimeMsg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			returnValue = "redirect:/login.do?message=" + message;
		}
		return returnValue;
	}
	
	public static String makeTempPass(int size){
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		
		String[] randomChars = 
				"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
		
		for(int i = 0; i < size; i++){
			buffer.append(randomChars[random.nextInt(randomChars.length)]);
		}
		
		return buffer.toString();
	}
	
}
