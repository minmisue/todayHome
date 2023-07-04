package com.sp.app.seller.adjustment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sp.app.domain.seller.SellerAdjustment;
import com.sp.app.seller.SellerSessionInfo;


@Controller
public class AdjustmentController {

	@Autowired
	AdjustmentService adjustmentService;
	
	@GetMapping("seller/adjustment/list")
	public String adjustmentList(HttpSession httpSession,
			Model model) throws Exception{
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
		Long sellerId = sellerSessionInfo.getSellerId();
		List<SellerAdjustment> sellerAdjustmentList = adjustmentService.getAdjustmentsBySellerId(sellerId);
		
		
			
		model.addAttribute("sellerAdjustmentList", sellerAdjustmentList);
		
		return ".seller.adjustment.list";
		
	}
	@GetMapping("admin/adjustment/list")
	public String adminAdjustmentList(Model model) throws Exception {
	    List<SellerAdjustment> adminAdjustmentList = adjustmentService.getAllAdjustments();
	    
	    model.addAttribute("adjustmentList", adminAdjustmentList);
	    
	    return ".admin.adjustment.list";
	}
}
