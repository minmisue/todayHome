package com.sp.app.domain.product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductReview {
	private Long writerId;
	private Long productId;
	private String username;
	private Double rating;
	private String createdDate;
	private String content;
}
