package com.sp.app.seller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.sp.app.common.MyUtil;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.product.ProductForList;
import com.sp.app.domain.product.ProductReview;
import com.sp.app.domain.seller.Seller;
import com.sp.app.order.OrderManagementService;
import com.sp.app.product.management.ProductManagementService;
import com.sp.app.product.review.ProductReviewService;

@Controller
public class SellerController {
	
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
	
	@RequestMapping("seller/delivery/ordermanage")
	public String orderList(
			Seller seller,
	        Order order,
	        HttpServletRequest req,
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        @RequestParam(value = "startDate", defaultValue="") String startDate,
	        @RequestParam(value = "endDate", defaultValue = "") String endDate,	       
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
	    
	    if (req.getMethod().equalsIgnoreCase("GET")) { 
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
	    
	    dataCount = orderManagementService.orderListCount(sellerId, startDate, endDate, keyword, condition);
	    if (dataCount != 0) {
	        total_page = myUtil.pageCount(dataCount, size);
	    }

	    if (total_page < current_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if (offset < 0) offset = 0;

	    List<Order> getOrderList = orderManagementService.getOrderList(sellerId, offset, size, startDate, endDate, keyword, condition);
	        
	    
	    String cp = req.getContextPath();
	    String query = "";
	    String listUrl = cp + "/seller/delivery/ordermanage";
	    
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

	    model.addAttribute("getOrderList", getOrderList);
	    model.addAttribute("page", current_page);
	    model.addAttribute("orderListCount", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
	    return ".seller.deliveryManage.ordermanage";
	}
	@RequestMapping(value = "/seller/deliveryManage/ordermanagedetail/{orderBundleId}", method = RequestMethod.GET)
	public String orderDetail(HttpServletRequest req,
	        @PathVariable("orderBundleId") String orderBundleId,
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        Model model, Order order) throws Exception {
	    int size = 10;
	    int total_page = 0;

	    List<Order> getOrderDetailList = orderManagementService.getOrderDetailList(orderBundleId, 0, Integer.MAX_VALUE);

	    Map<Long, Order> highestStatusOrdersMap = new HashMap<>();

	    int dataCount = 0;
	    for (Order orderDetail : getOrderDetailList) {
	        Long stockId = orderDetail.getStockId();
	        int status = orderDetail.getStatus();

	        if (!highestStatusOrdersMap.containsKey(stockId) || status > highestStatusOrdersMap.get(stockId).getStatus()) {
	            highestStatusOrdersMap.put(stockId, orderDetail);
	        }

	        if (orderDetail.equals(highestStatusOrdersMap.get(stockId))) {
	            dataCount++;
	        }
	    }

	    if (dataCount != 0) {
	        total_page = myUtil.pageCount(dataCount, size);
	    }

	    if (total_page < current_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if (offset < 0) offset = 0;

	    List<Order> filteredOrderList = new ArrayList<>(highestStatusOrdersMap.values());

	    String cp = req.getContextPath();
	    String query = orderBundleId; 
	    String listUrl = cp + "/seller/deliveryManage/ordermanagedetail/";
	    listUrl += query;

	    String paging = myUtil.paging(current_page, total_page, listUrl);

	    model.addAttribute("page", current_page);
	    model.addAttribute("orderDetailCount", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    model.addAttribute("order", order);
	    model.addAttribute("getOrderDetailList", filteredOrderList);

	    return ".seller.deliveryManage.ordermanagedetail";
	}


	
	@RequestMapping("seller/review/reviewList")
	public String reviewList(
			Seller seller,
	        ProductReview productReview, 
	        HttpServletRequest req,
	        @RequestParam(value = "page", defaultValue = "1") int current_page,
	        @RequestParam(value = "startDate", defaultValue="") String startDate,
	        @RequestParam(value = "endDate", defaultValue = "") String endDate,	       
	        @RequestParam(value = "rating", defaultValue = "6") float rating,
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
	    
	    if (req.getMethod().equalsIgnoreCase("GET")) { 
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
	    
	    dataCount = productReviewService.searchReviewCount(sellerId, startDate, endDate, keyword, rating);
	    if (dataCount != 0) {
	        total_page = myUtil.pageCount(dataCount, size);
	    }

	    if (total_page < current_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if (offset < 0) offset = 0;

	    List<ProductReview> searchReview = productReviewService.searchReview(sellerId, startDate, endDate, keyword, rating, offset, size);
	        
	    
	    String cp = req.getContextPath();
	    String query = "";
	    String listUrl = cp + "/seller/review/reviewList";
	    
	    if (startDate != null && endDate != null) {
		    query += "&startDate=" + URLEncoder.encode(startDate, "UTF-8") + "&endDate=" + URLEncoder.encode(endDate, "UTF-8");
		}		
			
		if (keyword.length() != 0) {
		    query += "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
		}
		
		if (rating != 0) {
		    query += "&rating=" + rating;
		}
	    listUrl += "?" + query;
	    
	    String paging = myUtil.paging(current_page, total_page, listUrl);

	    model.addAttribute("searchReview", searchReview);
	    model.addAttribute("page", current_page);
	    model.addAttribute("searchReviewCount", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
	    model.addAttribute("rating",rating);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("keyword", keyword);
	    
		return ".seller.review.reviewList";
	}

	@RequestMapping(value = "/seller/deliveryManage/order-status-change/{orderItemId}", method = RequestMethod.GET)
	public String reviewPage(@PathVariable("orderItemId") String orderItemId, Model model,Order order) {

		
		model.addAttribute("order",order);
		return ".seller.deliveryManage.order-status-change";

	}
	@RequestMapping(value = "/seller/deliveryManage/order-status-change/{orderItemId}", method = RequestMethod.POST)
	public String updateReviewPage(@PathVariable("orderItemId") String orderItemId, Model model, Order order, OrderDetail orderDetail) {
	    try {
	        
	        orderManagementService.createOrderState(orderDetail);
	        
	        model.addAttribute("order", order);
	    } catch (Exception e) {

	    }
	    
	    return ".seller.deliveryManage.order-status-change";
	}
	@RequestMapping("seller/product/productList")
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
	    SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) httpSession.getAttribute("sellerSessionInfo");
	    Long sellerId = sellerSessionInfo.getSellerId();
	    
	    if (sellerSessionInfo != null && sellerSessionInfo.getStatus() == 0) {
	        
	        return "redirect:/seller/error";
	    }
	    int size = 5;
	    int total_page = 0;
	    int dataCount = 0;
	    
	    if (req.getMethod().equalsIgnoreCase("GET")) { 
			keyword = URLDecoder.decode(keyword, "utf-8");
		}
	    
	    dataCount = productManagementService.countProductBySellerId(sellerId, keyword, startDate, endDate);
	    if (dataCount != 0) {
	        total_page = myUtil.pageCount(dataCount, size);
	    }

	    if (total_page < current_page) {
	        current_page = total_page;
	    }

	    int offset = (current_page - 1) * size;
	    if (offset < 0) offset = 0;

	    List<ProductForList> searchProductBySellerId = productManagementService.searchProductBySellerId(sellerId, keyword, sort, offset, size, startDate, endDate);
	        
	    
	    String cp = req.getContextPath();
	    String query = "";
	    String listUrl = cp + "/seller/product/productList";
	    
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

	    model.addAttribute("searchProductBySellerId", searchProductBySellerId);
	    model.addAttribute("page", current_page);
	    model.addAttribute("countProductBySellerId", dataCount);
	    model.addAttribute("total_page", total_page);
	    model.addAttribute("paging", paging);
	    
	    model.addAttribute("sort",sort);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("keyword", keyword);
	    
		return ".seller.product.productList";
	}
	
} 


