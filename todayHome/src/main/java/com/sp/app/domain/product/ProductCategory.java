package com.sp.app.domain.product;

public class ProductCategory {
	private Long CategoryId;
	private String name;
	private Long parentId;

	public ProductCategory(Long categoryId, String name, Long parentId) {
		CategoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
	}

	public Long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
