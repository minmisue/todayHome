package com.sp.app.cart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class CartManagementRepositoryImplTest {
	
	@Autowired
	CartManagementRepository cartManagementRepository;
	
	
	@Test
	public void createProduct() throws Exception{
		// 주어진 값
		Cart cart = new Cart();
		
		cart.setMemberId(1L);
		cart.setProductId(61L);
		cart.setStockId(1L);
		cart.setQuantity(2);
		
		
		cartManagementRepository.createProduct(cart);
		
	}
	
	@Test
	public void checkCartProduct() throws Exception{
		Long memberId = 2L;
		Long productId = 61L;
		Long stockId = 1L;
		
		int result = cartManagementRepository.checkCartProduct(memberId, productId, stockId);
		
		Assert.assertEquals(result, 0);
	}
	
	@Test
	public void updateProduct() throws Exception{
		Long cartId = 87L;
		Integer quantity = 7;
		cartManagementRepository.updateProduct(cartId,quantity);
	}
	
	@Test
	public void deleteCart() throws Exception{
		Long cartId = 87L;
		
		cartManagementRepository.deleteCart(cartId);
	}
	
}
