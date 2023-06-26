package com.sp.app.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.product.OptionMap;
import com.sp.app.product.management.ProductManagementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class CartManagementRepositoryImplTest {
	
	@Autowired
	CartManagementRepository cartManagementRepository;
	
	@Autowired
	ProductManagementRepository productManagementRepository;
	
	
	@Test
	public void insertStock() throws Exception{
		productManagementRepository.insertStock(null);
	}
	
	
	@Test
	public void createCart() throws Exception{
		// 주어진 값
		Cart cart = new Cart();
		
		cart.setMemberId(1L);
		cart.setProductId(81L);
		cart.setStockId(43L);
		cart.setQuantity(4);
		
		cartManagementRepository.createCart(cart);
		
	}
	
	@Test
	public void checkCartProduct() throws Exception{
		Long memberId = 2L;

		Long stockId = 1L;
		
		Integer result = cartManagementRepository.checkCartProduct(memberId, stockId);
		
		Assert.assertEquals(result, null);
	}
	
	@Test
	public void updateProduct() throws Exception{
		Long cartId = 141L;
		Integer quantity = 4;
		cartManagementRepository.updateCartQuantity(cartId,quantity);
	}
	
	@Test
	public void deleteCart() throws Exception{
		List<Long> cartIdList = new ArrayList<Long>();
		cartIdList.add(102L);
		cartIdList.add(121L);
		
		cartManagementRepository.deleteCart(cartIdList);
	}
	
	@Test
	public void checkQuantity() throws Exception {
		Long stockId = 1L;
		int quantity = 50; // 재고가 없으면 0 반환
		
		int result = cartManagementRepository.checkQuantity(stockId, quantity);
		
		Assert.assertEquals(result, 0);
	}
	
	@Test
	public void viewCart() throws Exception{
		Long stockId = 81L;
		
		List<OptionMap> optionMap = productManagementRepository.getOptionMapByStockId(stockId);
		
		for (OptionMap map : optionMap) {
			map.getMainOptionId();
			map.getMainOptionName();
			map.getSubOptionId();
		}
		
	}
	
}
