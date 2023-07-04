package com.sp.app.seller.adjustment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.common.MyUtil;
import com.sp.app.domain.seller.SellerAdjustment;
import com.sp.app.seller.SellerSessionInfo;


@Controller
public class AdjustmentController {

	@Autowired
	AdjustmentService adjustmentService;
	
	@Autowired
	private MyUtil myUtil;
	
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
	public String adminAdjustmentList(
	        @RequestParam(value = "pageNo", defaultValue = "1") int current_page,
	        HttpSession session,Model model) throws Exception {
	    int size = 5;
	    int total_page = 0;
	    int dataCount = 0;

	    dataCount = adjustmentService.adjustmentCount();
	    
	    total_page = myUtil.pageCount(dataCount, size);
	    if (current_page > total_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if(offset < 0) {offset = 0;}

	    
	    List<SellerAdjustment> sellerAdjustmentList = adjustmentService.getAllAdjustments(offset,size);

	    String paging = myUtil.pagingUrl(current_page, total_page, "list/listPage");
	            
	    model.addAttribute("adjustmentList", sellerAdjustmentList);
	    model.addAttribute("pageNo", current_page);
	    model.addAttribute("dataCount", dataCount);
	    model.addAttribute("size", size);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
	    return ".admin.adjustment.list";
	}

}
