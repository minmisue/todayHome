package com.sp.app.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.cart.CartService;

@Controller("cart.cartController")
@RequestMapping("/cart/*")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@GetMapping("list")
	public String cartList() throws Exception{
		
		
		
		return ".cart.cart-list";
	}

}
