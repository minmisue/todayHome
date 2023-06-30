package com.sp.app.domain.board;

public class EventWinner {
	private Long eventBoardId;
	private Long memberId;
	private String name;
	private String regDate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getEventBoardId() {
		return eventBoardId;
	}
	public void setEventBoardId(Long eventBoardId) {
		this.eventBoardId = eventBoardId;
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
	
	
	
}
