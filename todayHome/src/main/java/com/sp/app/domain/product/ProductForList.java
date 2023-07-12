package com.sp.app.domain.product;

import lombok.Data;

public class ProductForList {
	private Long productId;
	private String brandName;
	private int productCategoryId;
	private String productName;
	private String regDate;
	private int price;
	private int remainQuantity;
	private int discountPercent;
	private int reviewCnt;
	private float rating;
	private String saveName;
	private String sellerName;


	@Override
	public String toString() {
		return "ProductForList{" +
				"productId=" + productId +
				", brandName='" + brandName + '\'' +
				", productCategoryId=" + productCategoryId +
				", productName='" + productName + '\'' +
				", regDate='" + regDate + '\'' +
				", price=" + price +
				", remainQuantity=" + remainQuantity +
				", discountPercent=" + discountPercent +
				", reviewCnt=" + reviewCnt +
				", rating=" + rating +
				", saveName='" + saveName + '\'' +
				'}';
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public int getRemainQuantity() {
		return remainQuantity;
	}

	public void setRemainQuantity(int remainQuantity) {
		this.remainQuantity = remainQuantity;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	
	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}	
}
