package com.sp.app.domain.board;

public class ProductTag {
	private Long productId;
	private float xCoordinate;
	private float yCoordinate;
	private Long discountedPrice;
	private String productName;
	private String brandName;
	private String saveName;
	private String sellerId;
	private Long userBoardContentId;
	private Long price;
	
	public ProductTag() {
		
	}
	
	

	@Override
	public String toString() {
		return "ProductTag [productId=" + productId + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate
				+ ", discountedPrice=" + discountedPrice + ", productName=" + productName + ", brandName=" + brandName
				+ ", saveName=" + saveName + ", sellerId=" + sellerId + ", userBoardContentId=" + userBoardContentId
				+ "]";
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
	
	public Long getUserBoardContentId() {
		return userBoardContentId;
	}

	public void setUserBoardContentId(Long userBoardContentId) {
		this.userBoardContentId = userBoardContentId;
	}
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
}
