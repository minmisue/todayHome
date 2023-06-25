package com.sp.app.domain.cart;

import java.util.List;

public class CartOptionMap {
	private Long stockId;
	private Long price;
	private Long quantity;

	public CartOptionMap() {
	}

	public CartOptionMap(Long stockId, Long price, Long quantity) {
		this.stockId = stockId;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
