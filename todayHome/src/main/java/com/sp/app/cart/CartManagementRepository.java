package com.sp.app.cart;

import java.util.List;

public interface CartManagementRepository {
	
	// 장바구니 넣기
	public void createProduct(Cart cart) throws Exception;
	
	// 장바구니 업데이트
	public void updateProduct(Long cartId,int quantity) throws Exception;
	
	// 장바구니 취소
	public void deleteCart(Long cartId) throws Exception;
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId) throws Exception;
	
	// 장바구니 재고 체크 
	public Integer checkQuantity(Long stockId, int quantity) throws Exception;
	
	// 장바구니에 담겨있는지 확인
	public Integer checkCartProduct(Long memberId, Long productId, Long stockId) throws Exception;

}
