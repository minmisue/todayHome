package com.sp.app.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class CartManagementServiceImplTest {
	
	@Autowired
	CartService cartService;
	
	
	@Test
	public void insertStock() {
		try {
			Cart cart = new Cart();

			cart.setMemberId(1L);
			cart.setProductId(81L);

			CartOptionMap cartOptionMap = new CartOptionMap();
			cartOptionMap.setStockId(42L);
			cartOptionMap.setQuantity(1L);
			List<CartOptionMap> stockList = new ArrayList<CartOptionMap>();
			stockList.add(cartOptionMap);
			cart.setStockList(stockList);

			cartService.createCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void cartList() {
		Long memberId = 161L;
		List<Cart> cartList = cartService.getCartList(memberId);
		for (Cart cart : cartList) {
			System.out.println(cart);
		}

	}
}
