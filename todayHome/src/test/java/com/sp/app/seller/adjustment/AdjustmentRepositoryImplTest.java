package com.sp.app.seller.adjustment;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.sp.app.domain.seller.SellerAdjustment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
@Repository
public class AdjustmentRepositoryImplTest {
	SellerAdjustment sellerAdjustment;
	
	@Autowired
	AdjustmentRepository adjustmentRepository;
	
	@Before
	public void hello() {
	
	}
	
	@After
	public void after() {
		
	}
	
	
	@Test
	public void createAdjustment() throws Exception{
		SellerAdjustment sellerAdjustment = new SellerAdjustment(4L,10000L);
		// 테스트 할 메소드
		adjustmentRepository.createAdjustment(sellerAdjustment);
	}
	@Test	
	public void getAdjustmentsBySellerId() throws Exception{
		Long sellerId = 1L;
		
		List<SellerAdjustment> adjustmentList=adjustmentRepository.getAdjustmentsBySellerId(sellerId);
		
		for (SellerAdjustment sellerAdjustment : adjustmentList) {
			System.out.println(sellerAdjustment);
		}
	}
	
	@Test
	public void getAllAdjustments() throws Exception{
		
		int size;
		List<SellerAdjustment> adjustmentList = adjustmentRepository.getAllAdjustments();
		
		for (SellerAdjustment sellerAdjustment : adjustmentList) {
			System.out.println(sellerAdjustment);
		}
	}
	@Test
	public void adjustmentCount() throws Exception{
		adjustmentRepository.adjustmentCount();
		
	}
}
