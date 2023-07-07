package com.sp.app.domain.cart;

import java.util.List;

import com.sp.app.domain.product.ProductStock;

public class Cart {
	private Long cartId;
	private Long memberId;
	private Long productImgId;
	private Long stockId;
	private Long sellerId;
	
	private Long productId;	
	private String regDate; // 담은 날짜
	private String productName; // 상품이름
	private String brandName;// 브랜드 이름
	private String saveName; // 사진 저장 이름
	private Long price; // 상품 기본가격
	private Double discountPercent; // 할인율
	private Long deliveryCost; // 배달비
	private List<CartOptionMap> stockList;
	private List<ProductStock> productStockList;

	@Override
	public String toString() {
		return "Cart{" +
				"cartId=" + cartId +
				", memberId=" + memberId +
				", productImgId=" + productImgId +
				", stockId=" + stockId +
				", productId=" + productId +
				", regDate='" + regDate + '\'' +
				", productName='" + productName + '\'' +
				", brandName='" + brandName + '\'' +
				", saveName='" + saveName + '\'' +
				", price=" + price +
				", discountPercent=" + discountPercent +
				", deliveryCost=" + deliveryCost +
				", stockList=" + stockList +
				", productStockList=" + productStockList +
				'}';
	}

	public Cart(Long memberId, Long productId, List<CartOptionMap> stockList) {
		this.memberId = memberId;
		this.productId = productId;
		this.stockList = stockList;
	}

	public Cart() {
	}

	
	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public List<ProductStock> getProductStockList() {
		return productStockList;
	}

	public void setProductStockList(List<ProductStock> productStockList) {
		this.productStockList = productStockList;
	}

	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getCartId() {
		return cartId;
	}


	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public Long getProductImgId() {
		return productImgId;
	}


	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}


	public Long getStockId() {
		return stockId;
	}


	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
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


	public Double getDiscountPercent() {
		return discountPercent;
	}


	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}


	public Long getDeliveryCost() {
		return deliveryCost;
	}


	public void setDeliveryCost(Long deliveryCost) {
		this.deliveryCost = deliveryCost;
	}


	public List<CartOptionMap> getStockList() {
		return stockList;
	}


	public void setStockList(List<CartOptionMap> stockList) {
		this.stockList = stockList;
	}


}
