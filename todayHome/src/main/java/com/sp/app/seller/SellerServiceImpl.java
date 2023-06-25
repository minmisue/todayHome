package com.sp.app.seller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import com.sp.app.domain.seller.Seller;


public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository sellerRepository;
	
	@Override
	public void createSeller(Seller seller) throws Exception {
		try {
			sellerRepository.createSeller(seller);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void updateSeller(Seller seller) throws Exception {
		try {
			sellerRepository.updateSeller(seller);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
		

	@Override
	public Seller getSellerStatus(Long sellerId) throws Exception {
		Seller seller = null;
		
		try {
			seller = sellerRepository.getSellerStatus(sellerId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return seller;
	}

	@Override
	public void updateSellerStatus(Seller seller) throws Exception {
		try {
			sellerRepository.updateSellerStatus(seller);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<Seller> getSellersByCondition(Map<String, Object> map) throws Exception {
	    List<Seller> sellers = null;
	    
	    try {
	        sellers = sellerRepository.getSellersByCondition(map);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	    
	    return sellers;
	}

	@Override
	public int getSellerCountByStatus(int status) throws Exception {
	    int count = 0;
	    
	    try {
	        count = sellerRepository.getSellerCountByStatus(status);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	    
	    return count;
	}
}
