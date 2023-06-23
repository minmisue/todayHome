package com.sp.app.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.product.management.ProductManagementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class CartManagementServiceImplTest {
	
	@Autowired
	CartManagementRepository cartManagementRepository;
	
	@Autowired
	ProductManagementRepository productManagementRepository;
	
	
	@Test
	public void insertStock() throws Exception{
		productManagementRepository.insertStock(null);
	}
}
