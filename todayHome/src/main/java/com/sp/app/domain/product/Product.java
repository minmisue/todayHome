package com.sp.app.domain.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter @Setter @ToString
public class Product {
	private Long productId;
	private Long sellerId;
	private Long productCategoryId;
	private String productName;
	private int remainQuantity;
	private List<String> productImgList;
	private List<String> contentImgList;
	private String content;
	private int productScrapCnt;
	private String regDate;
	private int discountPercent;
	private int reservingPointPercent;
	private int deliveryCost;
	private int price;

	public Product() {
	}

	public Product(Long sellerId, Long productCategoryId, String productName, List<String> productImgList, List<String> contentImgList, String content) {
		this.sellerId = sellerId;
		this.productCategoryId = productCategoryId;
		this.productName = productName;
		this.productImgList = productImgList;
		this.contentImgList = contentImgList;
		this.content = content;
	}
}
