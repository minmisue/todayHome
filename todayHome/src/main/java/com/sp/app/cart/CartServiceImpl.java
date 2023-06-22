package com.sp.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sp.app.domain.cart.Cart;

public class CartServiceImpl implements CartService{

	@Autowired
	CartManagementRepository cartManagementRepository;
	
	@Override
	public void createProduct(Cart cart){		
		try {
			
			Integer quantity = cartManagementRepository.checkCartProduct(cart.getMemberId(),cart.getStockId());
			int tot = 0;
			int inputQuantity = cart.getQuantity();
			tot = inputQuantity;
			boolean status = quantity > 0 && quantity != null;
			
			// 이미 상품이 장바구니에 있는경우 -> 현재 수량과 받은 수량을 더해서 설정
			if(status) {
				tot += quantity;	
			}
			
			// 재고 확인
			if(cartManagementRepository.checkQuantity(cart.getStockId(), tot) == 0) {
				return;
			}
			
			// true 면 장바구니에 수량만 변경
			if (status) {
				cartManagementRepository.updateProduct(cart.getCartId(), tot);
				return;
			}
			
			cartManagementRepository.createProduct(cart);
		}catch (RuntimeException e1) {
			throw e1;
		}catch (Exception e) {
		
		}
	}

	@Override
	public void updateProduct(Long cartId, int quantity) {
		try {
			cartManagementRepository.updateProduct(cartId,quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCart(List<Long> cartIdList) {
		try {
			cartManagementRepository.deleteCart(cartIdList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cart> getCartList(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkQuantity(Long stockId, int quantity) {
		try {
			
			if(cartManagementRepository.checkQuantity(stockId,quantity) != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
