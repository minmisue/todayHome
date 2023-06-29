package com.sp.app.seller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.seller.Seller;

@Service
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

	
	@Override
	public Seller getSellerBySellerId(Long sellerId) throws Exception {
		Seller seller = null;
		
		try {
			seller = sellerRepository.getSellerBySellerId(sellerId); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return seller; 
	}

	@Override
	public Seller login(String email, String password) {
		Seller seller;
		
		try {
			seller = sellerRepository.getSellerByEmail(email);
			if(seller == null) {
				return null;
			} 
			
			if(! password.equals(seller.getPassword())) {
				return null;
			}
			return seller;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean businessNumberCheck(String businessNumber) throws Exception {
		int result = sellerRepository.businessNumberCheck(businessNumber);
		if (result == 1) {
			return true;
		}
			return false;
	}
}
