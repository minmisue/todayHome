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

import oracle.net.aso.c;

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
	public void insertStock() throws Exception{
		Cart cart = new Cart();
		
		cart.setMemberId(1L);
		cart.setProductId(262L);
		
		CartOptionMap cartOptionMap = new CartOptionMap();
		cartOptionMap.setStockId(90L);
		cartOptionMap.setQuantity(2L);
		
		List<CartOptionMap> stockList = new ArrayList<CartOptionMap>();
		
		stockList.add(cartOptionMap);
		cart.setStockList(stockList);
		
		cartService.createCart(cart);
		
	}
}
