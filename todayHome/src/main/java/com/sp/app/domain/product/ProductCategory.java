package com.sp.app.domain.product;

import lombok.Data;

@Data
public class ProductCategory {
	private Long productCategoryId;
	private Long parentCategoryId;
	private String categoryName;
	private Integer categoryLevel;

}
