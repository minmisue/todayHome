package com.sp.app.domain.order;

import java.util.List;


public class Order {
	private Long orderBundleId; // 주문 묶음 아이디
	private Long orderItemId; // 주문 아이템 아이디
	private Long orderStatusId; // 주문 상태 아이디
	private Long memberId;
	private Long productId; 
	private Long couponId;
	private Long stockId;
	
	private String orderRegDate; // 주문 날짜
	private int quantity; // 수량
	private int price;
	private int finalPrice; // 최종 금액
	private int discountPrice; // 할인 적용된 수량
	private int status;
	private String statusRegDate;
	private String receiveName; // 수령인 이름
	private String tel; // 수령인 번호
	private String postNum;
	private String address2; // 상세 주소
	private String address1; // 주소
	private int usedPoint; // 사용 포인트
	private	String payMathod;
	private int finalTotPrice; // 총금액(order_bundle)
	private int finalDiscountPrice;
	private int finalDeliveryCost;
	
	private List<Long> productNums;
	private List<Long> stockNums;
	private List<Long> orderItemNums;	
	private List<Integer> buyQtys;
	private List<Integer> prices;
	private List<Integer> discountPrices;
	private List<Integer> finalPrices;
	public Long getOrderBundleId() {
		return orderBundleId;
	}
	public void setOrderBundleId(Long orderBundleId) {
		this.orderBundleId = orderBundleId;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(Long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public String getOrderRegDate() {
		return orderRegDate;
	}
	public void setOrderRegDate(String orderRegDate) {
		this.orderRegDate = orderRegDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusRegDate() {
		return statusRegDate;
	}
	public void setStatusRegDate(String statusRegDate) {
		this.statusRegDate = statusRegDate;
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
	public String getPayMathod() {
		return payMathod;
	}
	public void setPayMathod(String payMathod) {
		this.payMathod = payMathod;
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
	public List<Long> getProductNums() {
		return productNums;
	}
	public void setProductNums(List<Long> productNums) {
		this.productNums = productNums;
	}
	public List<Long> getStockNums() {
		return stockNums;
	}
	public void setStockNums(List<Long> stockNums) {
		this.stockNums = stockNums;
	}
	public List<Long> getOrderItemNums() {
		return orderItemNums;
	}
	public void setOrderItemNums(List<Long> orderItemNums) {
		this.orderItemNums = orderItemNums;
	}
	public List<Integer> getBuyQtys() {
		return buyQtys;
	}
	public void setBuyQtys(List<Integer> buyQtys) {
		this.buyQtys = buyQtys;
	}
	public List<Integer> getPrices() {
		return prices;
	}
	public void setPrices(List<Integer> prices) {
		this.prices = prices;
	}
	public List<Integer> getDiscountPrices() {
		return discountPrices;
	}
	public void setDiscountPrices(List<Integer> discountPrices) {
		this.discountPrices = discountPrices;
	}
	public List<Integer> getFinalPrices() {
		return finalPrices;
	}
	public void setFinalPrices(List<Integer> finalPrices) {
		this.finalPrices = finalPrices;
	}
	
	

	
}
