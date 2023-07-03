package com.sp.app.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.cart.CartService;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.Member;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.member.management.MemberManagementService;
import com.sp.app.product.management.ProductManagementService;

@Controller("order.orderController")
@RequestMapping("/payment/*")
public class OrderController {
	@Autowired
	CartService cartservice;
	
	@Autowired
	ProductManagementService productservice;
	
	@Autowired
	MemberManagementService memberservie;
	
	@Autowired
	OrderManagementService orderManagementService;
	
	@GetMapping("list")
	public String listCartOrder(HttpSession session,
			Model model) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		Long memberId = info.getMemberId();
		// 전체 장바구니 리스트 가져옴
		List<Cart> cartList = cartservice.getCartList(memberId);

		System.out.println(cartList);
		
		for(Cart cart : cartList) {
			Long cartId = cart.getCartId();
			
			List<CartOptionMap> stockIdList = cartservice.getStockId(cartId);
			
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			
			for(CartOptionMap vo : stockIdList) {
				Long stockId = vo.getStockId();
				
				Long quantity = vo.getQuantity();
				
				ProductStock productStock = productservice.getStockByStockId(stockId);
				productStock.setPrice(Long.valueOf(productStock.getOptionPrice()));
				
				productStock.setCartQuantity(quantity);
				productStockList.add(productStock);
			}
			
			cart.setProductStockList(productStockList);
			
		}
		
		String orderBundleId = orderManagementService.productOrderNumber();
		Member member = memberservie.readMemberById(memberId);
		
		model.addAttribute("orderBundleId", orderBundleId);
		model.addAttribute("member", member);
		model.addAttribute("cartList", cartList);
		
		return "/payment/payment-page";
	}
	
	@PostMapping("paymentOk")
	@ResponseBody
	public String paymentSubmit(
			@ModelAttribute Order order,
			@RequestParam List<Long> productNums,
			@RequestParam List<Integer> finalPrices,
			@RequestParam List<Integer> originalPrices,
			@RequestParam List<Integer> disCountPercent,
			@RequestParam List<Integer> price,
			@RequestParam List<Long> stockNums,
			@RequestParam List<Integer> quantityList
			) {
		
		// 옵션 상세
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		for(int i=0;i<productNums.size();i++) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderBundleId(order.getOrderBundleId());
			orderDetail.setProductId(productNums.get(i));
			orderDetail.setDisCountPercent(disCountPercent.get(i));
			orderDetail.setFinalPrice(finalPrices.get(i));
			orderDetail.setOriginalPrice(originalPrices.get(i));
			
			orderDetailList.add(orderDetail);
		}
		
		List<OrderItemStock> orderItemStockList = new ArrayList<OrderItemStock>();
		for(int i=0;i<stockNums.size();i++) {
			OrderItemStock orderItemStock = new OrderItemStock();
			orderItemStock.setPrice(price.get(i));
			orderItemStock.setQuantity(quantityList.get(i));
			orderItemStock.setStockId(stockNums.get(i));
			orderItemStockList.add(orderItemStock);
		}
		
		return "ok";
	}
}
