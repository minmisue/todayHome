package com.sp.app.domain.product;

public class ReviewProduct {
//	p.product_id, p.product_name, osb.stock_id, brand_name

	private Long orderItemId;
	private Long productId;
	private Long stockId;
	private String productName;
	private String brandName;
	private String stockString;

	@Override
	public String toString() {
		return "ReviewProduct{" +
				"orderItemId=" + orderItemId +
				", productId=" + productId +
				", stockId=" + stockId +
				", productName='" + productName + '\'' +
				", brandName='" + brandName + '\'' +
				", stockString='" + stockString + '\'' +
				'}';
	}

	public ReviewProduct() {
	}

	public ReviewProduct(Long productId, Long stockId, String productName, String brandName) {
		this.productId = productId;
		this.stockId = stockId;
		this.productName = productName;
		this.brandName = brandName;
	}

	public String getStockString() {
		return stockString;
	}

	public void setStockString(String stockString) {
		this.stockString = stockString;
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

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
}
