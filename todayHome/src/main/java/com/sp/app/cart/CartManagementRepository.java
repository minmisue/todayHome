package com.sp.app.cart;

import java.util.List;

public interface CartManagementRepository {
	
	// 장바구니 넣기
	public void createProduct(Cart cart);
	
	// 장바구니 업데이트
	public void updateProduct(Cart cart);
	
	// 장바구니 취소
	public void deleteCart(Long productId, Long member_id);
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId);

}
