package com.sp.app.product.management;


import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductOption;

import java.util.List;
import java.util.Map;

public interface ProductManagementRepository {

	void createProduct(Product product) throws Exception;

	void insertProductImg(Map<String, Object> imgMap) throws Exception;

	void insertContentImg(Map<String, Object> imgMap) throws Exception;

	Product getProductById(Long productId) throws Exception;

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(Long categoryId);

	List<Product> getProductsByKeyword(String keyword);

	void updateProduct(Product product);

	void deleteProduct(Long productId);

	void addScrapProduct(Long memberId, Long productId);

	void deleteScrapProduct(Long memberId, Long productId);

	boolean isScrapProduct(Long memberId, Long productId);

	// 수정해야댐
	ProductOption getOptionsById(Long productId);
}
