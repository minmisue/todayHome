package com.sp.app.product.review;


import com.sp.app.domain.product.ProductReview;

import java.util.List;

public interface ProductReviewRepository {
	void createReview(ProductReview productReview);

	void editReview(ProductReview productReview);

	void deleteReview(Long memberId, Long reviewId);

	List<ProductReview> findReviewsByMemberId(Long memberId);

	List<ProductReview> findReviewssByProductId(Long productId);
}
