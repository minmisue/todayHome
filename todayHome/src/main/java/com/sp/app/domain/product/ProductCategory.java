package com.sp.app.domain.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategory {
	private Long productCategoryId;
	private Long parentCategoryId;
	private String categoryName;
	private Integer categoryLevel;
	private List<ProductCategory> subCategoryList;


}
