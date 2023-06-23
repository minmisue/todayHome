package com.sp.app.domain.mypage.coupon;

public class Coupon {
	private Long couponId;
	private int discountPercent;
	private String name;
	private int maxDiscountAmount;
	private int status;

	public Coupon() {
		
	}
	
	public Coupon( int discountPercent, String name, int maxDiscountAmount) {
		this.discountPercent = discountPercent;
		this.name = name;
		this.maxDiscountAmount = maxDiscountAmount;
	}
	
	public Coupon(Long couponId, int discountPercent, String name, int maxDiscountAmount, int status) {
		this.couponId = couponId;
		this.discountPercent = discountPercent;
		this.name = name;
		this.maxDiscountAmount = maxDiscountAmount;
		this.status = status;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxDiscountAmount() {
		return maxDiscountAmount;
	}

	public void setMaxDiscountAmount(int maxDiscountAmount) {
		this.maxDiscountAmount = maxDiscountAmount;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
