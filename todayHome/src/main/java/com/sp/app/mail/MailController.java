package com.sp.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.domain.mail.Mail;

@Controller
@RequestMapping("mail")
public class MailController {
	@Autowired
	private MailServiceImpl mailSender;
	

	@PostMapping("send")
	@ResponseBody
	public boolean sendSubmit(@RequestParam String email) throws Exception {
		
		Mail mail = new Mail();      
		mail.setReceiverEmail(email);
		mail.setContent("인증번호입니다.");
		mail.setSubject("인증메일");
		mail.setSenderEmail("gogogo960922@gmail.com");
		mail.setSenderName("오늘의집");
		

		return mailSender.mailSend(mail);
	}
	
	@GetMapping("complete")
	public String complete(@ModelAttribute("message") String message) throws Exception{
		
		// 컴플릿 페이지(complete.jsp)의 출력되는 message와 title는 RedirectAttributes 값이다. 
		// F5를 눌러 새로 고침을 하면 null이 된다.
		
		if(message==null || message.length()==0) // F5를 누른 경우
			return "redirect:/";
		
		return ".mail.complete";
	}
}
