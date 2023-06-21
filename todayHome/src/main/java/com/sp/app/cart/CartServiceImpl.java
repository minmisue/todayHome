package com.sp.app.cart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImpl implements CartService{

	@Autowired
	CartManagementRepository cartManagementRepository;
	
	@Override
	public void createProduct(Cart cart){		
		try {
			
			if(cartManagementRepository.checkCartProduct(cart.getMemberId(),cart.getProductId(),cart.getStockId()) != 0) {
				// null이 아니라는거는 이미 담겨져있다는 뜻
				return;
			}
			
			cartManagementRepository.createProduct(cart);
		} catch (Exception e) {
		
		}
	}

	@Override
	public void updateProduct(Map<String, Object> map) {
		try {
			
			Long cartId = (Long)map.get("cartId");
			Integer quantity = (Integer)map.get("quantity");

			
			cartManagementRepository.updateProduct(cartId,quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCart(Long cartId) {
		try {
			cartManagementRepository.deleteCart(cartId);
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
	public Boolean checkQuantity(Map<String, Object> map) {
		try {
			
			Long stockId = (Long)map.get("stockId");
			int quantity = (Integer)map.get("quantity");
			
			if(cartManagementRepository.checkQuantity(stockId,quantity) != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
