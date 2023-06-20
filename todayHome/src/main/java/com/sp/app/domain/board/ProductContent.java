package com.sp.app.domain.board;

import java.util.List;

public class ProductContent {
	private Long userBoardId;
	private Long categoryId;
	private String content;
	private int contentSequence;
	private String imgName;
	List<ProductTag> productTagList;


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
