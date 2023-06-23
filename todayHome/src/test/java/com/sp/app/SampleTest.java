package com.sp.app;

import com.sp.app.domain.product.*;
import com.sp.app.product.management.ProductManagementRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class SampleTest {

	@Autowired
	ProductManagementRepository productManagementRepository;

	// 모든 테스트 시작 전마다 실행
	@Before
	public void setUp() throws Exception {

	}

	// 모든 테스트 종료 후 실행
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void insertProduct() throws Exception {
		// 주어진 값
		ArrayList<String> productImgList = new ArrayList<>();
		productImgList.add("productImg1");
		productImgList.add("productImg2");
		productImgList.add("productImg3");

		ArrayList<String> contentImgList = new ArrayList<>();
		contentImgList.add("contentImg1");
		contentImgList.add("contentImg2");
		contentImgList.add("contentImg3");

//		Product product = new Product(1L, 4L, "테스트2", productImgList, contentImgList, "상품 내용");

		// 테스트 할 메소드
//		productManagementRepository.insertProduct(product);

		// 결과
	}

	@Test
	public void scrapProduct() throws Exception {
		// 주어진 값
		Long productId = 161L;
		Long memberId = 1L;

		// 테스트 할 메소드
		productManagementRepository.insertScrapProduct(memberId, productId);

		// 결과 (스크랩 확인)
		int scrapProduct = productManagementRepository.isScrapProduct(memberId, productId);

		Assert.assertEquals(scrapProduct, 1); // 검증

		productManagementRepository.deleteScrapProduct(memberId, productId); // 스크랩 삭제 (테스트 재사용 위해서)
	}

	@Test
	public void getStockBySubOptionId() throws Exception {
		Long mainOptionId = 41L;

		List<ProductStock> subOptionsByMainOptionId = productManagementRepository.getStockBySubOptionId(mainOptionId);

		for (ProductStock productStock : subOptionsByMainOptionId) {
			System.out.println(productStock);
		}

		int price = subOptionsByMainOptionId.get(0).getOptionPrice();

//		Assert.assertEquals(4000, price);
	}
}