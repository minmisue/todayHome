package com.sp.app.domain.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class UserBoard {
    private Long userBoardId;
    private Long memberId;
    private String subject;
    private String createdDate;
	private String ipAddress;
	private int hitCount;
	private int boardTypeId;
	private int replyCount;
	private int boardLikeCount;
	private int boardScrapCount;
	private String nickName;
	private String profileImgName;
	
	private Long userBoardContentId;
	
	private String content;
	private String imgName;
	private int userBoardContentCategoryId;
	private int contentSequence;
	private String position;

	private List<String> contents;
	private List<MultipartFile> selectFile;
	private List<Integer> userBoardContentCategoryIds;
	private List<Integer> contentSequences;
	private List<String> positions;
	
	private MultipartFile thumbnailFile;
	
	private Long productId;
	private float xCoordinate;
	private float yCoordinate;
	private Long discountedPrice;
	private String productName;
	private String brandName;
	private String saveName;
	private String sellerId;
	private Long price;
	
	

	

	@Override
	public String toString() {
		return "UserBoard [userBoardId=" + userBoardId + ", memberId=" + memberId + ", subject=" + subject
				+ ", createdDate=" + createdDate + ", ipAddress=" + ipAddress + ", hitCount=" + hitCount
				+ ", boardTypeId=" + boardTypeId + ", replyCount=" + replyCount + ", boardLikeCount=" + boardLikeCount
				+ ", boardScrapCount=" + boardScrapCount + ", nickName=" + nickName + ", profileImgName="
				+ profileImgName + ", userBoardContentId=" + userBoardContentId + ", content=" + content + ", imgName="
				+ imgName + ", userBoardContentCategoryId=" + userBoardContentCategoryId + ", contentSequence="
				+ contentSequence + ", position=" + position + ", contents=" + contents + ", selectFile=" + selectFile
				+ ", userBoardContentCategoryIds=" + userBoardContentCategoryIds + ", contentSequences="
				+ contentSequences + ", positions=" + positions + ", thumbnailFile=" + thumbnailFile +  ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", discountedPrice="
				+ discountedPrice + ", productName=" + productName + ", brandName=" + brandName + ", saveName="
				+ saveName + ", sellerId=" + sellerId + ", price=" + price + "]";
	}



	public int getBoardTypeId() {
		return boardTypeId;
	}



	public void setBoardTypeId(int boardTypeId) {
		this.boardTypeId = boardTypeId;
	}



	public UserBoard() {
		
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



	public Long getUserBoardContentId() {
		return userBoardContentId;
	}



	public void setUserBoardContentId(Long userBoardContentId) {
		this.userBoardContentId = userBoardContentId;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}






	public int getUserBoardContentCategoryId() {
		return userBoardContentCategoryId;
	}



	public void setUserBoardContentCategoryId(int userBoardContentCategoryId) {
		this.userBoardContentCategoryId = userBoardContentCategoryId;
	}



	public int getContentSequence() {
		return contentSequence;
	}



	public void setContentSequence(int contentSequence) {
		this.contentSequence = contentSequence;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public List<String> getContents() {
		return contents;
	}



	public void setContents(List<String> contents) {
		this.contents = contents;
	}



	public List<MultipartFile> getSelectFile() {
		return selectFile;
	}



	public void setSelectFile(List<MultipartFile> selectFile) {
		this.selectFile = selectFile;
	}



	public List<Integer> getUserBoardContentCategoryIds() {
		return userBoardContentCategoryIds;
	}



	public void setUserBoardContentCategoryIds(List<Integer> userBoardContentCategoryIds) {
		this.userBoardContentCategoryIds = userBoardContentCategoryIds;
	}



	public List<Integer> getContentSequences() {
		return contentSequences;
	}



	public void setContentSequences(List<Integer> contentSequences) {
		this.contentSequences = contentSequences;
	}



	public List<String> getPositions() {
		return positions;
	}



	public void setPositions(List<String> positions) {
		this.positions = positions;
	}



	public MultipartFile getThumbnailFile() {
		return thumbnailFile;
	}



	public void setThumbnailFile(MultipartFile thumbnailFile) {
		this.thumbnailFile = thumbnailFile;
	}



	public Long getProductId() {
		return productId;
	}



	public void setProductId(Long productId) {
		this.productId = productId;
	}



	public float getxCoordinate() {
		return xCoordinate;
	}



	public void setxCoordinate(float xCoordinate) {
		this.xCoordinate = xCoordinate;
	}



	public float getyCoordinate() {
		return yCoordinate;
	}



	public void setyCoordinate(float yCoordinate) {
		this.yCoordinate = yCoordinate;
	}



	public Long getDiscountedPrice() {
		return discountedPrice;
	}



	public void setDiscountedPrice(Long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}



	public String getSaveName() {
		return saveName;
	}



	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}



	public String getSellerId() {
		return sellerId;
	}



	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}



	public Long getPrice() {
		return price;
	}



	public void setPrice(Long price) {
		this.price = price;
	}
	
	
	

	
	

}
