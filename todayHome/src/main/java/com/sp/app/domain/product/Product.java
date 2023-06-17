package com.sp.app.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Product {
	private Long productId;
	private Long sellerId;
	private Long categoryId;
	private String productName;
	private int remainQuantity;
	private String imgName;
}
