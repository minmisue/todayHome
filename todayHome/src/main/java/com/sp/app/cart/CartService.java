package com.sp.app.cart;

import java.util.List;

import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;

public interface CartService {
	// 장바구니 넣기
	public void createCart(Cart cart) throws Exception;
	
	// 장바구니 업데이트
	//public void updateCartQuantity(Long cartId, int quantity);
	
	// 장바구니 취소
	public void deleteCart(List<Long> cartIdList);
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId);
	
	// 재고체크
	public Boolean checkQuantity(Long stockId, Long quantity);
	
	// 장바구니에 담긴 상품의 옵션 아이디
	public List<CartOptionMap> getStockId(Long cartId);
	
	public Long selectStockPrice(Long stockId);
}
