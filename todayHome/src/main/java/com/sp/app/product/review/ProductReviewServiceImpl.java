package com.sp.app.product.review;

import com.sp.app.domain.product.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

	@Autowired
	ProductReviewRepository productReviewRepository;

	@Override
	public void createReview(ProductReview productReview) throws Exception {
		productReviewRepository.createReview(productReview);
	}

	@Override
	public void updateReview(ProductReview productReview) throws Exception {
		productReviewRepository.updateReview(productReview);
	}

	@Override
	public void deleteReview(Long memberId, Long reviewId) throws Exception {
		productReviewRepository.deleteReview(memberId, reviewId);
	}

	@Override
	public List<ProductReview> findReviewsByMemberId(Long memberId) throws Exception {
		return productReviewRepository.findReviewsByMemberId(memberId);
	}

	@Override
	public List<ProductReview> findReviewsByProductId(Long productId) throws Exception {
		return productReviewRepository.findReviewsByProductId(productId);
	}

	@Override
	public Float getAverageRatingByProductId(Long productId) throws Exception {
		return productReviewRepository.getAverageRatingByProductId(productId);
	}
}
