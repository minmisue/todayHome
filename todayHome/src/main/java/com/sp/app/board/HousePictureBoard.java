package com.sp.app.board;

public class HousePictureBoard {
		private long userBoardId;
	    private String memberId;
	    private int boardTypeId;
	    private String createdDate;
	    private String subject;
	    private int hitCount;
	    private String ipAdress;
	    
		public long getUserBoardId() {
			return userBoardId;
		}
		public void setUserBoardId(long userBoardId) {
			this.userBoardId = userBoardId;
		}
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public int getBoardTypeId() {
			return boardTypeId;
		}
		public void setBoardTypeId(int boardTypeId) {
			this.boardTypeId = boardTypeId;
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
		public int getHitCount() {
			return hitCount;
		}
		public void setHitCount(int hitCount) {
			this.hitCount = hitCount;
		}
		public String getIpAdress() {
			return ipAdress;
		}
		public void setIpAdress(String ipAdress) {
			this.ipAdress = ipAdress;
		}
	    
	    
}
