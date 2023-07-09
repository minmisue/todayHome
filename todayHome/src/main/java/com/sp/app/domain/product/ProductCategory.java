package com.sp.app.domain.product;


import java.util.List;

public class ProductCategory {
	private Long productCategoryId;
	private Long parentCategoryId;
	private String categoryName;
	private Integer categoryLevel;
	private List<ProductCategory> subCategoryList;

	public ProductCategory() {
	}

	public ProductCategory(Long parentCategoryId, String categoryName) {
		this.parentCategoryId = parentCategoryId;
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategory{" +
				"productCategoryId=" + productCategoryId +
				", parentCategoryId=" + parentCategoryId +
				", categoryName='" + categoryName + '\'' +
				", categoryLevel=" + categoryLevel +
				", subCategoryList=" + subCategoryList +
				'}';
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public List<ProductCategory> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(List<ProductCategory> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
}
