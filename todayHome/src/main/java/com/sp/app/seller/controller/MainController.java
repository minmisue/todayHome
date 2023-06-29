
package com.sp.app.seller.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.app.seller.SellerSessionInfo;

@Controller("seller.mainController")
public class MainController {
	 
	@RequestMapping(value="/seller", method=RequestMethod.GET)
	public String method(HttpSession httpSession, Model model) {
		 SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
		    if (sellerSessionInfo == null) {
		        return "redirect:/seller/login";
		    }
		return ".sellerLayout"; 
	}
}
