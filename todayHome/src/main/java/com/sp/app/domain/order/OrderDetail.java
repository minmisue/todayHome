package com.sp.app.domain.order;

public class OrderDetail {
	private Long orderItemId;
	private String orderBundleId;
	
	private Long productId;
	private Long couponId;
	private int finalPrice;
	private int disCountPercent;
	private int state;
	private int originalPrice;
	
	public OrderDetail() {}
	
	
	public OrderDetail(String orderBundleId, Long productId, Long couponId, int finalPrice, int disCountPercent,
			int originalPrice) {
		super();
		this.orderBundleId = orderBundleId;
		this.productId = productId;
		this.couponId = couponId;
		this.finalPrice = finalPrice;
		this.disCountPercent = disCountPercent;
		this.originalPrice = originalPrice;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getOrderBundleId() {
		return orderBundleId;
	}
	public void setOrderBundleId(String orderBundleId) {
		this.orderBundleId = orderBundleId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getCouponId() {
		return couponId;
	}
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getDisCountPercent() {
		return disCountPercent;
	}
	public void setDisCountPercent(int disCountPercent) {
		this.disCountPercent = disCountPercent;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	
}
