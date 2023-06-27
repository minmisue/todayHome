package com.sp.app.cart;

import java.util.List;
import java.util.Map;

import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;

public interface CartService {
	// 장바구니 넣기
	public void createCart(Cart cart) throws Exception;
		
	// 장바구니 취소
	public void deleteCart(Long cartId);
	
	// 장바구니 취소 
	public void deleteStock(Long stockId);
	
	// 회원 별 장바구니 리스트
	public List<Cart> getCartList(Long memberId);
	
	// 재고체크
	public Boolean checkQuantity(Long stockId, Long quantity);
	
	// 장바구니에 담긴 상품의 옵션 아이디
	public List<CartOptionMap> getStockId(Long cartId);
	
	// AJAX - 수량 업데이트 + 재고 확인
	public void checkQuantityUpdate(Map<String, Object> map);
	
	public Long selectStockPrice(Long stockId);
}
