package com.sp.app.product.management;

import com.sp.app.domain.product.*;

import java.util.List;

public interface ProductManagementService {

	void createProduct(Product product, List<String> mainOptionName, String[][] subOptionName, List<Integer> stockPriceList, List<Integer> stockQuantityList);

	void insertProductImg(Long productId, ProductImg productImg);

	Product getProductById(Long productId);

	List<ProductImg> getProductImgList(Long productId);

	/**
	 * n 번째 보다 크거나 같은 시퀀스를 모두 1씩 증가시킴
	 * 기준 sequence 값, 변경 할 productId
	 */
	void increaseImgSequences(Long productId, int sequence) ;

	List<ProductForList> getAllProducts() throws Exception;

	List<ProductForList> getAllProductsLimit();

	List<ProductForList> getProductsByCategoryId(Long categoryId);

	List<Product> getProductsByCategory(Long categoryId);

	void updateProduct(Product product);

	void deleteProduct(Long productId);

	void scrapProduct(Long memberId, Long productId) throws Exception;

	boolean isScrapProduct(Long memberId, Long productId) ;

	int scrapCnt(Long productId);

	int scrapCntByMemberId(Long memberId);


	// 수정해야댐
	ProductMainOption getOptionsById(Long productId);

	ProductMainOption getMainOptionByParentId(Long productId, Long parentOptionId) ;

	List<ProductSubOption> getSubOptionsByMainOptionId(Long mainOptionId) ;

	List<ProductStock> getStockBySubOptionId(Long subOptionId) ;

	List<Product> findProductByCategory(Long categoryId) ;

	Long getMainOptionSeq() ;

	Long getProductSeq() ;

	int getMainOptionCnt(Long productId) ;

	List<OptionMap> getOptionMapByStockId(Long stockId) ;

	void insertMainOption(ProductMainOption productMainOption) ;

	void insertSubOption(ProductSubOption productSubOption) ;

	void insertStock(ProductStock productStock) ;

	// stock 리스트 반환
	List<ProductStock> getStockListByProductId(Long productId);

	List<ProductMainOption> getMainOptionListByProductId(Long productId);

	ProductStock getStockByStockId(Long stockId);

	void updateStockQuantity(Long stockId, int quantity);

	int getQuantityByStockId(Long stockId);

	void deleteProductImg(Long productId, int type);

	List<ProductForList> getProductsByKeyword(String keyword, String sort,int offset,int size,String startDate, String endDate) throws Exception;
	
	List<ProductForList> searchProductBySellerId(Long sellerId, String keyword, String sort,int offset, int size,String startDate, String endDate);
	
	boolean checkProductName(String productName);

	List<ProductForList> getScrapProductList(Long memberId);

	List<ProductForList> getProductsByJustKeyword(String keyword);

	List<ProductForList> getBestProduct();

	int countProductsByKeyword(String keyword,String startDate, String endDate) throws Exception;
	
	int countProductBySellerId(Long sellerId,String keyword,String startDate, String endDate) throws Exception;	
}
