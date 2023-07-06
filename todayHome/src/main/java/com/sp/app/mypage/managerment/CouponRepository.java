package com.sp.app.mypage.managerment;

import java.util.List;

import com.sp.app.domain.mypage.Coupon;
import com.sp.app.domain.mypage.MemberCoupon;


public interface CouponRepository {
	
	void insertCoupon(Coupon coupon) throws Exception;
	
	void updateCoupon(Coupon coupon) throws Exception;
	
	void deleteCoupon(Long couponId) throws Exception;
	
	void insertMemberCoupon(MemberCoupon membercoupon) throws Exception;
	
	void deleteMemberCoupon(long couponId) throws Exception;

	List<Coupon> getAllCoupon() throws Exception;
	
	Coupon getCouponById(long couponId) throws Exception;
	
	List<MemberCoupon> getMemberCouponById(Long memberId) throws Exception;
	
	int memberCouponCount(long memberId) throws Exception;
}
