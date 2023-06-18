package com.sp.app.domain.event;

public class EventWinner {
	private Long event_board_id;
	private Long member_id;
	private String reg_date;
	
	public Long getEvent_board_id() {
		return event_board_id;
	}
	public void setEvent_board_id(Long event_board_id) {
		this.event_board_id = event_board_id;
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
	
	
}
