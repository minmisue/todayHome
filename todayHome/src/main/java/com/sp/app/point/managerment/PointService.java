package com.sp.app.point.managerment;

import com.sp.app.domain.point.MemberPoint;
import com.sp.app.domain.point.Point;

public interface PointService {
	void insertPoint(Point dto) throws Exception;
	
	void updateMemberPoint(Point dto) throws Exception;

	void insertMemberPoint(MemberPoint dto) throws Exception;
	
	void deleteMemberPoint(Long point_usage_history_id);
}
