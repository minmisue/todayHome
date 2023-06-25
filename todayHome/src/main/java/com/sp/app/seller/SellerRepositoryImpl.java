package com.sp.app.seller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.seller.Seller;

@Repository
public class SellerRepositoryImpl implements SellerRepository{
	
	@Autowired
	private CommonDAO commonDAO; 
	
	@Override
	public void createSeller(Seller seller) throws Exception {
		commonDAO.insertData("seller.createSeller", seller);
		
	}

	@Override
	public void updateSeller(Seller seller) throws Exception{
		commonDAO.updateData("seller.updateSeller", seller);
		
	}

	@Override
	public Seller getSellerStatus(Long sellerId) throws Exception{
		return commonDAO.selectOne("seller.getSellerStatus", sellerId);
		
	}

	@Override
	public void updateSellerStatus(Seller seller) throws Exception {		
		commonDAO.updateData("seller.updateSellerStatus", seller);	
	}

	@Override
	public List<Seller> getSellersByCondition(Map<String, Object> map) throws Exception {
		return commonDAO.selectList("seller.getSellersByCondition", map);
	}

	@Override
	public int getSellerCountByStatus(int status) throws Exception {
		return commonDAO.selectOne("seller.getSellerCount", status);

	}

	@Override
	public List<Seller> getSellerBySellerId(Long sellerId) throws Exception {
		return commonDAO.selectList("seller.getSellerBySellerId", sellerId);
		
		
	}
}
