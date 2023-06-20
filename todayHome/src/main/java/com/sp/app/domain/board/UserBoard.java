package com.sp.app.domain.board;

import java.util.List;


public class UserBoard {
    private Long userBoardId;
    private Long memberId;
	private List<Long> categoryId;
    private String subject;
    private String createdDate;
	private String ipAddress;
	private int hitCount;
	private int boardType;
	private int replyCount;
	private int boardLikeCount;
	private int boardScrapCount;
	private String presentationImgName;
	private List<ProductContent> productContentList;


	public Long getUserBoardId() {
		return userBoardId;
	}

	public void setUserBoardId(Long userBoardId) {
		this.userBoardId = userBoardId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public List<Long> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Long> categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getBoardLikeCount() {
		return boardLikeCount;
	}

	public void setBoardLikeCount(int boardLikeCount) {
		this.boardLikeCount = boardLikeCount;
	}

	public int getBoardScrapCount() {
		return boardScrapCount;
	}

	public void setBoardScrapCount(int boardScrapCount) {
		this.boardScrapCount = boardScrapCount;
	}

	public String getPresentationImgName() {
		return presentationImgName;
	}

	public void setPresentationImgName(String presentationImgName) {
		this.presentationImgName = presentationImgName;
	}

	public List<ProductContent> getProductContentList() {
		return productContentList;
	}

	public void setProductContentList(List<ProductContent> productContentList) {
		this.productContentList = productContentList;
	}
}
