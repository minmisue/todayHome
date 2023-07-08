package com.sp.app.seller.adjustment;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.common.MyUtil;
import com.sp.app.domain.seller.Seller;
import com.sp.app.domain.seller.SellerAdjustment;
import com.sp.app.seller.SellerService;
import com.sp.app.seller.SellerSessionInfo;


@Controller
public class AdjustmentController {

	@Autowired
	SellerService sellerService;
	@Autowired
	AdjustmentService adjustmentService;
	
	@Autowired
	private MyUtil myUtil;
	
	@RequestMapping("seller/adjustment/list")
	public String adjustmentList(
	        Seller seller,
	        HttpServletRequest req,
	        @RequestParam(value = "startDate", defaultValue="") String startDate,
	        @RequestParam(value = "endDate", defaultValue = "") String endDate,	       
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        HttpSession httpSession,
	        Model model) throws Exception {
	    SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    Long sellerId = sellerSessionInfo.getSellerId();

	    int size = 10;
	    int total_page = 0;
	    int dataCount = 0;
	    
	    dataCount = adjustmentService.adjustmentCountBysellerId(sellerId,startDate,endDate);
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
	
	@RequestMapping("admin/adjustment/list")
	public String adminAdjustmentList(
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        @RequestParam(value = "startDate", defaultValue="") String startDate,
	        @RequestParam(value = "endDate", defaultValue = "") String endDate,
	        @RequestParam(value = "condition", defaultValue = "") String condition,
			@RequestParam(value ="keyword", defaultValue = "") String keyword,
	        HttpServletRequest req,Model model) throws Exception {
	    int size = 5;
	    int total_page = 0;
	    int dataCount = 0;
	    
	    if (req.getMethod().equalsIgnoreCase("GET")) { 
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
	    
	    dataCount = adjustmentService.adjustmentCount(startDate,endDate,keyword,condition);
		if (dataCount != 0) {
			total_page = myUtil.pageCount(dataCount, size);
		}
		
		if (total_page < current_page) {
			current_page = total_page;
		}

		int offset = (current_page - 1) * size;
		if(offset < 0) offset = 0;


    
	    List<SellerAdjustment> adminAdjustmentList = adjustmentService.getAllAdjustments(offset,size,startDate,endDate,keyword,condition);
	    String cp = req.getContextPath();
		String query = "";
		String listUrl = cp + "/admin/adjustment/list";
		
		if (startDate != null && endDate != null) {
		    query += "&startDate=" + URLEncoder.encode(startDate, "UTF-8") + "&endDate=" + URLEncoder.encode(endDate, "UTF-8");
		}
		
		if (startDate != null && endDate != null && keyword.length() != 0) {
		    query += "&startDate=" + URLEncoder.encode(startDate, "UTF-8") + "&endDate=" + URLEncoder.encode(endDate, "UTF-8") + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		} 
			
		if (keyword.length() != 0) {
		    query += "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}
		
		listUrl += "?" + query;
	    
	    String paging = myUtil.paging(current_page, total_page, listUrl);
	    
	    model.addAttribute("adminAdjustmentList", adminAdjustmentList);
	    model.addAttribute("page", current_page);
	    model.addAttribute("adjustmentCount", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
	    return ".admin.adjustment.list";
	}
	
	@RequestMapping("admin/members/sellerList")
	public String sellerList(
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        @RequestParam(value= "list", defaultValue="") List<String> list,
	        @RequestParam(value = "condition", defaultValue = "") String condition,
			@RequestParam(value ="keyword", defaultValue = "") String keyword,
			@RequestParam(value ="orderBy", defaultValue = "") String orderBy,
			HttpServletRequest req,Model model) throws Exception {
	    int size = 5;
	    int total_page = 0;
	    int dataCount = 0;
	    if (req.getMethod().equalsIgnoreCase("GET")) { 
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
	    
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("condition", condition);
		map.put("keyword", keyword);	
		map.put("orderBy", orderBy);	

	
	    dataCount = sellerService.getSellerCount(map);
		if (dataCount != 0) {
			total_page = myUtil.pageCount(dataCount, size);
		}
		
		if (total_page < current_page) {
			current_page = total_page;
		}

		int offset = (current_page - 1) * size;
		if(offset < 0) offset = 0;
		
		map.put("offset", offset);
		map.put("size", size);
   
	    List<Seller> adminSellerList = sellerService.getSellersByCondition(map);
	    String cp = req.getContextPath();
		String query = "";
		String listUrl = cp + "/admin/members/sellerList";
		
			
		if (keyword.length() != 0) {
		    query += "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}
		if (!list.isEmpty()) {
		    String listString = String.join(",", list); 
		    query += "&list=" + URLEncoder.encode(listString, "UTF-8");
		}

		if (orderBy.length() != 0) {
		    query += "&orderByAmount=" + URLEncoder.encode(orderBy, "UTF-8");
		}

		
		listUrl += "?" + query;
	    
	    String paging = myUtil.paging(current_page, total_page, listUrl);
	    
	    model.addAttribute("adminSellerList", adminSellerList);
	    model.addAttribute("page", current_page);
	    model.addAttribute("adjustmentCount", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
		model.addAttribute("list", list);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
	    return ".admin.members.sellerList";
	}
	@GetMapping("seller/adjustment/money")
	public String adjustment(HttpSession httpSession,
			Model model) throws Exception{
		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
		Long sellerId = sellerSessionInfo.getSellerId();
		Seller seller = sellerService.getSellerBySellerId(sellerId);
		
		
			
		model.addAttribute("seller", seller);
		
		return ".seller.adjustment.money";
		
	}
	@PostMapping("seller/adjustment/money")
	public String adjustmentSubmit(
	        @RequestParam(value = "inputAmount") long inputAmount,
	        SellerAdjustment sellerAdjustment, Seller seller, HttpSession httpSession,
	        Model model) throws Exception {
	    SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    Long sellerId = sellerSessionInfo.getSellerId();

	    try {
	        Seller loggedSeller = sellerService.getSellerBySellerId(sellerId);
	        long currentAmount = loggedSeller.getAccumulatedAmount();

	        long newAmount = currentAmount - inputAmount;

	        seller.setSellerId(sellerId);
	        seller.setAccumulatedAmount(newAmount);
	        sellerService.updateAccumulatedAmount(seller);

	        sellerAdjustment.setSellerId(sellerId);
	        sellerAdjustment.setAmount(inputAmount);
	        adjustmentService.createAdjustment(sellerAdjustment);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }

	    return "redirect:/seller/adjustment/money";
	}


}
