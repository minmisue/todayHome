package com.sp.app.product.mangement;


import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductOption;

import java.util.List;

public interface ProductManagementRepository {

	Product createProduct(Product product);

	Product getProductById(Long productId);

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(Long categoryId);

	List<Product> getProductsByKeyword(String keyword);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

	void addScrapProduct(Long memberId, Long productId);

	void deleteScrapProduct(Long memberId, Long productId);

	void isScrapProduct(Long memberId, Long productId);

	// 수정해야댐
	ProductOption getOptionsById(Long productId);
}
