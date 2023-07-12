package com.sp.app.admin.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.common.MyUtil;
import com.sp.app.domain.product.ProductForList;
import com.sp.app.domain.seller.Seller;
import com.sp.app.order.OrderManagementService;
import com.sp.app.product.management.ProductManagementService;
import com.sp.app.product.review.ProductReviewService;
import com.sp.app.seller.SellerService;

@Controller
public class AdminProductController {

	@Autowired
	ProductManagementService productManagementService;
	
	@Autowired
	ProductReviewService productReviewService;
	
	@Autowired
	SellerService sellerService;

	@Autowired
	private MyUtil myUtil;
	
	@Autowired
	OrderManagementService orderManagementService;
	
	@RequestMapping("admin/product/productList")
	public String productList(
			ProductForList productForList,
			Seller seller,
	        HttpServletRequest req,
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        @RequestParam(value = "startDate", defaultValue="") String startDate,
	        @RequestParam(value = "endDate", defaultValue = "") String endDate,	       
	        @RequestParam(value= "sort", defaultValue="") String sort,
			@RequestParam(value ="keyword", defaultValue = "") String keyword,	        
	        HttpSession httpSession,
	        Model model) throws Exception {
	
	    int size = 5;
	    int total_page = 0;
	    int dataCount = 0;
	    
	    if (req.getMethod().equalsIgnoreCase("GET")) { 
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
	    
	    dataCount = productManagementService.countProductsByKeyword( keyword, startDate, endDate);
	    if (dataCount != 0) {
	        total_page = myUtil.pageCount(dataCount, size);
	    }

	    if (total_page < current_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if (offset < 0) offset = 0;

	    List<ProductForList> getProductsByKeyword = productManagementService.getProductsByKeyword(keyword, sort, offset, size, startDate, endDate);
	        
	    
	    String cp = req.getContextPath();
	    String query = "";
	    String listUrl = cp + "/admin/product/productList";
	    
	    if (startDate != null && endDate != null) {
		    query += "&startDate=" + URLEncoder.encode(startDate, "UTF-8") + "&endDate=" + URLEncoder.encode(endDate, "UTF-8");
		}		
			
		if (keyword.length() != 0) {
		    query += "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}
		
		if (sort.length() != 0) {
		    query += "&sort=" + URLEncoder.encode(sort, "UTF-8");
		}
	    listUrl += "?" + query;
	    
	    String paging = myUtil.paging(current_page, total_page, listUrl);

	    model.addAttribute("getProductsByKeyword", getProductsByKeyword);
	    model.addAttribute("page", current_page);
	    model.addAttribute("countProductsByKeyword", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
	    model.addAttribute("sort",sort);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("keyword", keyword);
	    
		return ".admin.product.productList";
	}
}
