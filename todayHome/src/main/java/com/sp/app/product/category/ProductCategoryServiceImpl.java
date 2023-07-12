package com.sp.app.product.category;

import com.sp.app.domain.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> getAllCategories() throws Exception {
		return productCategoryRepository.getAllCategories();
	}

	@Override
	public ProductCategory getCategoryById(Long categoryId) {
		try {
			return productCategoryRepository.getCategoryById(categoryId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductCategory> getCategoriesByParentId(Long parentId) {
		return null;
	}

	@Override
	public void createCategory(ProductCategory productCategory) {
		try {
			productCategoryRepository.createCategory(productCategory);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCategory(ProductCategory productCategory) {
		try {
			productCategoryRepository.updateCategory(productCategory);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCategory(Long categoryId) {
		try {
			productCategoryRepository.deleteCategory(categoryId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductCategory> getChildCategories(Long parentCategoryId) {
		try {
			return productCategoryRepository.getChildCategories(parentCategoryId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductCategory> getAllCategoryHierarchy(Long categoryId) throws Exception {
		return productCategoryRepository.getAllCategoryHierarchy(categoryId);
	}

	@Override
	public List<ProductCategory> fetchCategory(Long parentCategoryId) throws Exception {
		List<ProductCategory> subcategories = productCategoryRepository.getChildCategories(parentCategoryId);
		for (ProductCategory subcategory : subcategories) {
			List<ProductCategory> childSubcategories = fetchCategory(subcategory.getProductCategoryId());
			subcategory.setSubCategoryList(childSubcategories);
		}
		return subcategories;
	}

	@Override
	public void printCategory(Long parentCategoryId) throws Exception {
	}

	@Override
	public void printCategoryWithSubcategories(ProductCategory category, int depth) {
		StringBuilder indent = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			indent.append("  ");
		}

		System.out.println(indent + category.toString() + " (Depth: " + depth + ")");


		List<ProductCategory> subcategories = category.getSubCategoryList();
		if (subcategories != null && !subcategories.isEmpty()) {
			for (ProductCategory subcategory : subcategories) {
				printCategoryWithSubcategories(subcategory, depth + 1);
			}
		}
	}

	@Override
	public ProductCategory getTopLevelCategory(Long categoryId) {
		try {
			return productCategoryRepository.getTopLevelCategory(categoryId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
