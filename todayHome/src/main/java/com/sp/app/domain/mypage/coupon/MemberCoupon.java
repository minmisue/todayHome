package com.sp.app.domain.mypage.coupon;

public class MemberCoupon {
	private Long member_coupon_id;
	private String member_id;
	
	private Long coupon_id;
	private Long discount_percent;
	private String name;
	private Long max_discount_amount;
	
	public Long getMember_coupon_id() {
		return member_coupon_id;
	}
	public void setMember_coupon_id(Long member_coupon_id) {
		this.member_coupon_id = member_coupon_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Long getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(Long coupon_id) {
		this.coupon_id = coupon_id;
	}
	public Long getDiscount_percent() {
		return discount_percent;
	}
	public void setDiscount_percent(Long discount_percent) {
		this.discount_percent = discount_percent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMax_discount_amount() {
		return max_discount_amount;
	}
	public void setMax_discount_amount(Long max_discount_amount) {
		this.max_discount_amount = max_discount_amount;
	}
	
	
}
