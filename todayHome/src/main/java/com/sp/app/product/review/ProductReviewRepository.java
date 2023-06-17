package hello.servlet.web.product.review;

import hello.servlet.web.domain.ProductReview;

import java.util.List;

public interface ProductReviewRepository {
	void createReview(ProductReview productReview);

	void editReview(ProductReview productReview);

	void deleteReview(Long memberId, Long reviewId);

	List<ProductReview> findReviewsByMemberId(Long memberId);

	List<ProductReview> findReviewssByProductId(Long productId);
}
