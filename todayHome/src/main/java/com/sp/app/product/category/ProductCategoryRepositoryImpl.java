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
	public void createCategory(ProductCategory productCategory) throws Exception {
		commonDAO.selectOne("productCategory.createCategory", productCategory);
	}

	@Override
	public void updateCategory(ProductCategory productCategory) throws Exception {
		commonDAO.updateData("productCategory.updateCategory", productCategory);
	}

	@Override
	public void deleteCategory(Long categoryId) throws Exception {
		commonDAO.updateData("productCategory.deleteCategory", categoryId);
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
