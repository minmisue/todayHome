package com.sp.app.seller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.seller.Seller;

@Controller
public class SellerController {

	
	@Autowired
	SellerService sellerService;
	
	@GetMapping("seller/join")
	public String sellerSignUp() {
		return "seller/join/seller-join";
		
	}
	
	@PostMapping("seller/join")
	public String sellerSignUpSubmit() {
		
		return "redirect:/seller/complete";
	}
	
	@GetMapping("seller/login")
	public String sellerLogin() {
		return "seller/join/seller-login";
	}
	
	@PostMapping("seller/login")
	public String SellerLoginOk(HttpSession httpSession, @RequestParam String email, @RequestParam String password) {
		Seller seller = sellerService.login(email, password);
		if(seller == null) {
			return "redirect:/seller/login";
		}
		
		Long sellerId = seller.getSellerId();
		int status = seller.getStatus();
		
		SessionInfo sessionInfo = new SessionInfo(sellerId,status);
		
		httpSession.setAttribute("sessionInfo", sessionInfo);
		
		return "redirect:/home";
	}
	
	@GetMapping("seller/complete")
	public String sellerSubmitComplete() {
		return "seller/join/complete";
	}
}
