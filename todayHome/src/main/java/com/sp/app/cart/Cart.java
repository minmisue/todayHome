package com.sp.app.cart;

public class Cart {
	private long cartId;
	private long memberId;
	private long productImgId;
	private long stockId;
	
	private long productId;
	private int quantity; // 수량
	private String regDate; // 담은 날짜
	private String productName; // 상품이름
	private String brandName;// 브랜드 이름
	private String saveName; // 사진 저장 이름
	private int price; // 상품 기본가격
	private double discountPrcent; // 할인율
	private int deliveryCost; // 배달비
	
	
	
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	public long getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(long productImgId) {
		this.productImgId = productImgId;
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
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscountPrcent() {
		return discountPrcent;
	}
	public void setDiscountPrcent(double discountPrcent) {
		this.discountPrcent = discountPrcent;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String reg_date) {
		this.regDate = reg_date;
	}
	
	
}
