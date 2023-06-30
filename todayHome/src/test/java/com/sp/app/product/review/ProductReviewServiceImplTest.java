package com.sp.app.product.review;

import com.sp.app.domain.product.ProductReview;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class ProductReviewServiceImplTest {

	@Autowired
	ProductReviewService productReviewService;

	@Test
	public void createReview() {
	}

	@Test
	public void updateReview() {
	}

	@Test
	public void deleteReview() {
	}

	@Test
	public void findReviewsByMemberId() {
	}

	@Test
	public void findReviewsByProductId() {
	}

	@Test
	public void getAverageRatingByProductId() {
	}

	@Test
	public void getComposableProductList() throws Exception {
		Long memberId = 1L;
		List<ProductReview> productList = productReviewService.getComposableProductList(memberId);

		for (ProductReview productReview : productList) {
			System.out.println(productReview);
		}
	}
}