package com.sp.app.product.management;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductImg;
import com.sp.app.domain.product.ProductOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductManagementRepositoryImpl implements ProductManagementRepository{

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public void createProduct(Product product) throws Exception {
		commonDAO.insertData("productManagement.insertProduct", product);
	}

	@Override
	public void insertProductImg(Map<String, Object> imgMap) throws Exception {
		commonDAO.insertData("productManagement.insertProductImg", imgMap);
	}

	@Override
	public Product getProductById(Long productId) throws Exception {
		return commonDAO.selectOne("productManagement.getProduct", productId);
	}

	@Override
	public List<ProductImg> getProductImgList(Long productId) throws Exception {
		return commonDAO.selectList("productManagement.getProductImgList", productId);
	}

	@Override
	public void increaseImgSequences(Map<String, Object> map) throws Exception {
		commonDAO.updateData("productManagement.increaseImgSequences", map);
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
	public void updateProduct(Product product) {

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
	public boolean isScrapProduct(Long memberId, Long productId) {
		return false;
	}

	@Override
	public ProductOption getOptionsById(Long productId) {
		return null;
	}
}
