package com.sp.app.domain.board;

public class Comment {
	public Long userBoardId;
	public Long memberId;
	public Long replyLike;
	public Long userBoardCommentId;
	public Long parentCommentId;
	public String regDate;
	public String content;
	public Long likeCount;
	public String nickName;
	public String profileImgName;
	
	public Comment() {
		
	}
	
	
	@Override
	public String toString() {
		return "Comment [userBoardId=" + userBoardId + ", memberId=" + memberId + ", replyLike=" + replyLike
				+ ", userBoardCommentId=" + userBoardCommentId + ", parentCommentId=" + parentCommentId + ", regDate="
				+ regDate + ", content=" + content + ", likeCount=" + likeCount + ", nickName=" + nickName + "]";
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
	public Long getReplyLike() {
		return replyLike;
	}
	public void setReplyLike(Long replyLike) {
		this.replyLike = replyLike;
	}
	public Long getUserBoardCommentId() {
		return userBoardCommentId;
	}
	public void setUserBoardCommentId(Long userBoardCommentId) {
		this.userBoardCommentId = userBoardCommentId;
	}
	public Long getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
