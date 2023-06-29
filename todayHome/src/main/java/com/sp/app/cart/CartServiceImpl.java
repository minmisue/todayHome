package com.sp.app.cart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.product.management.ProductManagementRepository;


@Service("cart.cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	CartManagementRepository cartManagementRepository;
	
	@Autowired
	ProductManagementRepository productManagementRepository;
	
	@Override
	@Transactional
	public void createCart(Cart cart) throws Exception{


		try {
			
			// 카트에 담겨져있으면 cart에 insert 안함			
			Long cartId = null;
			if(cartManagementRepository.checkCart(cart.getMemberId(), cart.getProductId()) != null){
				cartId = cartManagementRepository.checkCart(cart.getMemberId(), cart.getProductId());
			} else {
				cartManagementRepository.createCart(cart);
				cartId = cart.getCartId();
			}
			

			Long tot = 0L;
			Long memberId = cart.getMemberId();

			List<CartOptionMap> stockList = cart.getStockList();

			// 옵션 넣기
			for(CartOptionMap stock : stockList) {
				Long stockId = stock.getStockId();
				stock.setCartId(cartId);
		
				Integer quantity = cartManagementRepository.checkCartProduct(memberId, stockId);
				
				Long inputQuantity = stock.getQuantity();
				tot = inputQuantity;
				
				Long price = cartManagementRepository.selectStockPrice(stockId);
				
				boolean status = quantity != null;


				// 이미 상품이 장바구니에 있는경우 -> 현재 수량과 받은 수량을 더해서 설정
				if(status) {
					tot += quantity;
					stock.setPrice(price*tot);
					// 업데이트 해준다음에 나옴
					if(cartManagementRepository.checkQuantity(stock.getStockId(),tot) == 0) {
						throw new RuntimeException("재고가 없습니다");
					}
					cartManagementRepository.updateCartQuantity(cartId,stockId, tot);
					return;
				}

				// 재고가 없으면 0
				if(cartManagementRepository.checkQuantity(stock.getStockId(),tot) == 0) {
					throw new RuntimeException("재고가 없습니다");
				}

				cartManagementRepository.createCartStock(stock);
			}

		}catch (Exception e) {
			throw e;
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
	public List<CartOptionMap> getStockId(Long cartId) {
		List<CartOptionMap> stockIdList = null;
		try {
			stockIdList =  cartManagementRepository.getStockId(cartId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockIdList;
	}

	@Override
	public Long selectStockPrice(Long stockId) {
		Long price = null;
		try {
			price = cartManagementRepository.selectStockPrice(stockId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	@Override
	public void deleteStock(Long stockId) {
		try {
			
			cartManagementRepository.deleteStock(stockId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void checkQuantityUpdate(Map<String, Object> map) {
		try {
			Long stockId = (Long)map.get("stockId");
			Long cartId = (Long)map.get("cartId");
			Long quantity = (Long)map.get("quantity");
			
			
			if(cartManagementRepository.checkQuantity(stockId, quantity) == 0) {
				throw new RuntimeException("재고가 없습니다");
			}
			
			cartManagementRepository.updateCartQuantity(cartId, stockId, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
