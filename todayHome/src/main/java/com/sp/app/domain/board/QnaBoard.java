package com.sp.app.domain.board;

public class QnaBoard {
	private Long qna_board_id;
	private Long qna_category_id;
	private Long member_id;
	private String subject;
	private String content;
	private String created_date;
	
	public Long getQna_board_id() {
		return qna_board_id;
	}
	public void setQna_board_id(Long qna_board_id) {
		this.qna_board_id = qna_board_id;
	}
	public Long getQna_category_id() {
		return qna_category_id;
	}
	public void setQna_category_id(Long qna_category_id) {
		this.qna_category_id = qna_category_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
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
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
}
