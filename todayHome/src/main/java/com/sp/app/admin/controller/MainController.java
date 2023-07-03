package com.sp.app.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.app.domain.common.SessionInfo;

@Controller("admin.mainController")
public class MainController {
	 
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String method(HttpSession httpSession, Model model) {
		 SessionInfo sessionInfo = (SessionInfo) httpSession.getAttribute("sessionInfo");
		    if (sessionInfo == null) {
		        return "redirect:/member/login";
		    }
		return ".adminLayout";
	}
}
