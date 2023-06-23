package com.sp.app.mypage.managerment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.mypage.coupon.Coupon;
import com.sp.app.domain.mypage.coupon.MemberCoupon;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	CouponRepository couponRepository;

	@Override
	public void insertCoupon(Coupon coupon) throws Exception {
		couponRepository.insertCoupon(coupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) throws Exception {
		couponRepository.updateCoupon(coupon);
	}

	@Override
	public void deleteCoupon(Long couponId) throws Exception {
		couponRepository.deleteCoupon(couponId);
	}

	@Override
	public List<Coupon> getAllCoupon() throws Exception {
		return couponRepository.getAllCoupon();
	}

	@Override
	public void insertMemberCoupon(MemberCoupon membercoupon) throws Exception {
		couponRepository.insertMemberCoupon(membercoupon);
	}

	@Override
	public void deleteMemberCoupon(long couponId) throws Exception {
		couponRepository.deleteMemberCoupon(couponId);
	}

	@Override
	public List<MemberCoupon> getCouponById(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
