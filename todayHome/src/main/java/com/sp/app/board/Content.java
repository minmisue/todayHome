package com.sp.app.board;

public class Content {
	private Long userBoardId;
	private Long categoryId;
	private String content;
	private Long content_sequence;
	private String imgName;
	public Long getUserBoardId() {
		return userBoardId;
	}
	public void setUserBoardId(Long userBoardId) {
		this.userBoardId = userBoardId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getContent_sequence() {
		return content_sequence;
	}
	public void setContent_sequence(Long content_sequence) {
		this.content_sequence = content_sequence;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	
}
