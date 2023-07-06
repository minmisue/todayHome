package com.sp.app.domain.order;

public class Delivery {
	private Long orderItemId;
	private int deliveryCost;
	private String deliveryNumber;
	private String arrivedDate;
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getArrivedDate() {
		return arrivedDate;
	}
	public void setArrivedDate(String arrivedDate) {
		this.arrivedDate = arrivedDate;
	}
	
	
}
