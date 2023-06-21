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
		commonDAO.insertData("seller.insertSeller", seller);
		
	}

	@Override
	public void updateSeller(Seller seller) throws Exception{
		commonDAO.updateData("seller.updateSeller", seller);
		
	}

	@Override
	public void getSellerStatus(Long sellerId) throws Exception{
		commonDAO.selectOne("seller.getSellerStatus", sellerId);
		
	}

	@Override
	public void updateSellerStatus(Map<String, Object> map) throws Exception {		
		commonDAO.updateData("seller.updateSellerStatus", map);	
	}

	@Override
	public List<Seller> getSellersByCondition(Map<String, Object> map) throws Exception {
		return commonDAO.selectList("seller.getSellersByCondition", map);
	}

	@Override
	public int getSellerCount(int status) throws Exception {
		return commonDAO.selectOne("seller.getSellerCount", status);

	}
}
