package com.sp.app.order;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class OrderManagementRepositoryImplTest {
	@Autowired
	OrderManagementRepository orderManagementRepository;
	@Autowired
	OrderManagementService orderManagementService;
	
	@Test
	public void createOrder() throws Exception{
		// 주어진 값
		
		Order order = new Order(1L, "김민주", "010-1111-1111", "주소", "주소", "주소", 0, "카드", 1, 1, 1);
		
		orderManagementRepository.insertOrderBundle(order);
		System.out.println(order.getOrderBundleId());
		
	}
	
	
	@Test
	public void getOr() throws Exception{
		
		
	}


}
