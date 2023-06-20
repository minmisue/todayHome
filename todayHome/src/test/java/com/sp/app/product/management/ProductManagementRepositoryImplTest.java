package com.sp.app.product.management;

import com.sp.app.domain.product.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/appServlet/servlet-context.xml",
		"classpath:/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class ProductManagementRepositoryImplTest {

	@Autowired
	ProductManagementRepository productManagementRepository;

	Product product;

	@Before
	public void setUp() throws Exception {
		ArrayList<String> productImgList = new ArrayList<>();
		productImgList.add("productImg1");
		productImgList.add("productImg2");
		productImgList.add("productImg3");

		ArrayList<String> contentImgList = new ArrayList<>();
		contentImgList.add("contentImg1");
		contentImgList.add("contentImg2");
		contentImgList.add("contentImg3");

		product = new Product(1L, 4L, "테스트2", productImgList, contentImgList, "상품 내용");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void createProduct() throws Exception {
		// 주어진 값

		// 테스트 할 메소드
		productManagementRepository.insertProduct(product);

		// 결과
	}

	@Test
	public void insertProductImg() throws Exception {
		// 주어진 값
//		Map<String, Object> imgMap = new HashMap<>();
//		String imgName = "imgTest1";
//		imgMap.put("productId", 61L);
//		imgMap.put("imgName", imgName);
//		imgMap.put("sequence", 5);
//		imgMap.put("type", 0);

		// 테스트 할 메소드
		for (int i = 1; i < 5; i++) {
			Map<String, Object> imgMap = new HashMap<>();
			String imgName = "imgTest";
			imgMap.put("productId", 61L);
			imgMap.put("imgName", imgName + i);
			imgMap.put("sequence", i);
			imgMap.put("type", 0);

			productManagementRepository.insertProductImg(imgMap);
		}


//		productManagementRepository.insertProductImg(imgMap);

		// 결과
	}

	@Test
	public void getProductById() throws Exception {
		// 주어진 값
		Long productId = 161L;

		// 테스트 할 메소드
		Product result = productManagementRepository.getProductById(productId);

		// 결과
//		log.info("result = {}", result);
	}

	@Test
	public void getProductImgList() throws Exception {
		// 주어진 값
		Long productId = 61L;

		// 테스트 할 메소드
		List<ProductImg> productImgList = productManagementRepository.getProductImgList(productId);

		// 결과
		for (ProductImg productImg : productImgList) {
			System.out.println(productImg);
		}
	}

	@Test
	public void increaseImgSequences() throws Exception {
		// 주어진 값
		Long productId = 61L;
		int sequence = 2;

		// 테스트 할 메소드
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("sequence", sequence);

		productManagementRepository.increaseImgSequences(map);

		// 결과
		List<ProductImg> productImgList = productManagementRepository.getProductImgList(productId);
		for (ProductImg productImg : productImgList) {
			System.out.println(productImg);
		}
	}


	@Test
	public void scrapProduct() throws Exception {
		// 주어진 값
		Long productId = 161L;
		Long memberId = 1L;

		// 인서트
		productManagementRepository.insertScrapProduct(memberId, productId);

		// 결과 (스크랩 확인)
		int scrapProduct = productManagementRepository.isScrapProduct(memberId, productId);

		// 검증
		Assert.assertEquals(scrapProduct, 1);

		// 스크랩 삭제
		productManagementRepository.deleteScrapProduct(memberId, productId);
	}

	@Test
	public void insertScrapProduct() throws Exception {
		productManagementRepository.insertScrapProduct(1L, 61L);
	}

	@Test
	public void deleteScrapProduct() throws Exception {
		// 주어진 값

		// 테스트 코드

		// 결과
	}

	@Test
	public void isScrapProduct() throws Exception {
		// 주어진 값

		// 테스트 코드

		// 결과
	}

	@Test
	public void getMainOption() throws Exception {
		List<ProductMainOption> list = new ArrayList<>();

		Long productId = 61L;

		Long mainOptionId = null;

		while (true) {
			ProductMainOption option = productManagementRepository.getMainOptionByParentId(productId, mainOptionId);
			if (option != null) {
				mainOptionId = option.getMainOptionId();

				List<ProductSubOption> subOptions = productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);
				option.setSubOptions(subOptions);

				list.add(option);
			} else {
				break;
			}
		}

		for (ProductMainOption option : list) {
			System.out.println(option);
		}
	}

	@Test
	public void getSubOptionsByMainOptionId() throws Exception {
		Long mainOptionId = 23L;
		List<ProductSubOption> subOptionsByMainOptionId = productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);

		for (ProductSubOption productSubOption : subOptionsByMainOptionId) {
			System.out.println(productSubOption);
		}
	}

	@Test
	public void getStockBySubOptionId() throws Exception {
		Long mainOptionId = 41L;
		List<ProductStock> subOptionsByMainOptionId = productManagementRepository.getStockBySubOptionId(mainOptionId);

		for (ProductStock productStock : subOptionsByMainOptionId) {
			System.out.println(productStock);
		}
	}
}