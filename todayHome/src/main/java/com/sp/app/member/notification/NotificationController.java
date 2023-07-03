package com.sp.app.member.notification;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.NotificationParse;


@Controller
public class NotificationController {
	@Autowired
	NotificationService notificationService;
	

	@GetMapping("notification")
	public String notificationForm(Model model, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");

		if (sessionInfo == null) {
			return "redirect:/login";
		}

		Long memberId = sessionInfo.getMemberId();
		List<NotificationParse> list = null;

		try {
			list = notificationService.getNotReadNotificationList(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);

		return "mypage/my-alert";		
	}
	
	
	@PostMapping("notification")
	public String notificationSubmit(@RequestParam List<NotificationParse> list) {
		try {
			list = notificationService.getNotReadNotificationList(null);
			
			if(list ==  null) {
				return "redirect:/mypage/my-alert";
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/mypage/my-alert";
	}
	
	
	
	
}