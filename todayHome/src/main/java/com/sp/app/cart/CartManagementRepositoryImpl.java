package com.sp.app.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.cart.Stock;


@Repository
public class CartManagementRepositoryImpl implements CartManagementRepository{

	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void createCart(Cart cart) throws Exception {
		commonDAO.insertData("cart.insertCart", cart);
		
		List<CartOptionMap> stockList = cart.getStockList();
		if(stockList == null) {
			return;
		}
		

	}
	
	public void createCartStock(CartOptionMap cartOptionMap) throws Exception {
		commonDAO.insertData("cart.insertCartStock",cartOptionMap);
	}

	@Override
	public void updateCartQuantity(Long cartId, Long quantity) throws Exception {
		
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("cartId", cartId);
		map.put("quantity", quantity);
		
		commonDAO.updateData("cart.updateQuantity", map);
		
	}

	@Override
	public void deleteCart(List<Long> cartIdList) throws Exception{
		commonDAO.deleteData("cart.deleteCart", cartIdList);
	}

	@Override
	public List<Cart> getCartList(Long memberId) throws Exception{
		List<Cart> cartList = commonDAO.selectList("cart.selectList", memberId);
		return cartList;
	}

	@Override
	public Integer checkQuantity(Long stockId, Long quantity) throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("stockId", stockId);
		map.put("quantity", quantity);
		
		return commonDAO.selectOne("cart.checkQuantity", map);
	}

	@Override
	public Integer checkCartProduct(Long memberId, Long stockId) throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);

		map.put("stockId", stockId);
		
		return commonDAO.selectOne("cart.checkCartProduct", map);
	}

	@Override
	public List<Stock> getStockId(Long cartId) throws Exception{
		 List<Stock> stockIdList = commonDAO.selectList("cart.selectListStock", cartId);
		
		return stockIdList;		
	}

}
