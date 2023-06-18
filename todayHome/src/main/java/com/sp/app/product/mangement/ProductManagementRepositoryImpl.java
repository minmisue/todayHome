package com.sp.app.product.mangement;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductOption;
import lombok.extern.slf4j.Slf4j;
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
		commonDAO.insertData("management.insertProduct", product);
	}

	@Override
	public void insertProductImg(Map<String, Object> imgMap) throws Exception {
		commonDAO.insertData("management.insertProductImg", imgMap);
	}

	@Override
	public void insertContentImg(Map<String, Object> imgMap) throws Exception {
		commonDAO.insertData("management.insertContentImg", imgMap);
	}

	@Override
	public Product getProductById(Long productId) throws Exception {
		return commonDAO.selectOne("management.getProduct", productId);
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
