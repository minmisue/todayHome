package com.sp.app.domain.product;

public class ProductReview {
	private Long writerId;
	private Long productId;
	private String username;
	private Double rating;
	private String createdDate;
	private String content;

	public ProductReview(Long writerId, Long productId, String username, Double rating, String createdDate, String content) {
		this.writerId = writerId;
		this.productId = productId;
		this.username = username;
		this.rating = rating;
		this.createdDate = createdDate;
		this.content = content;
	}

	public Long getWriterId() {
		return writerId;
	}

	public void setWriterId(Long writerId) {
		this.writerId = writerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
