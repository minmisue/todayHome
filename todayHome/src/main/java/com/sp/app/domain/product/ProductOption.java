package com.sp.app.domain.product;



public class ProductOption {
	private Long mainOptionId;

	private Long parentOptionId;

	private String optionName;

	private Long productId;

	public ProductOption() {
	}

	@Override
	public String toString() {
		return "ProductOption{" +
				"mainOptionId=" + mainOptionId +
				", parentOptionId=" + parentOptionId +
				", optionName='" + optionName + '\'' +
				", productId=" + productId +
				'}';
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
