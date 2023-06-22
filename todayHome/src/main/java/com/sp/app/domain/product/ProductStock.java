package com.sp.app.domain.product;

public class ProductStock {
	private int optionPrice;
	private int quantity;
	private Long subOptionId1;
	private Long subOptionId2;

	public ProductStock() {
	}

	public ProductStock(int optionPrice, int quantity, Long subOptionId1, Long subOptionId2) {
		this.optionPrice = optionPrice;
		this.quantity = quantity;
		this.subOptionId1 = subOptionId1;
		this.subOptionId2 = subOptionId2;
	}

	@Override
	public String toString() {
		return "ProductStock{" +
				"optionPrice=" + optionPrice +
				", quantity=" + quantity +
				", subOptionId1=" + subOptionId1 +
				", subOptionId2=" + subOptionId2 +
				'}';
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

	public Long getSubOptionId1() {
		return subOptionId1;
	}

	public void setSubOptionId1(Long subOptionId1) {
		this.subOptionId1 = subOptionId1;
	}

	public Long getSubOptionId2() {
		return subOptionId2;
	}

	public void setSubOptionId2(Long subOptionId2) {
		this.subOptionId2 = subOptionId2;
	}
}
