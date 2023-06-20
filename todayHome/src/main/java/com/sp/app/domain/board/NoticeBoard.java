package com.sp.app.domain.board;

public class NoticeBoard {
	private Long noticeBoardId;
	private Long memberId;
	private String createdDate;
	private String subject;
	private String content;
	private int hitCount;
	private int notice;
	
	public Long getNoticeBoardId() {
		return noticeBoardId;
	}
	public void setNoticeBoardId(Long noticeBoardId) {
		this.noticeBoardId = noticeBoardId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}
	
	
}
