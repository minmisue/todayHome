package com.sp.app.product.mangement;

import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductOption;

import java.util.List;

public class ProductManagementRepositoryImpl implements ProductManagementRepository{
	@Override
	public Product createProduct(Product product) {
		return null;
	}

	@Override
	public Product getProductById(Long productId) {
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public List<Product> getProductsByCategory(Long categoryId) {
		return null;
	}

	@Override
	public List<Product> getProductsByKeyword(String keyword) {
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		return null;
	}

	@Override
	public void deleteProduct(Long productId) {

	}

	@Override
	public void addScrapProduct(Long memberId, Long productId) {

	}

	@Override
	public void deleteScrapProduct(Long memberId, Long productId) {

	}

	@Override
	public void isScrapProduct(Long memberId, Long productId) {

	}

	@Override
	public ProductOption getOptionsById(Long productId) {
		return null;
	}
}
