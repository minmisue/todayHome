package com.sp.app.product.category;

import com.sp.app.domain.product.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

	@Override
	public List<ProductCategory> getAllCategories() {
		return null;
	}

	@Override
	public ProductCategory getCategoryById(Long categoryId) {
		return null;
	}

	@Override
	public List<ProductCategory> getCategoriesByParentId(Long parentId) {
		return null;
	}

	@Override
	public ProductCategory createCategory(ProductCategory productCategory) {
		return null;
	}

	@Override
	public ProductCategory updateCategory(Long categoryId, ProductCategory productCategory) {
		return null;
	}

	@Override
	public void deleteCategory(Long categoryId) {

	}
}
