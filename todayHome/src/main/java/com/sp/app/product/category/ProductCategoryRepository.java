package com.sp.app.product.category;


import com.sp.app.domain.product.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {
	// 모든 카테고리 출력
	List<ProductCategory> getAllCategories();

	// 카테고리 아이디로 카테고리 반환
	ProductCategory getCategoryById(Long categoryId);

	// 하위 카테고리 리스트 반환
	List<ProductCategory> getCategoriesByParentId(Long parentId);

	// 카테고리 생성
	ProductCategory createCategory(ProductCategory productCategory);

	// 카테고리 수정
	ProductCategory updateCategory(Long categoryId, ProductCategory productCategory);

	// 카테고리 삭제
	void deleteCategory(Long categoryId);
}
