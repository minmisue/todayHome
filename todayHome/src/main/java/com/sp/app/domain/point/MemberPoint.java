package com.sp.app.domain.point;

public class MemberPoint {
	private Long point_usage_history_id;
	private Long member_id;
	private String reg_date;
	private Long amount;
	
	public Long getPoint_usage_history_id() {
		return point_usage_history_id;
	}
	public void setPoint_usage_history_id(Long point_usage_history_id) {
		this.point_usage_history_id = point_usage_history_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}
