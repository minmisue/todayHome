package com.sp.app.seller;

import java.util.List;

public interface SellerRepository {
    // 판매자 생성
    Seller createSeller(Seller seller);
    
    // 판매자 수정
    Seller updateSeller(Long sellerId, Seller seller);
    
    // 판매자 상태
    Seller getSellerStatus(Long sellerId);
    
    // 판매자 삭제
    void deleteSeller(Long sellerId);
    
    // 판매자 리스트 반환
    List<Seller> getAllSellers();
    
    // 판매자의 평가에 따라 리스트 반환 (하는지 안한는지 잘 모름)
    List<Seller> getSellersByRating(int rating);
    
    //송장번호 입력하기
    void setDeliveryNumber(Long orderId);
}
