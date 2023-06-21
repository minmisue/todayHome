package com.sp.app.seller.adjustment;

import java.util.List;

public interface AdjustmentRepository {
    // 모든 정산 목록 반환 ok
    List<Adjustment> getAllAdjustments() throws Exception;

    // 정산 아이디로 정산 반환 ok
    void getAdjustmentByAdjustmentId(Long adjustmentId) throws Exception;

    // 판매자 아이디로 정산 목록 반환 ok
    List<Adjustment> getAdjustmentsBySellerId(Long sellerId) throws Exception;

    // 정산 기록 생성 ok
   void createAdjustment(Adjustment adjustment) throws Exception;

    // 정산 기록 수정 ok
   void  updateAdjustment(Adjustment adjustment) throws Exception;

}

