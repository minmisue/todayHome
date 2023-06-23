package com.sp.app.cart;

import java.util.List;

import com.sp.app.domain.cart.Cart;

public interface CartService {
	// 장바구니 넣기
	public void createProduct(Cart cart);
	
	// 장바구니 업데이트
	public void updateProduct(Long cartId, int quantity);
	
	// 장바구니 취소
	public void deleteCart(List<Long> cartIdList);
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId);
	
	// 재고체크
	public Boolean checkQuantity(Long stockId, int quantity);
}
