package com.sp.app.cart;

import java.util.List;
import java.util.Map;

public interface CartService {
	// 장바구니 넣기
	public void createProduct(Cart cart);
	
	// 장바구니 업데이트
	public void updateProduct(Map<String, Object> map);
	
	// 장바구니 취소
	public void deleteCart(Long cartId);
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId);
	
	// 재고체크
	public Boolean checkQuantity(Map<String, Object> map);
}
