package com.sp.app.seller.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;

@Repository
public class AdjustmentRepositoryImpl implements AdjustmentRepository {

	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public List<Adjustment> getAllAdjustments() throws Exception{
		return commonDAO.selectList("sellerAdjustment.getAllAdjustment");
		
	}

	@Override
	public void getAdjustmentByAdjustmentId(Long adjustmentId) throws Exception {
		commonDAO.selectOne("sellerAdjustment.getAdjustmentById",adjustmentId);
	}

	@Override
	public List<Adjustment> getAdjustmentsBySellerId(Long sellerId) throws Exception{
		return commonDAO.selectList("sellerAdjustment.getAdjustmentBySellerId",sellerId);
	}

	@Override
	public void createAdjustment(Adjustment adjustment) throws Exception{
		commonDAO.insertData("sellerAdjustment.createAdjustment", adjustment);
	}

	@Override
	public void updateAdjustment(Adjustment adjustment) throws Exception{
		commonDAO.updateData("sellerAdjustment.updateAdjustment", adjustment);
	}


}
