package com.sp.app.domain.board;

public class EventReply {
	private Long eventBoardCommentId;
	private Long eventBoardId;
	private Long memberId;
	private String name;
	private String content;
	private String regDate;
	private int dataCount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public Long getEventBoardCommentId() {
		return eventBoardCommentId;
	}
	public void setEventBoardCommentId(Long eventBoardCommentId) {
		this.eventBoardCommentId = eventBoardCommentId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
