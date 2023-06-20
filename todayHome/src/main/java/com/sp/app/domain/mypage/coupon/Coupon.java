package com.sp.app.domain.mypage.coupon;

public class Coupon {
	private Long couponId;
	private Long discountPercent;
	private String name;
	private Long maxDiscountAmount;
	
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
