package com.sp.app.domain.board;

public class QnaBoard {
	private Long qnaBoardId;
	private Long qnaCategoryId;
	private Long memberId;
	private String subject;
	private String content;
	private String createdDate;
	
	public Long getQnaBoardId() {
		return qnaBoardId;
	}
	public void setQnaBoardId(Long qnaBoardId) {
		this.qnaBoardId = qnaBoardId;
	}
	public Long getQnaCategoryId() {
		return qnaCategoryId;
	}
	public void setQnaCategoryId(Long qnaCategoryId) {
		this.qnaCategoryId = qnaCategoryId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
