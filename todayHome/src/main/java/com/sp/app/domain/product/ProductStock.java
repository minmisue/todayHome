package com.sp.app.domain.product;

public class ProductStock {
	private Long stockId;
	private int optionPrice;
	private int quantity;
	private Long mainOptionId1;
	private Long mainOptionId2;
	private Long subOptionId1;
	private Long subOptionId2;
	private String subOptionName1;
	private String subOptionName2;
	private String mainOptionName1;
	private String mainOptionName2;
	private Long productId;

	public ProductStock() {
	}

	public ProductStock(int optionPrice, int quantity) {
		this.optionPrice = optionPrice;
		this.quantity = quantity;
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
				"stockId=" + stockId +
				", optionPrice=" + optionPrice +
				", quantity=" + quantity +
				", mainOptionId1=" + mainOptionId1 +
				", mainOptionId2=" + mainOptionId2 +
				", subOptionId1=" + subOptionId1 +
				", subOptionId2=" + subOptionId2 +
				", subOptionName1='" + subOptionName1 + '\'' +
				", subOptionName2='" + subOptionName2 + '\'' +
				", mainOptionName1='" + mainOptionName1 + '\'' +
				", mainOptionName2='" + mainOptionName2 + '\'' +
				", productId=" + productId +
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

	public Long getMainOptionId1() {
		return mainOptionId1;
	}

	public void setMainOptionId1(Long mainOptionId1) {
		this.mainOptionId1 = mainOptionId1;
	}

	public Long getMainOptionId2() {
		return mainOptionId2;
	}

	public void setMainOptionId2(Long mainOptionId2) {
		this.mainOptionId2 = mainOptionId2;
	}

	public String getSubOptionName1() {
		return subOptionName1;
	}

	public void setSubOptionName1(String subOptionName1) {
		this.subOptionName1 = subOptionName1;
	}

	public String getSubOptionName2() {
		return subOptionName2;
	}

	public void setSubOptionName2(String subOptionName2) {
		this.subOptionName2 = subOptionName2;
	}

	public String getMainOptionName1() {
		return mainOptionName1;
	}

	public void setMainOptionName1(String mainOptionName1) {
		this.mainOptionName1 = mainOptionName1;
	}

	public String getMainOptionName2() {
		return mainOptionName2;
	}

	public void setMainOptionName2(String mainOptionName2) {
		this.mainOptionName2 = mainOptionName2;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
}
