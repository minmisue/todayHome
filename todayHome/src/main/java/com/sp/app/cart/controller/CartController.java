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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

		System.out.println(cartList);
		
		for(Cart cart : cartList) {
			Long cartId = cart.getCartId();
			
			List<CartOptionMap> stockIdList = cartservice.getStockId(cartId);
			
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			
			for(CartOptionMap vo : stockIdList) {
				Long stockId = vo.getStockId();
				
				Long quantity = vo.getQuantity();
				
				ProductStock productStock = productservice.getStockByStockId(stockId);
				// 그냥 옵션 가격
				productStock.setPrice(Long.valueOf(productStock.getOptionPrice()));
				
				// 수량
				productStock.setCartQuantity(quantity);
				productStockList.add(productStock);
			}
			
			cart.setProductStockList(productStockList);
			
		}
		
		model.addAttribute("cartList", cartList);
		
		return "/cart/cart-list";
	}
	
	// 상품의 옵션 삭제
	@GetMapping("deleteStock")
	public String deleteStock(
			@RequestParam Long stockId
			) {
		cartservice.deleteStock(stockId);
		
		return "redirect:/cart/list";
	}
	
	// 선택 or 전체 삭제
	@GetMapping("deleteCart")
	public String deleteCart(
			@RequestParam List<Long> cartIdList) {
		
		for(Long cartId : cartIdList) {
			cartservice.deleteCart(cartId);
		}
		
		return "redirect:/cart/list";
	}
	
	@PostMapping("checkQuantityUpdate")
	@ResponseBody
	public Map<String, Object> checkQuantityUpdate(
			@RequestBody Map<String, Object> map
			) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		cartservice.checkQuantityUpdate(map);
		
		model.put("quantity", map.get("quantity"));
		
		return model;
	
	}


}
