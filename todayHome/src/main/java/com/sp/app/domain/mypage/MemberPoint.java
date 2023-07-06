package com.sp.app.domain.mypage;

public class MemberPoint {
	private Long pointUsageHistoryId;
	private Long memberId;
	private String regDate;
	private int amount;
	private int status;
	
	public MemberPoint() {
		
	}
	
	public MemberPoint(Long memberId, int amount) {
		this.memberId = memberId;
		this.amount = amount;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getPointUsageHistoryId() {
		return pointUsageHistoryId;
	}
	public void setPointUsageHistoryId(Long pointUsageHistoryId) {
		this.pointUsageHistoryId = pointUsageHistoryId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
