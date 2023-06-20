package com.sp.app.domain.board;

public class ProductTag {
	private Long productId;
	private float xCoordinate;
	private float yCoordinate;

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
}
