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
	public void adjustmentCount() throws Exception{
        String startDate = "2011-01-01";
        String endDate = "2011-12-31";
        String keyword = "테스트";
        String condition = "brandName";
		
        int count = adjustmentRepository.adjustmentCount(startDate, endDate, keyword, condition);		
        System.out.println(count);
	}
}
