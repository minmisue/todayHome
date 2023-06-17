package com.sp.app.domain.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ProductCategory {
	private Long CategoryId;
	private String name;
	private Long parentId;
}
