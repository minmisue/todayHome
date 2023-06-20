package com.sp.app.cart;

import java.util.List;

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
	public void updateProduct(Long cartId) throws Exception {
		commonDAO.updateData("cart.updateCart", cartId);
		
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

}
