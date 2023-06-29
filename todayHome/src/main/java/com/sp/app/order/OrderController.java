package com.sp.app.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.cart.CartService;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.Member;
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
				productStock.setPrice(productStock.getOptionPrice()*quantity);
				
				productStock.setCartQuantity(quantity);
				productStockList.add(productStock);
			}
			
			cart.setProductStockList(productStockList);
			
		}
		
		
		Member member = memberservie.readMemberById(memberId);
		
		model.addAttribute("member", member);
		model.addAttribute("cartList", cartList);
		model.addAttribute("msg","ㅎㅇㅎㅇ");
		return "/payment/payment-page";
	}
}
