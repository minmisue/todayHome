package com.sp.app.product.review;

import com.sp.app.domain.product.ProductReview;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.domain.product.ReviewProduct;
import com.sp.app.product.management.ProductManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

	@Autowired
	ProductReviewRepository productReviewRepository;

	@Autowired
	ProductManagementRepository productManagementRepository;

	@Override
	public void createReview(ProductReview productReview) throws Exception {
		productReviewRepository.createReview(productReview);
	}

	@Override
	public void updateReview(ProductReview productReview) throws Exception {
		productReviewRepository.updateReview(productReview);
	}

	@Override
	public void deleteReview(Long memberId, Long orderItemId) throws Exception {
		productReviewRepository.deleteReview(memberId, orderItemId);
	}

	@Override
	public List<ProductReview> findReviewsByMemberId(Long memberId) throws Exception {
		List<ProductReview> productReviews = productReviewRepository.findReviewsByMemberId(memberId);
		return generateStockStringToReviewList(productReviews);
	}



	@Override
	public List<ProductReview> findReviewsByProductId(Long productId) throws Exception {
		List<ProductReview> productReviews = productReviewRepository.findReviewsByProductId(productId);
		return generateStockStringToReviewList(productReviews);
	}

	@Override
	public Float getAverageRatingByProductId(Long productId) throws Exception {
		return productReviewRepository.getAverageRatingByProductId(productId);
	}

	@Override
	public List<ProductReview> getComposableProductList(Long memberId) throws Exception {
		List<ProductReview> productReviews = productReviewRepository.getComposableProductList(memberId);
		return generateStockStringToReviewList(productReviews);
	}

	private List<ProductReview> generateStockStringToReviewList(List<ProductReview> productReviews) throws Exception {
		for (ProductReview productReview : productReviews) {
			Long stockId = productReview.getStockId();
			ProductStock stock = productManagementRepository.getStockByStockId(stockId);

			String stockString = stock.getMainOptionName1() + ": " + stock.getSubOptionName1();
			if (stock.getSubOptionId2() != null) {
				stockString += " / " + stock.getMainOptionName2() + ": " + stock.getSubOptionName2();
			}
			productReview.setStockString(stockString);
		}

		return productReviews;
	}
}
