package com.sp.app.mypage.managerment;

import java.util.List;

import com.sp.app.domain.mypage.MemberCoupon;
import com.sp.app.domain.mypage.MemberPoint;
import com.sp.app.domain.mypage.Point;

public interface PointService {
	
	void insertPoint(Point point) throws Exception;
	
	void updateMemberPoint(Point point) throws Exception;

	void insertMemberPoint(MemberPoint point) throws Exception;
	
	void deleteMemberPoint(Long pointUsageHistoryId) throws Exception;
	
	Point getPointById(Long memberId) throws Exception;
	
	List<MemberCoupon> getMemberPointById(Long memberId) throws Exception;
}
