package com.sp.app.mypage.managerment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.mypage.point.MemberPoint;
import com.sp.app.domain.mypage.point.Point;

@Repository
public class PointRepositoryImpl implements PointRepository{
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void insertPoint(Point point) throws Exception {
		commonDAO.insertData("point.insertPoint", point);
	}

	@Override
	public void updateMemberPoint(Point point) throws Exception {
		commonDAO.updateData("point.updateMemberPoint", point);
	}

	@Override
	public void insertMemberPoint(MemberPoint point) throws Exception {
		commonDAO.insertData("point.insertMemberPoint", point);
	}

	@Override
	public void deleteMemberPoint(Long pointUsageHistoryId) throws Exception{
		commonDAO.deleteData("point.deleteMemberPoint",pointUsageHistoryId);
	}

	@Override
	public Point getPointById(Long memberId) throws Exception{
		return commonDAO.selectOne("point.getPointById", memberId);
	}

	@Override
	public MemberPoint getMemberPointById(Long memberId) throws Exception{
		return commonDAO.selectOne("point.getMemberPointById", memberId);
	}


}
