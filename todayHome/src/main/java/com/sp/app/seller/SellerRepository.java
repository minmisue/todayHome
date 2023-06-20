package com.sp.app.seller;

import java.util.List;
import java.util.Map;

import com.sp.app.domain.seller.Seller;

public interface SellerRepository {
    // 판매자 생성 ok
	void createSeller(Seller seller) throws Exception;
    
    // 판매자 수정 ok
   	void updateSeller(Seller seller) throws Exception;
    
    // 판매자 상태 조회 ok
   	void getSellerStatus(Long sellerId) throws Exception;
    
   	//판매자 상태 수정 ok
   	void updateSellerStatus(Map<String, Object> map) throws Exception;

    // 판매자 리스트 반환  ok
    List<Seller> getSellersByCondition(Map<String, Object> map) throws Exception;
    
    //판매자 상태가 0,1,2,3 인 사람 각각 카운트. ok
    int getSellerCount(int status) throws Exception;

}
