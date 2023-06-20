package com.sp.app.seller.adjustment;

import java.util.List;

public interface AdjustmentRepository {
    // 모든 정산 목록 반환 ok
    List<Adjustment> getAllAdjustments();

    // 정산 아이디로 정산 반환 ok
    Adjustment getAdjustmentByAdjustmentId(Long adjustmentId);

    // 판매자 아이디로 정산 목록 반환 ok
    List<Adjustment> getAdjustmentsBySellerId(Long sellerId);

    // 정산 기록 생성 ok
    Adjustment createAdjustment(Adjustment adjustment);

    // 정산 기록 수정 ok
    Adjustment updateAdjustment(Long adjustmentId, Adjustment adjustment);

}

