package com.sp.app.product.management;

import com.sp.app.domain.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

		// 현재 productId 가져옴
		Long productId = product.getProductId();

		List<ProductImg> productImgList = product.getProductImgList();
		List<ProductImg> contentImgList = product.getContentImgList();

		int sequence = 0;

		// 상품 이미지 등록
		for (ProductImg productImg : productImgList) {
			productImg.setSequence(sequence);
			productManagementRepository.insertProductImg(productId, productImg);
			sequence++;
		}

		sequence = 0;
		// 상품 콘텐츠 이미지 등록
		for (ProductImg productImg : contentImgList) {
			productManagementRepository.insertProductImg(productId, productImg);
			sequence++;
		}

		// 상품 옵션 등록
		List<ProductMainOption> productMainOptions = new ArrayList<>();

		// 서브 옵션 설정
		List<ProductSubOption> productSubOptions = new ArrayList<>();
		productSubOptions.add(new ProductSubOption("S"));
		productSubOptions.add(new ProductSubOption("M"));
		productSubOptions.add(new ProductSubOption("L"));

		ProductMainOption mainOption1 = new ProductMainOption("사이즈", productId);
		mainOption1.setSubOptions(productSubOptions);

		productMainOptions.add(mainOption1);


		List<ProductSubOption> productSubOptions2 = new ArrayList<>();
		productSubOptions2.add(new ProductSubOption("빨강"));
		productSubOptions2.add(new ProductSubOption("파랑"));
		productSubOptions2.add(new ProductSubOption("노랑"));

		ProductMainOption mainOption2 = new ProductMainOption("색상", productId);
		mainOption2.setSubOptions(productSubOptions2);
		productMainOptions.add(mainOption2);

		List<List<Long>> subOptionIdListList = new ArrayList<>();

		Long parentOptionId = null;
		for (ProductMainOption productMainOption : productMainOptions) {
			// 메인옵션 등록
			productMainOption.setParentOptionId(parentOptionId);
			productManagementRepository.insertMainOption(productMainOption);
			parentOptionId = productMainOption.getMainOptionId();

			List<ProductSubOption> subOptions = productMainOption.getSubOptions();

			List<Long> subOptionIdList = new ArrayList<>();

			// 서브옵션 등록
			for (ProductSubOption subOption : subOptions) {
				subOption.setMainOptionId(parentOptionId);
				productManagementRepository.insertSubOption(subOption);
				Long subOptionId = subOption.getSubOptionId();

				subOptionIdList.add(subOptionId);
			}

			subOptionIdListList.add(subOptionIdList);
		}

		// 재고 등록을 위한 가격, 수량 배열
		List<ProductStock> stockList = new ArrayList<>();
		sampleStockList(stockList);

		// 경우의 수 조합
		List<List<Long>> lists = combineSubOptions(subOptionIdListList);

		// stock 매핑
		int seq = 0;
		for (List<Long> list : lists) {
			ProductStock stock = stockList.get(seq);

			System.out.println("list = " + list);
			System.out.println("list.get(0) = " + list.get(0));
			System.out.println("list.get(1) = " + list.get(1));
			System.out.println(stock);

			stock.setSubOptionId1(list.get(0));
			stock.setSubOptionId2(list.get(1));

			System.out.println("after : " + stock);

			seq++;

			System.out.println(stock);
			productManagementRepository.insertStock(stock);
		}
	}

	private static List<List<Long>> combineSubOptions(List<List<Long>> subOptionIdListList) {
		int totalSize = 1;
		for (List<Long> subOptions : subOptionIdListList) {
			totalSize *= subOptions.size();
		}

		List<List<Long>> resultList = new ArrayList<>();

		for (int i = 0; i < totalSize; i++) {
			List<Long> result = new ArrayList<>();
			int temp = i;

			for (List<Long> subOptionList : subOptionIdListList) {
				int index = temp % subOptionList.size();
				result.add(subOptionList.get(index));
				temp /= subOptionList.size();
			}

			resultList.add(result);
		}

		return resultList;
	}


	private static void sampleStockList(List<ProductStock> stockList) {
		stockList.add(new ProductStock(1200, 39));
		stockList.add(new ProductStock(1500, 88));
		stockList.add(new ProductStock(2200, 20));
		stockList.add(new ProductStock(3200, 13));
		stockList.add(new ProductStock(2100, 2));
		stockList.add(new ProductStock(5200, 7));
		stockList.add(new ProductStock(2200, 20));
		stockList.add(new ProductStock(1200, 33));
		stockList.add(new ProductStock(600, 11));
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
