package com.sp.app.domain.product;

public class ProductReview {
	private Long orderItemId;
	private Long memberId;
	private String nickName;
	private String profileImgName;
	private Long productId;
	private Float rating;
	private String regDate;
	private String content;
	private String reviewImgName;
	private String productName;
	private Long stockId;
	private String stockString;
	private String brandName;

	public ProductReview() {
	}

	public ProductReview(Long memberId, Long productId, Float rating, String content, String reviewImgName) {
		this.memberId = memberId;
		this.productId = productId;
		this.rating = rating;
		this.content = content;
		this.reviewImgName = reviewImgName;
	}

	public ProductReview(Long orderItemId, Float rating, String content, String reviewImgName) {
		this.orderItemId = orderItemId;
		this.rating = rating;
		this.content = content;
		this.reviewImgName = reviewImgName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getStockString() {
		return stockString;
	}

	public void setStockString(String stockString) {
		this.stockString = stockString;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductReview{" +
				"orderItemId=" + orderItemId +
				", memberId=" + memberId +
				", nickName='" + nickName + '\'' +
				", profileImgName='" + profileImgName + '\'' +
				", productId=" + productId +
				", rating=" + rating +
				", regDate='" + regDate + '\'' +
				", content='" + content + '\'' +
				", reviewImgName='" + reviewImgName + '\'' +
				", productName='" + productName + '\'' +
				", stockId=" + stockId +
				", stockString='" + stockString + '\'' +
				", brandName='" + brandName + '\'' +
				'}';
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
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

	public String getReviewImgName() {
		return reviewImgName;
	}

	public void setReviewImgName(String reviewImgName) {
		this.reviewImgName = reviewImgName;
	}
}
