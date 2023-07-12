package com.sp.app.product.review;

import com.google.gson.Gson;
import com.sp.app.domain.member.SimpleMember;
import com.sp.app.domain.product.ProductReview;
import com.sp.app.domain.product.ReviewProduct;
import org.json.JSONArray;
import org.json.JSONObject;
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
public class ProductReviewRepositoryImplTest {

	@Autowired
	ProductReviewRepository productReviewRepository;

	@Test
	public void createReview() throws Exception {
		Long orderItemId = 26L;
		Float rating = 4.5f;
		String content = "리뷰 테스트 2";
		String reviewImgName = "리뷰 이미지2";

		ProductReview productReview = new ProductReview(orderItemId, rating, content, reviewImgName);

		productReviewRepository.createReview(productReview);
	}

	@Test
	public void updateReview() throws Exception {
		Long orderItemId = 26L;
		Float rating = 2.5f;
		String content = "리뷰 테스트 1 수정";
		String reviewImgName = "리뷰 이미지 수정";

		ProductReview productReview = new ProductReview(orderItemId, rating, content, reviewImgName);

		productReviewRepository.updateReview(productReview);
	}

	@Test
	public void deleteReview() throws Exception {
		Long memberId = 1L;
		Long orderItemId = 26L;

		productReviewRepository.deleteReview(memberId, orderItemId);
	}

	@Test
	public void findReviewsByMemberId() throws Exception {
		Long memberId = 1L;

		List<ProductReview> reviewsByMemberId = productReviewRepository.findReviewsByMemberId(memberId);
//		for (ProductReview productReview : reviewsByMemberId) {
//			System.out.println(productReview);
//		}


//		for (ProductReview productReview : reviewsByMemberId) {
//			Gson gson = new Gson();
//			String json = gson.toJson(productReview);
//			System.out.println(json);
//		}

		Gson gson = new Gson();
		String json = gson.toJson(reviewsByMemberId);
		System.out.println(json);
	}

	@Test
	public void findReviewsByProductId() throws Exception {

		Long productId = 81L;

		List<ProductReview> reviewsByProductId = productReviewRepository.findReviewsByProductId(productId);
		for (ProductReview productReview : reviewsByProductId) {
			System.out.println(productReview);
		}
	}

	@Test
	public void getAverageRatingByProductId() throws Exception {
		Long productId = 81L;
		Float rating = productReviewRepository.getAverageRatingByProductId(productId);

		System.out.println(rating);
	}

	@Test
	public void getComposableProductList() throws Exception {
		Long memberId = 1L;
		List<ProductReview> composableProductList = productReviewRepository.getComposableProductList(memberId);

		for (ProductReview productReview : composableProductList) {
			System.out.println(productReview);
		}
	}

	@Test
	public void getStockIdListByOrderItemId() throws Exception {
		Long stockItemId = 41L;

		List<Long> stockList = productReviewRepository.getStockIdListByOrderItemId(stockItemId);

		for (Long stockId : stockList) {
			System.out.println(stockId);
		}
	}

	@Test
	public void searchReview() throws Exception {
//		List<ProductReview> reviewList = productReviewRepository.searchReview(1L, "20230610", "20230728", "도", 6);
//		for (ProductReview productReview : reviewList) {
//			System.out.println(productReview);
//		}
	}
}