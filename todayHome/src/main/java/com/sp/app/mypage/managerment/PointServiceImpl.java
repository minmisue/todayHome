package com.sp.app.mypage.managerment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.mypage.MemberPoint;
import com.sp.app.domain.mypage.Point;

@Service
public class PointServiceImpl implements PointService{

	@Autowired
	PointRepository pointRepository;
	
	@Override
	public void insertPoint(Point point) throws Exception {
		pointRepository.insertPoint(point);
	}

	@Override
	public void updateMemberPoint(Point point) throws Exception {
		pointRepository.updateMemberPoint(point);
	}

	@Override
	public void insertMemberPoint(MemberPoint point) throws Exception {
		pointRepository.insertMemberPoint(point);
	}

	@Override
	public void deleteMemberPoint(Long pointUsageHistoryId) throws Exception {
		pointRepository.deleteMemberPoint(pointUsageHistoryId);
	}

	@Override
	public Point getPointById(Long memberId) throws Exception {
		
		return pointRepository.getPointById(memberId);
	}

	@Override
	public MemberPoint getMemberPointById(Long memberId) throws Exception {

		return pointRepository.getMemberPointById(memberId);
	}

}
