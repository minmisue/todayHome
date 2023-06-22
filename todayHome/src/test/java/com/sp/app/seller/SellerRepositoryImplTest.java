package com.sp.app.seller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.seller.Seller;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
@Repository
public class SellerRepositoryImplTest{
	Seller seller;
	@Autowired 
	SellerRepository sellerRepository;
	
	
	@Before
	public void hello() {
	
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void createSeller() throws Exception {
		// 주어진 값
		Seller seller = new Seller(20L,"테스트","1234","010avs","테스트","01045450202","dong@","테스트","안녕");
		// 테스트 할 메소드
		sellerRepository.createSeller(seller);
	 
		// 결과
	}
	@Test
	public void GetSellersByCondition() throws Exception {
	    Map<String, Object> params = new HashMap<>();
	    params.put("condition", "sellerName");
	    params.put("keyword", "김동규");
	    params.put("status", new String[]{"0", "1"});
	    params.put("orderByAmount", "desc");
	
	    List<Seller> sellers = sellerRepository.getSellersByCondition(params);
	    for (Seller seller : sellers) {
	        
	        System.out.println(seller.getSellerName());
	    }
	}
	
	@Test
    public void UpdateSeller() throws Exception {
        Seller seller = new Seller(4L,"테스트", "1234", "테스트", "123409874654", "test@", "테스트", "테스트");


        sellerRepository.updateSeller(seller);
    }
	@Test
	public void updateSellerStatus() throws Exception{
		Seller seller = new Seller(4L,1);
		
		sellerRepository.updateSellerStatus(seller);		
	}
	
	@Test
	public void getSellerStatus() throws Exception{
		Long sellerId = 4L;

		Seller seller = sellerRepository.getSellerStatus(sellerId);

		System.out.println(seller);
	}
	@Test
	public void getSellerCountByStatus() throws Exception{
		 int status = 1; // 판매자 상태 값

		 int seller = sellerRepository.getSellerCountByStatus(status); 
		 System.out.println("Seller: " + seller);
	}
}