package com.sp.app.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sp.app.domain.product.ProductStock;
import com.sp.app.product.management.ProductManagementService;

@Controller("cart.cartController")
@RequestMapping("/cart/*")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ProductManagementService productservice;
	
	@GetMapping("list")
	public String listCart(HttpSession session,
			Model model) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		// 전체 장바구니 리스트 가져옴
		List<Cart> cartList = cartservice.getCartList(info.getMemberId());
		
		Map<String, List<ProductStock>> map = new HashMap<String, List<ProductStock>>();
		
		for(Cart dto : cartList) {
			Long cartId = dto.getCartId();
			
			List<CartOptionMap> stockIdList = cartservice.getStockId(cartId);
			
			
			List<ProductStock> optionList = new ArrayList<ProductStock>();
			for(CartOptionMap vo : stockIdList) {
				System.out.println(vo.getStockId());
				optionList.add(productservice.getStockByStockId(vo.getStockId()));
			}
			
			String cartIdToStr = String.valueOf(cartId);
			map.put(cartIdToStr, optionList);
		}
		
		model.addAttribute("ProductStockMap", map);
		model.addAttribute("cartList", cartList);
		
		return "/cart/cart-list";
	}
	

}
