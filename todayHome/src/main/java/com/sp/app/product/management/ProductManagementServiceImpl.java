package com.sp.app.product.management;

import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
		productManagementRepository.createProduct(product);

		List<String> productImgList = product.getProductImgList();
		List<String> contentImgList = product.getContentImgList();

		// 현재 productId 가져옴 (임시)
		Long productId = 61L;

		// 상품 이미지 등록
		for (String imgName : productImgList) {
			Map<String, Object> productImgMap = new HashMap<>();
			productImgMap.put("productId", productId);
			productImgMap.put("imgName", imgName);
			productManagementRepository.insertProductImg(productImgMap);
		}

		// 상품 콘텐츠 이미지 등록
		for (String imgName : contentImgList) {
			Map<String, Object> contentImgMap = new HashMap<>();
			contentImgMap.put("productId", productId);
			contentImgMap.put("imgName", imgName);
			productManagementRepository.insertContentImg(contentImgMap);
		}

		// 상품 옵션 등록

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
	public void updateProduct(Product product) throws Exception {


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
