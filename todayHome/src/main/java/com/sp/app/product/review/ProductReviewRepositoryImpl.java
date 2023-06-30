package com.sp.app.product.review;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.product.ProductReview;
import com.sp.app.domain.product.ReviewProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductReviewRepositoryImpl implements ProductReviewRepository {

	@Autowired
	CommonDAO commonDAO;

	@Override
	public void createReview(ProductReview productReview) throws Exception {
		commonDAO.insertData("productReview.createReview", productReview);
	}

	@Override
	public void updateReview(ProductReview productReview) throws Exception {
		commonDAO.updateData("productReview.updateReview", productReview);
	}

	@Override
	public void deleteReview(Long memberId, Long orderItemId) throws Exception {
		Map<String, Object> map = new HashMap<>();

		map.put("memberId", memberId);
		map.put("orderItemId", orderItemId);

		commonDAO.deleteData("productReview.deleteReview", map);
	}

	@Override
	public List<ProductReview> findReviewsByMemberId(Long memberId) throws Exception {
		return commonDAO.selectList("productReview.findReviewsByMemberId", memberId);
	}

	@Override
	public List<ProductReview> findReviewsByProductId(Long productId) throws Exception {
		return commonDAO.selectList("productReview.findReviewsByProductId", productId);
	}

	@Override
	public Float getAverageRatingByProductId(Long productId) throws Exception {
		return commonDAO.selectOne("productReview.getAverageRatingByProductId", productId);
	}

	@Override
	public List<ProductReview> getComposableProductList(Long memberId) throws Exception {
		return commonDAO.selectList("productReview.getComposableProductList", memberId);
	}
}
