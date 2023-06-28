package com.sp.app.domain.board;

import java.util.List;

public class BoardContent {
	private Long userBoardContentId;
	private Long userBoardId;
	private Long userBoardContentCategoryId;
	private String content;
	private int contentSequence;
	private String imgName;
	List<ProductTag> productTagList;
	
	public BoardContent() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "BoardContent [userBoardContentId=" + userBoardContentId + ", userBoardId=" + userBoardId
				+ ", userBoardContentCategoryId=" + userBoardContentCategoryId + ", content=" + content
				+ ", contentSequence=" + contentSequence + ", imgName=" + imgName + ", productTagList=" + productTagList
				+ "]";
	}



	public BoardContent(Long userBoardId, Long userBoardContentCategoryId, String content, int contentSequence,
			String imgName) {
		super();
		this.userBoardId = userBoardId;
		this.userBoardContentCategoryId = userBoardContentCategoryId;
		this.content = content;
		this.contentSequence = contentSequence;
		this.imgName = imgName;
	}



	public Long getUserBoardContentId() {
		return userBoardContentId;
	}

	public void setUserBoardContentId(Long userBoardContentId) {
		this.userBoardContentId = userBoardContentId;
	}

	public Long getUserBoardId() {
		return userBoardId;
	}

	public void setUserBoardId(Long userBoardId) {
		this.userBoardId = userBoardId;
	}

	public Long getUserBoardContentCategoryId() {
		return userBoardContentCategoryId;
	}

	public void setUserBoardContentCategoryId(Long userBoardContentCategoryId) {
		this.userBoardContentCategoryId = userBoardContentCategoryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getContentSequence() {
		return contentSequence;
	}

	public void setContentSequence(int contentSequence) {
		this.contentSequence = contentSequence;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public List<ProductTag> getProductTagList() {
		return productTagList;
	}

	public void setProductTagList(List<ProductTag> productTagList) {
		this.productTagList = productTagList;
	}
}
