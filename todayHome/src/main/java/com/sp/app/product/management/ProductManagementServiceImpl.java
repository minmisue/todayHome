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
	public void createProduct(Product product, List<String> mainOptionName,
	                          String[][] subOptionName, List<Integer> stockPriceList,
	                          List<Integer> stockQuantityList) {
		try {

			productManagementRepository.insertProduct(product);

			// 현재 productId 가져옴
			Long productId = product.getProductId();

//			List<ProductImg> productImgList = product.getProductImgList();
//			List<ProductImg> contentImgList = product.getContentImgList();
//
//			insertExampleImgData(productImgList, contentImgList);
//
//			// 상품 이미지 순서 변수
//			int sequence = 0;
//
//			// 상품 이미지 등록
//			for (ProductImg productImg : productImgList) {
//				productImg.setSequence(sequence);
//				productManagementRepository.insertProductImg(productId, productImg);
//				sequence++;
//			}
//
//			sequence = 0;
//			// 상품 콘텐츠 이미지 등록
//			for (ProductImg productImg : contentImgList) {
//				productManagementRepository.insertProductImg(productId, productImg);
//				sequence++;
//			}

			// 상품 옵션 등록
			List<ProductMainOption> productMainOptions = new ArrayList<>();

			// 서브 옵션 설정


			for (int i = 0; i < mainOptionName.size(); i++) {
				String[] currentSubOption = subOptionName[i];
				List<ProductSubOption> productSubOptions = new ArrayList<>();
				for (String s : currentSubOption) {
					productSubOptions.add(new ProductSubOption(s));
				}
				ProductMainOption mainOption = new ProductMainOption(mainOptionName.get(i), productId);
				mainOption.setSubOptions(productSubOptions);
				productMainOptions.add(mainOption);
			}


//			productSubOptions.add(new ProductSubOption("S"));
//			productSubOptions.add(new ProductSubOption("M"));
//			productSubOptions.add(new ProductSubOption("L"));

//			ProductMainOption mainOption1 = new ProductMainOption("사이즈", productId);
//			mainOption1.setSubOptions(productSubOptions);

//			productMainOptions.add(mainOption1);


//			List<ProductSubOption> productSubOptions2 = new ArrayList<>();
//			productSubOptions2.add(new ProductSubOption("빨강"));
//			productSubOptions2.add(new ProductSubOption("파랑"));
//			productSubOptions2.add(new ProductSubOption("노랑"));

//			ProductMainOption mainOption2 = new ProductMainOption("색상", productId);
//			mainOption2.setSubOptions(productSubOptions2);
//			productMainOptions.add(mainOption2);

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
			List<ProductStock> stockList = createStockList(stockPriceList, stockQuantityList);

			// 경우의 수 조합
			List<List<Long>> lists = combineSubOptions(subOptionIdListList);

			// stock 매핑
			int seq = 0;
			for (List<Long> list : lists) {
				ProductStock stock = stockList.get(seq);

				System.out.println("list = " + list);
				System.out.println(stock);

				stock.setSubOptionId1(list.get(0));
				stock.setSubOptionId2(list.get(1));

				System.out.println("after : " + stock);

				seq++;

				System.out.println(stock);
				productManagementRepository.insertStock(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<List<Long>> combineSubOptions(List<List<Long>> subOptionIdListList) {
		int totalSize = 1;
		int subOptionCount = subOptionIdListList.size();

		// 각 하위 옵션 리스트의 길이를 저장할 배열
		int[] subOptionLengths = new int[subOptionCount];

		for (int i = 0; i < subOptionCount; i++) {
			List<Long> subOptionList = subOptionIdListList.get(i);
			totalSize *= subOptionList.size();
			subOptionLengths[i] = subOptionList.size();
		}

		List<List<Long>> resultList = new ArrayList<>();

		for (int i = 0; i < totalSize; i++) {
			List<Long> result = new ArrayList<>();
			int temp = i;

			for (int j = 0; j < subOptionCount; j++) {
				List<Long> subOptionList = subOptionIdListList.get(j);
				int index = temp % subOptionLengths[j];
				result.add(subOptionList.get(index));
				temp /= subOptionLengths[j];
			}

			resultList.add(result);
		}

		// 결과 리스트를 왼쪽에서부터 오름차순으로 정렬
		resultList.sort((a, b) -> {
			for (int i = 0; i < subOptionCount; i++) {
				if (!a.get(i).equals(b.get(i))) {
					return a.get(i).compareTo(b.get(i));
				}
			}
			return 0;
		});

		return resultList;
	}


	private static void insertExampleImgData(List<ProductImg> productImgList, List<ProductImg> contentImgList) {
		// 상품 이미지 임시 데이터
		productImgList = new ArrayList<>();
		productImgList.add(new ProductImg("123213", 0));
		productImgList.add(new ProductImg("6453213", 0));
		productImgList.add(new ProductImg("523113", 0));
		productImgList.add(new ProductImg("23413", 0));

		// 상품 상세 이미지 임시 데이터
		contentImgList = new ArrayList<>();
		contentImgList.add(new ProductImg("51234", 1));
		contentImgList.add(new ProductImg("6234", 1));
		contentImgList.add(new ProductImg("11234", 1));
		contentImgList.add(new ProductImg("51234", 1));
		contentImgList.add(new ProductImg("21234", 1));
		contentImgList.add(new ProductImg("31234", 1));
	}



	private static List<ProductStock> createStockList(List<Integer> stockPriceList, List<Integer> stockQuantityList) {
		List<ProductStock> result = new ArrayList<>();
		Iterator<Integer> stockPriceIter = stockPriceList.iterator();
		Iterator<Integer> stockQuantityIter = stockQuantityList.iterator();
		while (stockPriceIter.hasNext()) {
			result.add(new ProductStock(stockPriceIter.next(), stockQuantityIter.next()));
		}

		return result;
	}

	@Override
	public void insertProductImg(Long productId, ProductImg productImg) {
		try {
			productManagementRepository.insertProductImg(productId, productImg);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Product getProductById(Long productId) {
		try {
			return productManagementRepository.getProductById(productId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductImg> getProductImgList(Long productId) {
		try {
			return productManagementRepository.getProductImgList(productId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void increaseImgSequences(Long productId, int sequence)  {
		try {
			productManagementRepository.increaseImgSequences(productId, sequence);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productManagementRepository.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCategory(Long categoryId) {
		return productManagementRepository.getProductsByCategory(categoryId);
	}

	@Override
	public List<Product> getProductsByKeyword(String keyword) {
		return productManagementRepository.getProductsByKeyword(keyword);
	}

	@Override
	public void updateProduct(Product product) {
		productManagementRepository.updateProduct(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		productManagementRepository.deleteProduct(productId);
	}

	@Override
	public void scrapProduct(Long memberId, Long productId) throws Exception {
		try {
			int isScrap = productManagementRepository.isScrapProduct(memberId, productId);
			if (isScrap == 0) {
				// 스크랩이 안되어있는 경우 -> 스크랩
				productManagementRepository.insertScrapProduct(memberId, productId);
			} else {
				productManagementRepository.deleteScrapProduct(memberId, productId);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean isScrapProduct(Long memberId, Long productId)  {
		try {
			int isScrap = productManagementRepository.isScrapProduct(memberId, productId);

			return isScrap == 1;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ProductMainOption getOptionsById(Long productId) {
		return productManagementRepository.getOptionsById(productId);
	}

	@Override
	public ProductMainOption getMainOptionByParentId(Long productId, Long parentOptionId)  {
		try {
			return productManagementRepository.getMainOptionByParentId(productId, parentOptionId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductSubOption> getSubOptionsByMainOptionId(Long mainOptionId)  {
		try {
			return productManagementRepository.getSubOptionsByMainOptionId(mainOptionId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductStock> getStockBySubOptionId(Long subOptionId)  {
		try {
			return productManagementRepository.getStockBySubOptionId(subOptionId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findProductByCategory(Long categoryId)  {
		try {
			return productManagementRepository.findProductByCategory(categoryId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Long getMainOptionSeq()  {
		try {
			return productManagementRepository.getMainOptionSeq();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Long getProductSeq()  {
		try {
			return productManagementRepository.getProductSeq();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getMainOptionCnt(Long productId)  {
		try {
			return productManagementRepository.getMainOptionCnt(productId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<OptionMap> getOptionMapByStockId(Long stockId)  {
		try {
			return productManagementRepository.getOptionMapByStockId(stockId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertMainOption(ProductMainOption productMainOption)  {
		try {
			productManagementRepository.insertMainOption(productMainOption);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertSubOption(ProductSubOption productSubOption)  {
		try {
			productManagementRepository.insertSubOption(productSubOption);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertStock(ProductStock productStock)  {
		try {
			productManagementRepository.insertStock(productStock);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductStock> getStockListByProductId(Long productId) {
		try {
			return productManagementRepository.getStockListByProductId(productId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ProductMainOption> getMainOptionListByProductId(Long productId) {
		List<ProductMainOption> productMainOptions = new ArrayList<>();

		try {
			Long parentOptionId = null;
			while (true) {
				ProductMainOption productMainOption = productManagementRepository.getMainOptionByParentId(productId, parentOptionId);

				if (productMainOption == null) {
					break;
				}
				parentOptionId = productMainOption.getMainOptionId();
				List<ProductSubOption> subOptions = productManagementRepository.getSubOptionsByMainOptionId(parentOptionId);
				productMainOption.setSubOptions(subOptions);

				productMainOptions.add(productMainOption);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return productMainOptions;
	}

	@Override
	public ProductStock getStockByStockId(Long stockId) {
		try {
			return productManagementRepository.getStockByStockId(stockId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateStockQuantity(Long stockId, int quantity) {
		try {
			productManagementRepository.updateStockQuantity(stockId, quantity);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getQuantityByStockId(Long stockId) {
		try {
			return productManagementRepository.getQuantityByStockId(stockId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
