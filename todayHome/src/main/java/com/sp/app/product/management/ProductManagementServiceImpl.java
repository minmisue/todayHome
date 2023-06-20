package com.sp.app.product.management;

import com.sp.app.domain.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {

	@Autowired
	ProductManagementRepository productManagementRepository;

	/*
		상품 등록
		상품 인서트 + 상품 이미지 등록 + 상품 컨텐츠 이미지 등록 (상세설명) + 옵션 등록을 한번에 한다.
	 */
	@Override
	public void createProduct(Product product) throws Exception {
		productManagementRepository.insertProduct(product);

		List<String> productImgList = product.getProductImgList();
		List<String> contentImgList = product.getContentImgList();

		// 현재 productId 가져옴 (임시)
		Long productId = 61L;

		int sequence = 0;
		// 상품 이미지 등록
		for (String imgName : productImgList) {
			Map<String, Object> productImgMap = new HashMap<>();
			productImgMap.put("productId", productId);
			productImgMap.put("imgName", imgName);
			productImgMap.put("sequence", sequence);
			productImgMap.put("type", 0);
			productManagementRepository.insertProductImg(productImgMap);
			sequence++;
		}

		sequence = 0;
		// 상품 콘텐츠 이미지 등록
		for (String imgName : contentImgList) {
			Map<String, Object> contentImgMap = new HashMap<>();
			contentImgMap.put("productId", productId);
			contentImgMap.put("imgName", imgName);
			contentImgMap.put("sequence", sequence);
			contentImgMap.put("type", 1);
			productManagementRepository.insertProductImg(contentImgMap);
			sequence++;
		}

		// 상품 옵션 등록

	}

	@Override
	public void insertProductImg(Map<String, Object> imgMap) throws Exception {

	}

	@Override
	public Product getProductById(Long productId) throws Exception {
		return null;
	}

	@Override
	public List<ProductImg> getProductImgList(Long productId) throws Exception {
		return null;
	}

	@Override
	public void increaseImgSequences(Map<String, Object> map) throws Exception {

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
	public void insertScrapProduct(Long memberId, Long productId) throws Exception {

	}

	@Override
	public void deleteScrapProduct(Long memberId, Long productId) throws Exception {

	}

	@Override
	public int isScrapProduct(Long memberId, Long productId) throws Exception {
		return 0;
	}

	@Override
	public ProductMainOption getOptionsById(Long productId) {
		return null;
	}

	@Override
	public ProductMainOption getMainOptionByParentId(Long productId, Long parentOptionId) throws Exception {
		return null;
	}

	@Override
	public List<ProductSubOption> getSubOptionsByMainOptionId(Long mainOptionId) throws Exception {
		return null;
	}

	@Override
	public List<ProductStock> getStockBySubOptionId(Long subOptionId) throws Exception {
		return null;
	}

	@Override
	public List<Product> findProductByCategory(Long categoryId) throws Exception {
		return null;
	}
}
