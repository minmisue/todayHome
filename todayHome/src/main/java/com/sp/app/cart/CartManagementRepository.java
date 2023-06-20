package com.sp.app.cart;

import java.util.List;

public interface CartManagementRepository {
	
	// 장바구니 넣기
	public void createProduct(Cart cart) throws Exception;
	
	// 장바구니 업데이트
	public void updateProduct(Long cartId) throws Exception;
	
	// 장바구니 취소
	public void deleteCart(Long cartId) throws Exception;
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId) throws Exception;

}
