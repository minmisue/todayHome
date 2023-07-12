package com.sp.app.product.review;

import com.sp.app.domain.product.ProductReview;
import com.sp.app.domain.product.ReviewProduct;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ProductReviewService {

	void createReview(ProductReview productReview) throws Exception;

	void updateReview(ProductReview productReview) throws Exception;

	void deleteReview(Long memberId, Long orderItemId) throws Exception;

	List<ProductReview> findReviewsByMemberId(Long memberId) throws Exception;

	List<ProductReview> findReviewsByProductId(Long productId) throws Exception;

	Float getAverageRatingByProductId(Long productId) throws Exception;

	List<ProductReview> getComposableProductList(Long memberId) throws Exception;

	List<Long> getStockIdListByOrderItemId(Long orderItemId) throws Exception;

	String getReviewImgPath(HttpSession httpSession);

	List<ProductReview> searchReview(Long sellerId, String startDate, String endDate, String keyword, float rating,int offset,int size);

	int getReviewCount(Long productId);
	
	int searchReviewCount(Long sellerId,String startDate,String endDate,String keyword,float rating) throws Exception;
}
