package com.sp.app.mypage.managerment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.mypage.coupon.Coupon;
import com.sp.app.domain.mypage.coupon.MemberCoupon;

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
	public void deleteMemberCoupon(long couponId) throws Exception {
		commonDAO.deleteData("coupon.deleteMemberCoupon", couponId);
	}

	@Override
	public List<Coupon> getAllCoupon() throws Exception {
		return commonDAO.selectList("coupon.getAllCoupon");
	}

	@Override
	public List<MemberCoupon> getCouponById(Long memberId) throws Exception {
		return commonDAO.selectList("coupon.getCouponById", memberId);
	}

	
}
