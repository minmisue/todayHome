package com.sp.app.domain.board;

public class ListBoard {
	private Long userBoardId;
	private String nickname;
	private Long memberId;
	private Long hitCount;
	private Long replyCount;
	private Long boardLikeCount;
	private Long boardScrapCount;
	private String profileImgName;
	private String content;
	private String imgName;
	private String commentContent;
	private String info;
	
	public ListBoard() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "ListBoard [userBoardId=" + userBoardId + ", nickname=" + nickname + ", memberId=" + memberId
				+ ", hitCount=" + hitCount + ", replyCount=" + replyCount + ", boardLikeCount=" + boardLikeCount
				+ ", boardScrapCount=" + boardScrapCount + ", profileImgName=" + profileImgName + ", content=" + content
				+ ", imgName=" + imgName + ", commentContent=" + commentContent + "]";
	}



	public Long getUserBoardId() {
		return userBoardId;
	}
	public void setUserBoardId(Long userBoardId) {
		this.userBoardId = userBoardId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getHitCount() {
		return hitCount;
	}
	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}
	public Long getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}
	public Long getBoardLikeCount() {
		return boardLikeCount;
	}
	public void setBoardLikeCount(Long boardLikeCount) {
		this.boardLikeCount = boardLikeCount;
	}
	public Long getBoardScrapCount() {
		return boardScrapCount;
	}
	public void setBoardScrapCount(Long boardScrapCount) {
		this.boardScrapCount = boardScrapCount;
	}
	public String getProfileImgName() {
		return profileImgName;
	}
	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
