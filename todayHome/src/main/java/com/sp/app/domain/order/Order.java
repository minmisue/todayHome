package com.sp.app.domain.order;

public class Order {
	private Long orderBundleId; // 주문 묶음 아이디
	private Long memberId;

	private String orderRegDate; // 주문 날짜
	private String receiveName; // 수령인 이름
	private String tel; // 수령인 번호
	private String postNum;
	private String address2; // 상세 주소
	private String address1; // 주소
	private int usedPoint; // 사용 포인트
	private	String payMethod;
	private int finalTotPrice; // 총금액(order_bundle)
	private int finalDiscountPrice; // 총할인 금액
	private int finalDeliveryCost; // 총배송비


	private String deliveryNumber;
	private int deliveryCost;
	private String arrivedDate;

	public Order() {
	}

	public Order(Long memberId, String receiveName, String tel, String postNum,
			String address2, String address1, int usedPoint, String payMethod, int finalTotPrice,
			int finalDiscountPrice, int finalDeliveryCost) {

		this.memberId = memberId;
		this.receiveName = receiveName;
		this.tel = tel;
		this.postNum = postNum;
		this.address2 = address2;
		this.address1 = address1;
		this.usedPoint = usedPoint;
		this.payMethod = payMethod;
		this.finalTotPrice = finalTotPrice;
		this.finalDiscountPrice = finalDiscountPrice;
		this.finalDeliveryCost = finalDeliveryCost;

	}

	public Long getOrderBundleId() {
		return orderBundleId;
	}

	public void setOrderBundleId(Long orderBundleId) {
		this.orderBundleId = orderBundleId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getOrderRegDate() {
		return orderRegDate;
	}

	public void setOrderRegDate(String orderRegDate) {
		this.orderRegDate = orderRegDate;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getFinalTotPrice() {
		return finalTotPrice;
	}

	public void setFinalTotPrice(int finalTotPrice) {
		this.finalTotPrice = finalTotPrice;
	}

	public int getFinalDiscountPrice() {
		return finalDiscountPrice;
	}

	public void setFinalDiscountPrice(int finalDiscountPrice) {
		this.finalDiscountPrice = finalDiscountPrice;
	}

	public int getFinalDeliveryCost() {
		return finalDeliveryCost;
	}

	public void setFinalDeliveryCost(int finalDeliveryCost) {
		this.finalDeliveryCost = finalDeliveryCost;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public String getArrivedDate() {
		return arrivedDate;
	}

	public void setArrivedDate(String arrivedDate) {
		this.arrivedDate = arrivedDate;
	}
	
	

}
