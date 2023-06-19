package com.sp.app.coupon.management;

import java.util.List;

import com.sp.app.domain.copon.Coupon;
import com.sp.app.domain.copon.MemberCoupon;


public interface CouponRepository {
	public int insertCoupon(Coupon dto);
	
	public int updateCoupon(Coupon dto);
	
	public int deleteCoupon(List<Long> coupon_id);
	
	public List<Coupon> readCoupon(Coupon dto);
	
	public int insertMemberCoupon(MemberCoupon dto);

	public int deleteMemberCoupon(long coupon_id);
}
