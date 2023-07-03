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
import java.util.concurrent.ThreadLocalRandom;

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

//		product = new Product(1L, 4L, "테스트2", productImgList, contentImgList, "상품 내용");
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

//			productManagementRepository.insertProductImg(imgMap);
		}


//		productManagementRepository.insertProductImg(imgMap);

		// 결과
	}

	@Test
	public void getProductById() throws Exception {
		// 주어진 값
		Long productId = 268L;

		// 테스트 할 메소드
		Product result = productManagementRepository.getProductById(productId);

		// 결과
		System.out.println(result);
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
		productManagementRepository.increaseImgSequences(productId, sequence);

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
		Long mainOptionId = 42L;
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
				System.out.print("아이디 : " + subOption.getSubOptionId() + " | ");
				System.out.println("옵션 : " + subOption.getSubOptionName());

				List<ProductStock> stockBySubOptions = productManagementRepository.getStockBySubOptionId(subOption.getSubOptionId());

				for (ProductStock stockBySubOption : stockBySubOptions) {
					System.out.println(
							"옵션1 : " + stockBySubOption.getSubOptionId1() +
							" , 옵션2 : " + stockBySubOption.getSubOptionId2() +
							" , 가격 : " + stockBySubOption.getOptionPrice()
					);
				}
				System.out.println("--------------------------------");
			}
			productId = mainOption.getProductId();

		}
	}

	@Test
	public void getProductOptionsProcess() throws Exception {
		// 상품 아이디
		Long productId = 247L;

		// 메인 옵션 개수
		int mainOptionCnt = productManagementRepository.getMainOptionCnt(productId);
		System.out.println("메인 옵션 개수 : " + mainOptionCnt);

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
			System.out.print("아이디 : " + subOption.getSubOptionId() + " | ");
			System.out.println("옵션 : " + subOption.getSubOptionName());
			System.out.println("--------------------------------");
		}

		productId = mainOption.getProductId();


		// 두번째 옵션 아이디
		mainOption = productManagementRepository.getMainOptionByParentId(productId, mainOptionId);

		if (mainOption == null) {
			System.out.println("옵션 없음");
			return;
		}

		for (ProductSubOption subOption : subOptions) {
			List<ProductStock> stockBySubOptions = productManagementRepository.getStockBySubOptionId(subOption.getSubOptionId());
			System.out.println("--------------------------------");
			System.out.println("선택 옵션 : " + subOption.getSubOptionName());
			System.out.println();
			for (ProductStock stockBySubOption : stockBySubOptions) {
				System.out.println(
								"옵션1 " + stockBySubOption.getSubOptionId1() + " : " + stockBySubOption.getSubOptionName1() +
								" , 옵션2 " + stockBySubOption.getSubOptionId2() + " : " + stockBySubOption.getSubOptionName2() +
								" , 가격 : " + stockBySubOption.getOptionPrice() +
								" , 재고 : " + stockBySubOption.getQuantity()
				);
			}
			System.out.println("--------------------------------");
		}

//		mainOptionId = mainOption.getMainOptionId();
//
//		// 서브 옵션 리스트 반환
//		subOptions = productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);
//		System.out.println("최초 옵션 : " + mainOption.getOptionName());
//		System.out.println("\n선택 사항");
//
//
//		for (ProductSubOption subOption : subOptions) {
//			System.out.println("--------------------------------");
//			System.out.print("아이디 : " + subOption.getSubOptionId() + " | ");
//			System.out.println("옵션 : " + subOption.getSubOptionName());
//
//			System.out.println("--------------------------------");
//		}
	}

	@Test
	public void getMainOptionCnt() throws Exception {
		// 상품 아이디
		Long product = 81L;

		// 첫 메인 옵션 아이디
		int mainOptionCnt = productManagementRepository.getMainOptionCnt(product);
		System.out.println(mainOptionCnt);
	}

	@Test
	public void getOptionMapByStockId() throws Exception {
		Long stockId = 42L;

		List<OptionMap> optionMap = productManagementRepository.getOptionMapByStockId(stockId);

		for (OptionMap map : optionMap) {
			System.out.println(map);
		}
	}

	@Test
	public void insertMainOption() throws Exception {
		Long productId = 81L;

		ProductMainOption mainOption = new ProductMainOption(null, "신발 종류", productId);
		productManagementRepository.insertMainOption(mainOption);

		Long mainOptionId = mainOption.getMainOptionId();
		ProductSubOption productSubOption;

		List<String> subOptionNames1 = new ArrayList<>();
		subOptionNames1.add("에어포스");
		subOptionNames1.add("슈퍼스타");

		List<ProductSubOption> subOptionList1 = new ArrayList<>();

		for (String subOptionName : subOptionNames1) {
			productSubOption = new ProductSubOption(mainOptionId, subOptionName);
			productManagementRepository.insertSubOption(productSubOption);
			subOptionList1.add(productSubOption);
		}

		mainOption = new ProductMainOption(mainOptionId, "발 사이즈", productId);
		productManagementRepository.insertMainOption(mainOption);

		mainOptionId = mainOption.getMainOptionId();

		List<ProductSubOption> subOptionList2 = new ArrayList<>();
		List<String> subOptionNames2 = new ArrayList<>();

		subOptionNames2.add("260");
		subOptionNames2.add("250");
		subOptionNames2.add("240");
		subOptionNames2.add("230");

		for (String subOptionName : subOptionNames2) {
			productSubOption = new ProductSubOption(mainOptionId, subOptionName);
			productManagementRepository.insertSubOption(productSubOption);
			subOptionList2.add(productSubOption);
		}

//		for (ProductSubOption subOption : subOptionList2) {
//			System.out.println(subOption);
//		}

		for (ProductSubOption subOption : subOptionList1) {
			Long optionId1 = subOption.getSubOptionId();
			System.out.println("-----------------------------");
			System.out.println(subOption);
			for (ProductSubOption option : subOptionList2) {
				System.out.println(optionId1 + " / " + option.getSubOptionId());
			}
			System.out.println("-----------------------------");
		}
	}

	@Test
	public void insertSubOption() throws Exception {
		ProductSubOption productSubOption = new ProductSubOption(65L, "예제 서브 옵션");
		productManagementRepository.insertSubOption(productSubOption);

		System.out.println(productSubOption.getSubOptionId());
	}

	@Test
	public void insertStock() throws Exception {
		List<Long> subOptionIdList1 = new ArrayList<>();
		List<Long> subOptionIdList2 = new ArrayList<>();

//		productManagementRepository.getMainOptionByParentId()

//		productManagementRepository.getSubOptionsByMainOptionId();

		subOptionIdList1.add(131L);
		subOptionIdList1.add(132L);

		subOptionIdList2.add(133L);
		subOptionIdList2.add(134L);
		subOptionIdList2.add(135L);
		subOptionIdList2.add(136L);

		int quantity = 33;

		for (Long option1 : subOptionIdList1) {
			for (Long option2 : subOptionIdList2) {
				// 랜덤 숫자
				int randomNumber = ThreadLocalRandom.current().nextInt(10, 500) * 100;

				ProductStock stock = new ProductStock(randomNumber, quantity, option1, option2);
				productManagementRepository.insertStock(stock);

				quantity--;
			}
		}
	}

	@Test
	public void getStockListByProductId() throws Exception {
		Long productId = 287L;

		List<ProductStock> stockList = productManagementRepository.getStockListByProductId(productId);

		for (ProductStock stock : stockList) {
			System.out.println(stock);
		}
	}

	@Test
	public void scrapCnt() throws Exception {
		Long productId = 268L;

		int cnt = productManagementRepository.scrapCnt(productId);
		System.out.println(cnt);
	}

	@Test
	public void getStockByStockId() throws Exception {
		Long stockId = 92L;

		ProductStock stock = productManagementRepository.getStockByStockId(stockId);
		System.out.println(stock);
	}

	@Test
	public void getAllProduct() throws Exception {
		List<ProductForList> products = productManagementRepository.getAllProducts();

		for (ProductForList product : products) {
			System.out.println(product);
		}
	}

	@Test
	public void getProductsByKeyword() throws Exception{
		List<ProductForList> products = productManagementRepository.getProductsByKeyword("이", "price_desc");

		for (ProductForList product : products) {
			System.out.println(product);
		}
	}
}