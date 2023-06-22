package com.sp.app.mypage.managerment;

import java.util.List;

import com.sp.app.domain.mypage.coupon.Coupon;
import com.sp.app.domain.mypage.coupon.MemberCoupon;


public interface CouponRepository {
	
	void insertCoupon(Coupon coupon) throws Exception;
	
	void updateCoupon(Coupon coupon) throws Exception;
	
	void deleteCoupon(Long couponId) throws Exception;
	
	void insertMemberCoupon(MemberCoupon membercoupon) throws Exception;
	
	void deleteMemberCoupon(long couponId) throws Exception;

	List<Coupon> getAllCoupon() throws Exception;
	
	List<MemberCoupon> getCouponById(Long memberId) throws Exception;
}
