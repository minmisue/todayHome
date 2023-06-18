package com.sp.app.seller;

import java.util.List;
import java.util.Map;

import com.sp.app.domain.seller.Seller;

public interface SellerRepository {
    // 판매자 생성 ok
	void createSeller(Seller seller) throws Exception;
    
    // 판매자 수정 ok
   	void updateSeller(Seller seller) throws Exception;
    
    // 판매자 상태
   	void getSellerStatus(Long sellerId);
    
   	//판매자 상태 수정
   	void updateSellerStatus(Map<String, Object> map) throws Exception;
    
   	// 판매자 삭제 ok
    void deleteSeller(Long sellerId) throws Exception;
    
    // 판매자 리스트 반환
    List<Seller> getAllSellers() throws Exception;
    
    // 판매자의 평가에 따라 리스트 반환 (하는지 안한는지 잘 모름)
    List<Seller> getSellersByRating(int rating);
    
    //송장번호 입력하기
    void setDeliveryNumber(Long orderId);
}
