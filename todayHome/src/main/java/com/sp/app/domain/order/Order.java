package com.sp.app.domain.order;

public class Order {
	private String orderBundleId; // 주문 묶음 아이디
	private Long memberId;
	private String memberName;
	private Long couponId; 
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
	private String buyerName; // 주문자
	private String buyerTel;
	private int quantity; // 주문조회할때 수량
	
	private String deliveryNumber;
	private int deliveryCost;
	private String arrivedDate;

	//주문조회
	private int orderCount;
	private int orderPrice;
	private int finalPrice;
	private Long orderItemId;
	private int discountPercent;
	private int status;
	private Long stockId;
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

	
	
	@Override
	public String toString() {
		return "Order [orderBundleId=" + orderBundleId + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", orderRegDate=" + orderRegDate + ", receiveName=" + receiveName + ", tel=" + tel + ", postNum="
				+ postNum + ", address2=" + address2 + ", address1=" + address1 + ", usedPoint=" + usedPoint
				+ ", payMethod=" + payMethod + ", finalTotPrice=" + finalTotPrice + ", finalDiscountPrice="
				+ finalDiscountPrice + ", finalDeliveryCost=" + finalDeliveryCost + ", buyerName=" + buyerName
				+ ", buyerTel=" + buyerTel + ", quantity=" + quantity + ", deliveryNumber=" + deliveryNumber
				+ ", deliveryCost=" + deliveryCost + ", arrivedDate=" + arrivedDate + ", orderCount=" + orderCount
				+ ", orderPrice=" + orderPrice + ", finalPrice=" + finalPrice + ", orderItemId=" + orderItemId
				+ ", discountPercent=" + discountPercent + ", status=" + status + ", stockId=" + stockId + "]";
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

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getOrderBundleId() {
		return orderBundleId;
	}

	public void setOrderBundleId(String orderBundleId) {
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
