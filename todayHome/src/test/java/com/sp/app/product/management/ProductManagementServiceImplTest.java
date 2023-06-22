package com.sp.app.product.management;

import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductImg;
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

		Product product = new Product(1L, 4L, "샘플 상품", productImgList, contentImgList, "hello");

		productManagementService.createProduct(product);

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
}