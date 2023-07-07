package com.sp.app.domain.product;

import java.util.List;


public class Product {
	private Long productId;
	private Long sellerId;
	private Long productCategoryId;
	private String productName;
	private int remainQuantity;
	private List<ProductImg> productImgList;
	private List<ProductImg> contentImgList;
	private String content;
	private int productScrapCnt;
	private String regDate;
	private int discountPercent;
	private int reservingPointPercent;
	private int deliveryCost;
	private int price;
	
	private String brandName;
	private List<ProductStock> productStockList;
	
	public Product() {
	}

	public Product(Long sellerId, Long productCategoryId, String productName, List<ProductImg> productImgList, List<ProductImg> contentImgList, String content) {
		this.sellerId = sellerId;
		this.productCategoryId = productCategoryId;
		this.productName = productName;
		this.productImgList = productImgList;
		this.contentImgList = contentImgList;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", sellerId=" + sellerId +
				", productCategoryId=" + productCategoryId +
				", productName='" + productName + '\'' +
				", remainQuantity=" + remainQuantity +
				", productImgList=" + productImgList +
				", contentImgList=" + contentImgList +
				", content='" + content + '\'' +
				", productScrapCnt=" + productScrapCnt +
				", regDate='" + regDate + '\'' +
				", discountPercent=" + discountPercent +
				", reservingPointPercent=" + reservingPointPercent +
				", deliveryCost=" + deliveryCost +
				", price=" + price +
				'}';
	}

	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<ProductStock> getProductStockList() {
		return productStockList;
	}

	public void setProductStockList(List<ProductStock> productStockList) {
		this.productStockList = productStockList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getRemainQuantity() {
		return remainQuantity;
	}

	public void setRemainQuantity(int remainQuantity) {
		this.remainQuantity = remainQuantity;
	}

	public List<ProductImg> getProductImgList() {
		return productImgList;
	}

	public void setProductImgList(List<ProductImg> productImgList) {
		this.productImgList = productImgList;
	}

	public List<ProductImg> getContentImgList() {
		return contentImgList;
	}

	public void setContentImgList(List<ProductImg> contentImgList) {
		this.contentImgList = contentImgList;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getProductScrapCnt() {
		return productScrapCnt;
	}

	public void setProductScrapCnt(int productScrapCnt) {
		this.productScrapCnt = productScrapCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getReservingPointPercent() {
		return reservingPointPercent;
	}

	public void setReservingPointPercent(int reservingPointPercent) {
		this.reservingPointPercent = reservingPointPercent;
	}

	public int getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
