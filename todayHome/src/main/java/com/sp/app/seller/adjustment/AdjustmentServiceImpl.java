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
	public List<SellerAdjustment> getAllAdjustments(int offset, int size, String startDate, String endDate,String keyword,String condition) throws Exception {
		List<SellerAdjustment> sellerAdjustment = null;
			try {
				
				sellerAdjustment = adjustmentRepository.getAllAdjustments(offset,  size,startDate,endDate,keyword,condition);
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
	public List<SellerAdjustment> getAdjustmentsBySellerId(Long sellerId,int offset,int size, String startDate,String endDate) throws Exception {
		List<SellerAdjustment> sellerAdjustment = null;
		
		try {
			sellerAdjustment = adjustmentRepository.getAdjustmentsBySellerId(sellerId,offset,size,startDate,endDate);
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


	@Override
	public int adjustmentCount(String startDate,String endDate, String keyword,String condition) throws Exception {
		return adjustmentRepository.adjustmentCount(startDate,endDate,keyword,condition);
	}


	@Override
	public int adjustmentCountBysellerId(Long sellerId, String startDate,String endDate) throws Exception {
		return adjustmentRepository.adjustmentCountBysellerId(sellerId,startDate,endDate);
	}

}
