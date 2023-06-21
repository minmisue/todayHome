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
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
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

	@Test
	public void productOptionProcessUsingWhile() throws Exception {
		// 상품 아이디
		Long productId = 61L;

		// 메인 옵션 개수
		int mainOptionCnt = productManagementRepository.getMainOptionCnt(productId);
		System.out.println("메인 옵션 개수 : " + productId);

		Long mainOptionId = null;
		while (true) {
			// 첫 메인 옵션 아이디
			ProductMainOption mainOption = productManagementRepository.getMainOptionByParentId(productId, mainOptionId);
			if (mainOption == null) {
				System.out.println("옵션 없음");
				return;
			}

			mainOptionId = mainOption.getMainOptionId();

			// 서브 옵션 리스트 반환
			List<ProductSubOption> subOptions = productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);
			System.out.println("최초 옵션 : " + mainOption.getOptionName());
			System.out.println("\n선택 사항");
			for (ProductSubOption subOption : subOptions) {
				System.out.println("--------------------------------");
				System.out.print("아이디 : " + subOption.getOptionDetailId() + " | ");
				System.out.println("옵션 : " + subOption.getOptionDetailName());

				List<ProductStock> stockBySubOptions = productManagementRepository.getStockBySubOptionId(subOption.getOptionDetailId());

				for (ProductStock stockBySubOption : stockBySubOptions) {
					System.out.println(
							"옵션1 : " + stockBySubOption.getOptionDetailId1() +
							" , 옵션2 : " + stockBySubOption.getOptionDetailId2() +
							" , 가격 : " + stockBySubOption.getOptionPrice()
					);
				}
				System.out.println("--------------------------------");
			}
			productId = mainOption.getProductId();

		}
	}

	@Test
	public void productOptionProcess() throws Exception {
		// 상품 아이디
		Long productId = 61L;

		// 메인 옵션 개수
		int mainOptionCnt = productManagementRepository.getMainOptionCnt(productId);
		System.out.println("메인 옵션 개수 : " + productId);

		Long mainOptionId = null;

		// 첫 메인 옵션 아이디
		ProductMainOption mainOption = productManagementRepository.getMainOptionByParentId(productId, mainOptionId);
		if (mainOption == null) {
			System.out.println("옵션 없음");
			return;
		}

		mainOptionId = mainOption.getMainOptionId();

		// 서브 옵션 리스트 반환
		List<ProductSubOption> subOptions = productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);
		System.out.println("최초 옵션 : " + mainOption.getOptionName());
		System.out.println("\n선택 사항");
		for (ProductSubOption subOption : subOptions) {
			System.out.println("--------------------------------");
			System.out.print("아이디 : " + subOption.getOptionDetailId() + " | ");
			System.out.println("옵션 : " + subOption.getOptionDetailName());
			System.out.println("--------------------------------");
		}

		productId = mainOption.getProductId();


		// 두번째 옵션 아이디
		mainOption = productManagementRepository.getMainOptionByParentId(productId, mainOptionId);

		if (mainOption == null) {
			System.out.println("옵션 없음");
			return;
		}

		mainOptionId = mainOption.getMainOptionId();

		// 서브 옵션 리스트 반환
		subOptions = productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);
		System.out.println("최초 옵션 : " + mainOption.getOptionName());
		System.out.println("\n선택 사항");
		for (ProductSubOption subOption : subOptions) {
			System.out.println("--------------------------------");
			System.out.print("아이디 : " + subOption.getOptionDetailId() + " | ");
			System.out.println("옵션 : " + subOption.getOptionDetailName());

			List<ProductStock> stockBySubOptions = productManagementRepository.getStockBySubOptionId(subOption.getOptionDetailId());

			for (ProductStock stockBySubOption : stockBySubOptions) {
				System.out.println(
						"옵션1 : " + stockBySubOption.getOptionDetailId1() +
								" , 옵션2 : " + stockBySubOption.getOptionDetailId2() +
								" , 가격 : " + stockBySubOption.getOptionPrice()
				);
			}
			System.out.println("--------------------------------");
		}
	}

	@Test
	public void getMainOptionCnt() throws Exception {
		// 상품 아이디
		Long product = 61L;

		// 첫 메인 옵션 아이디
		int mainOptionCnt = productManagementRepository.getMainOptionCnt(product);
		System.out.println(mainOptionCnt);

	}


}