package com.sp.app.mypage.managerment;

import com.sp.app.domain.mypage.point.MemberPoint;
import com.sp.app.domain.mypage.point.Point;

public interface PointService {
	
	void insertPoint(Point point) throws Exception;
	
	void updateMemberPoint(Point point) throws Exception;

	void insertMemberPoint(MemberPoint point) throws Exception;
	
	void deleteMemberPoint(Long pointUsageHistoryId) throws Exception;
	
	Point getPointById(Long memberId) throws Exception;
	
	MemberPoint getMemberPointById(Long memberId) throws Exception;
}
