package com.sp.app.product.management;


import com.sp.app.domain.product.*;

import java.util.List;
import java.util.Map;

public interface ProductManagementRepository {

	void insertProduct(Product product) throws Exception;

	void insertProductImg(Long productId, ProductImg productImg) throws Exception;

	Product getProductById(Long productId) throws Exception;

	List<ProductImg> getProductImgList(Long productId) throws Exception;

	/**
	 * n 번째 보다 크거나 같은 시퀀스를 모두 1씩 증가시킴
	 * @param map      기준 sequence 값, 변경 할 productId
	 */
	void increaseImgSequences(Map<String, Object> map) throws Exception;

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(Long categoryId);

	List<Product> getProductsByKeyword(String keyword);

	void updateProduct(Product product);

	void deleteProduct(Long productId);

	void insertScrapProduct(Long memberId, Long productId) throws Exception;

	void deleteScrapProduct(Long memberId, Long productId) throws Exception;

	int isScrapProduct(Long memberId, Long productId) throws Exception;

	// 수정해야댐
	ProductMainOption getOptionsById(Long productId);

	ProductMainOption getMainOptionByParentId(Long productId, Long parentOptionId) throws Exception;

	List<ProductSubOption> getSubOptionsByMainOptionId(Long mainOptionId) throws Exception;

	List<ProductStock> getStockBySubOptionId(Long subOptionId) throws Exception;

	List<Product> findProductByCategory(Long categoryId) throws Exception;

	Long getMainOptionSeq() throws Exception;

	Long getProductSeq() throws Exception;

	int getMainOptionCnt(Long productId) throws Exception;

	List<OptionMap> getOptionMapByStockId(Long stockId) throws Exception;

	void insertMainOption(ProductMainOption productMainOption) throws Exception;

	void insertSubOption(ProductSubOption productSubOption) throws Exception;

	void insertStock(ProductStock productStock) throws Exception;

	// stock 리스트 반환
	List<ProductStock> getStockListByProductId(Long productId) throws Exception;

	// stock 수정

	// stock 삭제

	// 재고 변경

}
