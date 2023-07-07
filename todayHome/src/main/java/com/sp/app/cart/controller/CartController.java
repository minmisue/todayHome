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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.cart.CartService;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.product.management.ProductManagementService;

@Controller("cart.cartController")
@RequestMapping("/cart/*")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ProductManagementService productservice;
	
	@GetMapping("cartEmpty")
	public String cartEmpty() {
		return "/cart/cart-empty";
	}
	
	
	@GetMapping("list")
	public String listCart(HttpSession session,
			Model model) {
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		if(info == null) {
			return "redirect:/login";
		}
		
		Integer dataCount = cartservice.cartDateCountByMemberId(info.getMemberId());
		System.out.println(dataCount);
		if(dataCount == null || dataCount == 0) {
			return "redirect:/cart/cartEmpty";
		}
		
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
		
		Integer dataCartCount = cartservice.cartDateCountByMemberId(info.getMemberId());
		session.setAttribute("dataCartCount", dataCartCount);
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("mode", "cart");
		return "/cart/cart-list";
	}
	
	
	
	// 상품의 옵션 삭제
	@GetMapping("deleteStock")
	public String deleteStock(
			@RequestParam Long stockId,HttpSession session
			) {
		cartservice.deleteStock(stockId);
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		Integer dataCartCount = cartservice.cartDateCountByMemberId(info.getMemberId());
		session.setAttribute("dataCartCount", dataCartCount);
		
		return "redirect:/cart/list";
	}
	
	// 선택 or 전체 삭제
	@GetMapping("deleteCart")
	public String deleteCart(
			@RequestParam List<Long> cartIdList,HttpSession session) {
		
		for(Long cartId : cartIdList) {
			cartservice.deleteCart(cartId);
		}
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		Integer dataCartCount = cartservice.cartDateCountByMemberId(info.getMemberId());
		session.setAttribute("dataCartCount", dataCartCount);
		
		return "redirect:/cart/list";
	}
	
	@PostMapping("checkQuantityUpdate")
	@ResponseBody
	public Map<String, String> checkQuantityUpdate(
			@RequestParam Map<String, Object> map) {
		
		Map<String, String> model = new HashMap<String, String>();
		
		cartservice.checkQuantityUpdate(map);
		model.put("state", "true");
		
		return model;
	}
	
//	@GetMapping("checkQuantityUpdate")
//	public String checkQuantityUpdate(
//			@RequestParam Long stockId,
//			@RequestParam Long cartId,
//			@RequestParam Long quantity
//			) {
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("stockId", stockId);
//		map.put("cartId", cartId);
//		map.put("quantity", quantity);
//		
//		cartservice.checkQuantityUpdate(map);
//		
//		return "redirect:/cart/list";
//	}


}
