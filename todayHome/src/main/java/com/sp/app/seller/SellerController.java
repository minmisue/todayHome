package com.sp.app.seller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.sp.app.domain.order.Order;
import com.sp.app.domain.seller.Seller;
import com.sp.app.domain.seller.SellerAdjustment;
import com.sp.app.order.OrderManagementService;

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
	public String deliveryManage(HttpSession httpSession) {
	    SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    
	    if (sellerSessionInfo != null && sellerSessionInfo.getStatus() == 0) {
	        
	        return "redirect:/seller/error";
	    }
		return ".seller.deliveryManage.deliverymanage";
	}
	
	@GetMapping("seller/orderManage")
	public String orderManage(HttpSession httpSession) {
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    
	    if (sellerSessionInfo != null && sellerSessionInfo.getStatus() == 0) {
	        
	        return "redirect:/seller/error";
	    }
		return ".seller.deliveryManage.ordermanage";
	}
	
	@GetMapping("seller/refund")
	public String refundManage(HttpSession httpSession) {
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    
	    if (sellerSessionInfo != null && sellerSessionInfo.getStatus() == 0) {
	        
	        return "redirect:/seller/error";
	    }
		return ".seller.refund.refund";
	}
	
	@RequestMapping(value = "/admin/members/sellerDetail/{sellerId}", method = RequestMethod.GET)
	public String sellerDetailList(@PathVariable("sellerId") long sellerId, Model model) {
		try {
	        Seller seller = sellerService.getSellerBySellerId(sellerId);
	        
	        model.addAttribute("seller", seller);


	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return "admin/members/sellerDetailList";

	}
	@RequestMapping(value = "/admin/members/sellerDetail/{sellerId}", method = RequestMethod.POST)
	public String sellerStatusUpdate(@PathVariable("sellerId") long sellerId, Model model,Seller seller){
	    try {
	        
	        sellerService.updateSellerStatus(seller);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:/admin/members/sellerList";
	}
	@GetMapping("seller/error")
	public String errorPage() {
		return ".seller.error.error";
	}
	/*
	@RequestMapping("seller/orderMange")
	public String orderList(
	        Order order,
	        HttpServletRequest req,
	        @RequestParam(value = "startDate", defaultValue="") String startDate,
	        @RequestParam(value = "endDate", defaultValue = "") String endDate,	       
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        @RequestParam(value = "condition", defaultValue = "") String condition,
			@RequestParam(value ="keyword", defaultValue = "") String keyword,	        
	        HttpSession httpSession,
	        Model model) throws Exception {
	    SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    Long sellerId = sellerSessionInfo.getSellerId();
	    
	    if (sellerSessionInfo != null && sellerSessionInfo.getStatus() == 0) {
	        
	        return "redirect:/seller/error";
	    }
	    int size = 5;
	    int total_page = 0;
	    int dataCount = 0;
	    
	    dataCount = OrderManagementService.order(sellerId,startDate,endDate);
	    if (dataCount != 0) {
	        total_page = myUtil.pageCount(dataCount, size);
	    }

	    if (total_page < current_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if (offset < 0) offset = 0;

	    List<SellerAdjustment> sellerAdjustmentList = adjustmentService.getAdjustmentsBySellerId(sellerId, offset, size,startDate,endDate);
	    
	    int totalAmount = 0;
	    for (SellerAdjustment sellerAdjustment : sellerAdjustmentList) {
	        totalAmount += sellerAdjustment.getAmount();
	    }	    
	    
	    String cp = req.getContextPath();
	    String query = "";
	    String listUrl = cp + "/seller/adjustment/list";
	    
	    if (startDate != null && endDate != null) {
		    query += "&startDate=" + URLEncoder.encode(startDate, "UTF-8") + "&endDate=" + URLEncoder.encode(endDate, "UTF-8");
		}
	    
	    listUrl += "?" + query;
	    
	    String paging = myUtil.paging(current_page, total_page, listUrl);

	    model.addAttribute("sellerAdjustmentList", sellerAdjustmentList);
	    model.addAttribute("page", current_page);
	    model.addAttribute("adjustmentCount", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("totalAmount", totalAmount);
		
	    return ".seller.adjustment.list";
	}
	*/
}
