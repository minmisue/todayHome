package com.sp.app.domain.notice;

public class NoticeBoard {
	private Long notice_board_id;
	private Long member_id;
	private String created_date;
	private String subject;
	private String content;
	private int hit_count;
	private int notice;
	
	public Long getNotice_board_id() {
		return notice_board_id;
	}
	public void setNotice_board_id(Long notice_board_id) {
		this.notice_board_id = notice_board_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
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
	public int getHit_count() {
		return hit_count;
	}
	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}
	
	
}
