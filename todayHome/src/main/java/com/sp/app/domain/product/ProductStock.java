package com.sp.app.domain.product;

public class ProductStock {
	private int optionPrice;
	private int quantity;
	private Long optionDetailId1;
	private Long optionDetailId2;

	public ProductStock() {
	}

	@Override
	public String toString() {
		return "ProductStock{" +
				"optionPrice=" + optionPrice +
				", quantity=" + quantity +
				", optionDetailId1=" + optionDetailId1 +
				", optionDetailId2=" + optionDetailId2 +
				'}';
	}

	public Long getOptionDetailId2() {
		return optionDetailId2;
	}

	public void setOptionDetailId2(Long optionDetailId2) {
		this.optionDetailId2 = optionDetailId2;
	}

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getOptionDetailId1() {
		return optionDetailId1;
	}

	public void setOptionDetailId1(Long optionDetailId1) {
		this.optionDetailId1 = optionDetailId1;
	}
}
