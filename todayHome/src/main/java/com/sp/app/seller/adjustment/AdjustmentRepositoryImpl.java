package com.sp.app.seller.adjustment;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.seller.SellerAdjustment;

@Repository
public class AdjustmentRepositoryImpl implements AdjustmentRepository {

	@Autowired 
	private CommonDAO commonDAO;
	
	@Override
	public List<SellerAdjustment> getAllAdjustments(int offset, int size, String startDate, String endDate,String keyword,String condition) throws Exception{	
		 Map<String, Object> map = new HashMap<String, Object>();
			map.put("offset", offset);			
			map.put("size", size);
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("keyword", keyword);
			map.put("condition", condition);
		 
		return commonDAO.selectList("sellerAdjustment.getAllAdjustments",map);
		
	}

	@Override 
	public List<SellerAdjustment> getAdjustmentByAdjustmentId(Long adjustmentId) throws Exception {
		return commonDAO.selectOne("sellerAdjustment.getAdjustmentById",adjustmentId);
	}

	@Override
	public List<SellerAdjustment> getAdjustmentsBySellerId(Long sellerId) throws Exception{
		return commonDAO.selectList("sellerAdjustment.getAdjustmentsBySellerId",sellerId);
	}

	@Override
	public void createAdjustment(SellerAdjustment adjustment) throws Exception{
		commonDAO.insertData("sellerAdjustment.createAdjustment", adjustment);
	}

	@Override
	public void updateAdjustment(SellerAdjustment adjustment) throws Exception{
		commonDAO.updateData("sellerAdjustment.updateAdjustment", adjustment);
	}

	@Override
	public int adjustmentCount(String startDate,String endDate, String keyword,String condition) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("keyword", keyword);
		map.put("condition", condition);
		return commonDAO.selectOne("sellerAdjustment.adjustmentCount",map);
		
	}


}
