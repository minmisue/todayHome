package com.sp.app.product.category;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public List<ProductCategory> getAllCategories() throws Exception {
		return commonDAO.selectList("productCategory.getAllCategories");
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

	@Override
	public List<ProductCategory> getChildCategories(Long parentCategoryId) throws Exception {
		return commonDAO.selectList("productCategory.getChildCategories", parentCategoryId);
	}

	@Override
	public List<ProductCategory> getAllCategoryHierarchy() throws Exception {
		return commonDAO.selectList("productCategory.getAllCategoryHierarchy");
	}
}
