package com.sp.app.adjustment;

import java.util.List;

public interface AdjustmentRepository {
    // 모든 정산 목록 반환
    List<Adjustment> getAllAdjustments();

    // 정산 아이디로 정산 반환
    Adjustment getAdjustmentById(Long adjustmentId);

    // 판매자 아이디로 정산 목록 반환
    List<Adjustment> getAdjustmentsBySellerId(Long sellerId);

    // 정산 생성
    Adjustment createAdjustment(Adjustment adjustment);

    // 정산 수정
    Adjustment updateAdjustment(Long adjustmentId, Adjustment adjustment);

    // 정산 삭제
    void deleteAdjustment(Long adjustmentId);
}

