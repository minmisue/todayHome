package com.sp.app.domain.cart;

public class CartOptionMap {
	private Long cartId;
	private Long stockId;
	private Long price;
	private Long quantity;

	@Override
	public String toString() {
		return "CartOptionMap{" +
				"cartId=" + cartId +
				", stockId=" + stockId +
				", price=" + price +
				", quantity=" + quantity +
				'}';
	}

	public CartOptionMap() {
	}

	public CartOptionMap(Long stockId, Long price, Long quantity) {
		this.stockId = stockId;
		this.price = price;
		this.quantity = quantity;
	}

	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
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
