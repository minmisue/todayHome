package com.sp.app.domain.board;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public class UserBoard {
	private Long userBoardId;
	private Long memberId;
	private List<Long> categoryId;
	private String subject;
	private String createdDate;
	private String ipAddress;
	private int hitCount;
	private int boardTypeId;
	private int replyCount;
	private int boardLikeCount;
	private int boardScrapCount;
	private String presentationImgName;
	private MultipartFile thumbnailFile;
	private List<BoardContent> boardContentList;


	@Override
	public String toString() {
		return "UserBoard{" +
				"userBoardId=" + userBoardId +
				", memberId=" + memberId +
				", categoryId=" + categoryId +
				", subject='" + subject + '\'' +
				", createdDate='" + createdDate + '\'' +
				", ipAddress='" + ipAddress + '\'' +
				", hitCount=" + hitCount +
				", boardTypeId=" + boardTypeId +
				", replyCount=" + replyCount +
				", boardLikeCount=" + boardLikeCount +
				", boardScrapCount=" + boardScrapCount +
				", presentationImgName='" + presentationImgName + '\'' +
				", boardContentList=" + boardContentList +
				'}';
	}

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

	public int getBoardTypeId() {
		return boardTypeId;
	}

	public void setBoardTypeId(int boardTypeId) {
		this.boardTypeId = boardTypeId;
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

	public List<BoardContent> getBoardContentList() {
		return boardContentList;
	}

	public void setBoardContentList(List<BoardContent> boardContentList) {
		this.boardContentList = boardContentList;
	}
}
