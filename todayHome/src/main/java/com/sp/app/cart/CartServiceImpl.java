package com.sp.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.cart.Stock;
import com.sp.app.product.management.ProductManagementRepository;


@Service("cart.cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	CartManagementRepository cartManagementRepository;
	
	@Autowired
	ProductManagementRepository productManagementRepository;
	
	@Override
	public void createCart(Cart cart) throws Exception{


		try {
			// cart 테이블에 먼저 insert
			cartManagementRepository.createCart(cart);

			Long tot = 0L;
			Long memberId = cart.getMemberId();

			List<CartOptionMap> stockList = cart.getStockList();
			System.out.println(stockList);

			Long cartId = cart.getCartId();

			System.out.println(cartId);

			// 옵션 넣기
			for(CartOptionMap stock : stockList) {
				Long stockId = stock.getStockId();
				stock.setCartId(cartId);
				System.out.println("stock = " + stock);

				Integer quantity = cartManagementRepository.checkCartProduct(memberId, stockId);

				Long inputQuantity = stock.getQuantity();
				tot = inputQuantity;

				boolean status = quantity != null;

				System.out.println("tot = " + tot);
				System.out.println("status = " + status);
				System.out.println("quantity = " + quantity);
//
//				// 이미 상품이 장바구니에 있는경우 -> 현재 수량과 받은 수량을 더해서 설정
				if(status) {
					tot += quantity;
					cartManagementRepository.updateCartQuantity(stockId, tot);
				}
//
				// 재고가 없으면 0
//				if(cartManagementRepository.checkQuantity(stock.getStockId(),tot) == 0) {
//					throw new RuntimeException("재고가 없습니다");
//				}
//
				cartManagementRepository.createCartStock(stock);
			}

		}catch (Exception e) {
			throw e;
		}
	}

//	@Override
//	public void updateCartQuantity(Long cartId, int quantity) {
//		try {
//			cartManagementRepository.updateCartQuantity(cartId,quantity);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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
		List<Cart> cartList = null;
		
		try {
			cartList = cartManagementRepository.getCartList(memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public Boolean checkQuantity(Long stockId, Long quantity) {
		try {
			
			if(cartManagementRepository.checkQuantity(stockId,quantity) != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Stock> getStockId(Long cartId) {
		List<Stock> stockIdList = null;
		try {
			stockIdList =  cartManagementRepository.getStockId(cartId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockIdList;
	}

}
