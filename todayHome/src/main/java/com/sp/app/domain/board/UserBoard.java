package com.sp.app.domain.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


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
	private String imgName;
	private String nickName;
	private String profileImgName;
	private List<BoardContent> boardContentList;
	
	

	public UserBoard() {
		
	}
	
	
	

	@Override
	public String toString() {
		return "UserBoard [userBoardId=" + userBoardId + ", memberId=" + memberId + ", categoryId=" + categoryId
				+ ", subject=" + subject + ", createdDate=" + createdDate + ", ipAddress=" + ipAddress + ", hitCount="
				+ hitCount + ", boardType=" + boardType + ", replyCount=" + replyCount + ", boardLikeCount="
				+ boardLikeCount + ", boardScrapCount=" + boardScrapCount + ", imgName=" + imgName + ", nickName="
				+ nickName + ", profileImgName=" + profileImgName + ", boardContentList=" + boardContentList
				+ "]";
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

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	public List<BoardContent> getBoardContentList() {
		return boardContentList;
	}

	public void setBoardContentList(List<BoardContent> boardContentList) {
		this.boardContentList = boardContentList;
	}
	

}
