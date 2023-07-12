package com.sp.app.mypage.managerment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.mypage.Coupon;
import com.sp.app.domain.mypage.MemberCoupon;

@Repository
public class CouponRepositoryImpl implements CouponRepository{

	@Autowired
	CommonDAO commonDAO;

	@Override
	public void insertCoupon(Coupon coupon) throws Exception {
		commonDAO.insertData("coupon.insertCoupon", coupon);
	}
	
	@Override
	public void insertMemberCoupon(MemberCoupon membercoupon) throws Exception {
		commonDAO.insertData("coupon.insertMemberCoupon", membercoupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) throws Exception {
		commonDAO.updateData("coupon.updateCoupon", coupon);
	}

	@Override
	public void deleteCoupon(Long couponId) throws Exception {
		commonDAO.deleteData("coupon.deleteCoupon", couponId);
	}

	@Override
	public void deleteMemberCoupon(long couponId, long memberId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("couponId", couponId);
		map.put("memberId", memberId);
		commonDAO.deleteData("coupon.deleteMemberCoupon", map);
	}

	@Override
	public List<Coupon> getAllCoupon() throws Exception {
		return commonDAO.selectList("coupon.getAllCoupon");
	}

	@Override
	public List<MemberCoupon> getMemberCouponById(Long memberId) throws Exception {
		return commonDAO.selectList("coupon.getMemberCouponById", memberId);
	}

	@Override
	public int memberCouponCount(long memberId) throws Exception {
		return commonDAO.selectOne("coupon.memberCouponCount", memberId);
	}

	@Override
	public Coupon getCouponById(long couponId) throws Exception {
		return commonDAO.selectOne("coupon.getCouponById", couponId);
	}

	
}
