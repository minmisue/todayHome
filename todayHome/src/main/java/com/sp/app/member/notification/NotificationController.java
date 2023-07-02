package com.sp.app.member.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NotificationController {
	@Autowired
	NotificationRepository notificationRepository;
	

	@GetMapping("notification")
	public String notificationForm() {
		
		return "mypage/my-alert";

		
	}
	
	
	
	
}