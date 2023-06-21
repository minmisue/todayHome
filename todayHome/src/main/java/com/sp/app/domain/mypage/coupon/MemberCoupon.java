package com.sp.app.domain.mypage.coupon;

public class MemberCoupon {
	private Long memberCouponId;
	private String memberId;
	
	private Long couponId;
	private Long discountPercent;
	private String name;
	private Long maxDiscountAmount;
	
	public Long getMemberCouponId() {
		return memberCouponId;
	}
	public void setMemberCouponId(Long memberCouponId) {
		this.memberCouponId = memberCouponId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Long getCouponId() {
		return couponId;
	}
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	public Long getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Long discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMaxDiscountAmount() {
		return maxDiscountAmount;
	}
	public void setMaxDiscountAmount(Long maxDiscountAmount) {
		this.maxDiscountAmount = maxDiscountAmount;
	}
	
	
}
