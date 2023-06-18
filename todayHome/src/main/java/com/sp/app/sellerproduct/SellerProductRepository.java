package com.sp.app.sellerproduct;

import java.util.List;

public interface SellerProductRepository {
	//전체 상품 리스트 출력
	List<SellerProduct> getAllProducts();	
	
	//가격으로 상품 리스트 출력
	List<SellerProduct> getProductsByPrice(String type, String keyword, String sort, String category);	

	
}
