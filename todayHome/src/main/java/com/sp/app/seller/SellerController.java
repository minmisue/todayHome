package com.sp.app.seller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String sellerSignUpSubmit(
			HttpSession httpSession,
			@RequestParam String representativeName,
			@RequestParam String businessNumber,
			@RequestParam String brandName,
			@RequestParam String sellerName,
			@RequestParam String tel,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String presentation			
			,Model model) {
		
		SessionInfo sessionInfo = (SessionInfo) httpSession.getAttribute("sessionInfo");
		Long memberId = sessionInfo.getMemberId();
		
		Seller seller = new Seller(memberId,representativeName,businessNumber,brandName,sellerName,tel,email,password,presentation);
		System.out.println(seller);
		
		try {
			sellerService.createSeller(seller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		String sellerName= seller.getSellerName();
		
		SellerSessionInfo sellerSessionInfo = new SellerSessionInfo(sellerId,status,sellerName);
		
		httpSession.setAttribute("sellerSessionInfo", sellerSessionInfo);
		
		return "redirect:/seller";
	}
	
	@GetMapping("seller/complete")
	public String sellerSubmitComplete() {
		return "seller/join/complete";
	}
	
	@PostMapping("seller/logout")
	public String logoutSubmit(HttpSession httpSession) {
	
	 httpSession.removeAttribute("sessionInfo");
	 httpSession.removeAttribute("sellerSessionInfo");
	 
	 httpSession.invalidate();
	 
	 
	 return "redirect:/seller/login";   
	 
	}
	
	@GetMapping("seller/update")
	public String sellerUpdate(Model model,HttpSession httpSession) throws Exception {
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
		Long sellerId = sellerSessionInfo.getSellerId();
		Seller seller = sellerService.getSellerBySellerId(sellerId);
		
		model.addAttribute("seller", seller);
		return ".seller.join.seller-update";		
	}
	
	@PostMapping("seller/update")
	public String sellerUpdateOk(Seller seller,HttpSession httpSession) throws Exception{
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
		Long sellerId = sellerSessionInfo.getSellerId();
		seller.setSellerId(sellerId);
		try {
			// 수정 하기
			sellerService.updateSeller(seller);
		} catch (Exception e) {
		}
		
		return "redirect:/seller";
	}
	
	@GetMapping("seller/businessNumber-check")
	@ResponseBody
	public boolean businessNumberCheck(@RequestParam("businessNumber") String businessNumber) {
		
		try {
			return sellerService.businessNumberCheck(businessNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@GetMapping("seller/status")
	public String statusCheck(Model model, HttpSession httpSession) throws Exception{
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
		Long sellerId = sellerSessionInfo.getSellerId();
		Seller seller = sellerService.getSellerStatus(sellerId);
		
		model.addAttribute("seller", seller);
	return "seller/status/status-check";
	}
	
	@GetMapping("seller/deliveryManage")
	public String deliveryManage() {
		
		return ".seller.deliveryManage.deliverymanage";
	}
	
	@GetMapping("seller/orderManage")
	public String orderManage() {
		
		return ".seller.deliveryManage.ordermanage";
	}
	
	@GetMapping("seller/refund")
	public String refundManage() {
		
		return ".seller.refund.refund";
	}
	
	@RequestMapping(value = "/admin/members/sellerDetail/{sellerId}", method = RequestMethod.GET)
	public String sellerDetailList(@PathVariable("sellerId") int sellerId, Model model) {


	  return "admin/members/sellerDetailList";
	}
}
