package com.sp.app.member.management;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.member.Member;

//단순 조회 시 GET 
//수정 등록은 Post
@Controller
public class MemberManagementController {
	
	@Autowired
	MemberManagementService memberManagementService;
	
	@GetMapping("login")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String loginSubmit(HttpSession httpSession, @RequestParam String email, @RequestParam String password) {
		Member member = memberManagementService.login(email, password);
		
		
	
		
		

		
		return "redirect:/home";
		
	}
	
}
