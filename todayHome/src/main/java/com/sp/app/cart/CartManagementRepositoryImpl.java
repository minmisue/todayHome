package com.sp.app.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;


@Repository
public class CartManagementRepositoryImpl implements CartManagementRepository{

	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void createProduct(Cart cart) throws Exception {
		commonDAO.insertData("cart.insertCart", cart);
		
	}

	@Override
	public void updateProduct(Long cartId, int quantity) throws Exception {
		
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("cartId", cartId);
		map.put("quantity", quantity);
		
		commonDAO.updateData("cart.updateQuantity", map);
		
	}

	@Override
	public void deleteCart(Long cartId) throws Exception{
		commonDAO.deleteData("cart.deleteCart", cartId);
	}

	@Override
	public List<Cart> getCartList(Long memberId) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer checkQuantity(Long stockId, int quantity) throws Exception {
		Integer result = null; // 아무런 조건이 없으면 null 반환 하기때문에 반환 타입 Integer
		
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("stockId", stockId);
		map.put("quantity", quantity);
		
		
		result = commonDAO.selectOne("cart.checkQuantity", map);
		
		return result;
	}

	@Override
	public Integer checkCartProduct(Long memberId, Long productId, Long stockId) throws Exception {
		Integer result = null;
		
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("productId", productId);
		map.put("stockId", stockId);
		
		result = commonDAO.selectOne("cart.checkCartProduct", map);
		return result;
	}

}
