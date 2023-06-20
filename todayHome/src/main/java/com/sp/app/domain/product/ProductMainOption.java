package com.sp.app.domain.product;


import java.util.List;

public class ProductMainOption {
	private Long mainOptionId;

	private Long parentOptionId;

	private String optionName;

	private Long productId;

	private List<ProductSubOption> subOptions;

	public ProductMainOption() {
	}

	@Override
	public String toString() {
		return "ProductOption{" +
				"mainOptionId=" + mainOptionId +
				", parentOptionId=" + parentOptionId +
				", optionName='" + optionName + '\'' +
				", productId=" + productId +
				", subOptions=" + subOptions +
				'}';
	}

	public List<ProductSubOption> getSubOptions() {
		return subOptions;
	}

	public void setSubOptions(List<ProductSubOption> subOptions) {
		this.subOptions = subOptions;
	}

	public Long getMainOptionId() {
		return mainOptionId;
	}

	public void setMainOptionId(Long mainOptionId) {
		this.mainOptionId = mainOptionId;
	}

	public Long getParentOptionId() {
		return parentOptionId;
	}

	public void setParentOptionId(Long parentOptionId) {
		this.parentOptionId = parentOptionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
