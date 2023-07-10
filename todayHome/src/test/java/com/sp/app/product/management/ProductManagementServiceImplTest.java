package com.sp.app.product.management;

import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductForList;
import com.sp.app.domain.product.ProductImg;
import com.sp.app.domain.product.ProductStock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class ProductManagementServiceImplTest {

	@Autowired
	ProductManagementService productManagementService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createProduct() throws Exception {
		// 임시 이미지 데이터
		List<ProductImg> productImgList = new ArrayList<>();
		List<ProductImg> contentImgList = new ArrayList<>();
		insertExampleImgData(productImgList, contentImgList);

		Product product = new Product(1L, 4L, "샘플 상품2", productImgList, contentImgList, "hello");

		productManagementService.createProduct(product, null, null, null, null);

	}

	private static void sampleStockList(List<ProductStock> stockList) {
		stockList.add(new ProductStock(1200, 39));
		stockList.add(new ProductStock(1500, 88));
		stockList.add(new ProductStock(2200, 20));
		stockList.add(new ProductStock(3200, 13));
		stockList.add(new ProductStock(2100, 2));
		stockList.add(new ProductStock(5200, 7));
		stockList.add(new ProductStock(2200, 20));
		stockList.add(new ProductStock(1200, 33));
		stockList.add(new ProductStock(600, 11));
	}

	private static void insertExampleImgData(List<ProductImg> productImgList, List<ProductImg> contentImgList) {
		// 상품 이미지 임시 데이터
		productImgList.add(new ProductImg("123213", 0));
		productImgList.add(new ProductImg("6453213", 0));
		productImgList.add(new ProductImg("523113", 0));
		productImgList.add(new ProductImg("23413", 0));

		// 상품 상세 이미지 임시 데이터
		contentImgList.add(new ProductImg("51234", 1));
		contentImgList.add(new ProductImg("6234", 1));
		contentImgList.add(new ProductImg("11234", 1));
		contentImgList.add(new ProductImg("51234", 1));
		contentImgList.add(new ProductImg("21234", 1));
		contentImgList.add(new ProductImg("31234", 1));
	}

	@Test
	public void updateStockQuantity() {
		productManagementService.updateStockQuantity(92L, 45);
	}

	@Test
	public void getQuantityByStockId() {
		int quantityByStockId = productManagementService.getQuantityByStockId(92L);

		System.out.println(quantityByStockId);
	}

	@Test
	public void searchSeller() {
		List<ProductForList> productForLists = productManagementService.searchProductBySellerId(1L, "옵", "price_asc");
		for (ProductForList productForList : productForLists) {
			System.out.println(productForList);
		}
	}

	@Test
	public void scrapList() {
		List<ProductForList> productForLists = productManagementService.getScrapProductList(1L);
		for (ProductForList productForList : productForLists) {
			System.out.println(productForList);
		}
	}
}