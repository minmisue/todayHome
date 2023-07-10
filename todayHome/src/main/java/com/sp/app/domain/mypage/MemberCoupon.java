package com.sp.app.domain.mypage;

public class MemberCoupon {
	private Long memberCouponId;
	private Long couponId;
	private String name;
	
	private int maxDiscountAmount;
	private int discountPercent;
	
	private Long memberId;
	private String expireDate;
	private String regDate;
	
	public MemberCoupon() {
		
	}
	
	public MemberCoupon(Long memberId) {
		this.memberId = memberId;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	

	public int getMaxDiscountAmount() {
		return maxDiscountAmount;
	}

	public void setMaxDiscountAmount(int maxDiscountAmount) {
		this.maxDiscountAmount = maxDiscountAmount;
	}

	public MemberCoupon(Long couponId, Long memberId, String expireDate) {
		this.couponId = couponId;
		this.memberId = memberId;
		this.expireDate = expireDate;
	}

	public Long getMemberCouponId() {
		return memberCouponId;
	}

	public void setMemberCouponId(Long memberCouponId) {
		this.memberCouponId = memberCouponId;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}


	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
