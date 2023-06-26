package com.sp.app.member.management;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.common.SessionInfo;
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
		if (member == null) {
			return "redirect:/login";
		}

		Long memberId = member.getMemberId();
		String nickname = member.getNickName();
		Integer role = member.getMemberRoleId();

		SessionInfo sessionInfo = new SessionInfo(memberId, nickname, role);

		httpSession.setAttribute("sessionInfo", sessionInfo);

		return "redirect:/home";
	}

	@PostMapping("logout")
	public String logoutSubmit(HttpSession session) {

		session.invalidate();

		return "redirect:/";

	}
	
	@GetMapping("join")
	public String joinForm(Model model) {
				
		model.addAttribute("msg","");
		
		return "member/join-member";
	}
	

	@PostMapping("join")
	public String joinSubmit( 
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String nickName
			,Model model) {

		Member member = new Member(email,nickName,password);
		
		
		try {
			memberManagementService.insertMemberAll(member);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		

		return "redirect:/home";
	}
	
}
