package com.sp.app.seller.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.seller.SellerAdjustment;

@Service
public class AdjustmentServiceImpl implements AdjustmentService {
	
	@Autowired
	AdjustmentRepository adjustmentRepository;
	
	
	@Override
	public List<SellerAdjustment> getAllAdjustments() throws Exception {
		List<SellerAdjustment> sellerAdjustment = null;
		
		try {
			
			sellerAdjustment = adjustmentRepository.getAllAdjustments();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return sellerAdjustment;
	}


	@Override
	public List<SellerAdjustment> getAdjustmentByAdjustmentId(Long adjustmentId) throws Exception {
		List<SellerAdjustment> sellerAdjustment = null;
		
		try {
			sellerAdjustment = adjustmentRepository.getAdjustmentByAdjustmentId(adjustmentId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sellerAdjustment;
		
	}

	@Override
	public List<SellerAdjustment> getAdjustmentsBySellerId(Long sellerId) throws Exception {
		List<SellerAdjustment> sellerAdjustment = null;
		
		try {
			sellerAdjustment = adjustmentRepository.getAdjustmentsBySellerId(sellerId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sellerAdjustment;
	}

	@Override
	public void createAdjustment(SellerAdjustment adjustment) throws Exception {
		try {
			adjustmentRepository.createAdjustment(adjustment);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void updateAdjustment(SellerAdjustment adjustment) throws Exception {
		try {
			adjustmentRepository.updateAdjustment(adjustment);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
