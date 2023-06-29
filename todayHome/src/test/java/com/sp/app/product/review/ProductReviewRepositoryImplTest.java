package com.sp.app.product.review;

import com.sp.app.domain.member.SimpleMember;
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
public class ProductReviewRepositoryImplTest {

	@Autowired
	ProductReviewRepository productReviewRepository;

	@Test
	public void createReview() throws Exception {
		Long memberId = 1L;
		Long productId = 221L;
		Float rating = 4.5f;
		String content = "리뷰 테스트 2";
		String reviewImgName = "리뷰 이미지2";

		ProductReview productReview = new ProductReview(memberId, productId, rating, content, reviewImgName);

		productReviewRepository.createReview(productReview);
	}

	@Test
	public void updateReview() throws Exception {
		Long reviewId = 13L;
		Float rating = 2.5f;
		String content = "리뷰 테스트 1 수정";
		String reviewImgName = "리뷰 이미지 수정";

		ProductReview productReview = new ProductReview(reviewId, rating, content, reviewImgName);

		productReviewRepository.updateReview(productReview);
	}

	@Test
	public void deleteReview() throws Exception {
		Long memberId = 1L;
		Long reviewId = 13L;

		productReviewRepository.deleteReview(memberId,reviewId);
	}

	@Test
	public void findReviewsByMemberId() throws Exception {
		Long memberId = 1L;

		List<ProductReview> reviewsByMemberId = productReviewRepository.findReviewsByMemberId(memberId);
		for (ProductReview productReview : reviewsByMemberId) {
			System.out.println(productReview);
		}
	}

	@Test
	public void findReviewsByProductId() throws Exception {

		Long productId = 221L;

		List<ProductReview> reviewsByProductId = productReviewRepository.findReviewsByProductId(productId);
		for (ProductReview productReview : reviewsByProductId) {
			System.out.println(productReview);
		}
	}

	@Test
	public void getAverageRatingByProductId() throws Exception {
		Long productId = 221L;
		Float rating = productReviewRepository.getAverageRatingByProductId(productId);

		System.out.println(rating);
	}
}