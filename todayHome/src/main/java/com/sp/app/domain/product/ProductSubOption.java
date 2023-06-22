package com.sp.app.domain.product;

public class ProductSubOption {
	private Long subOptionId;
	private Long mainOptionId;
	private String subOptionName;

	public ProductSubOption() {
	}

	public ProductSubOption(Long mainOptionId, String subOptionName) {
		this.mainOptionId = mainOptionId;
		this.subOptionName = subOptionName;
	}

	@Override
	public String toString() {
		return "ProductSubOption{" +
				"optionDetailId=" + subOptionId +
				", OptionDetailName='" + subOptionName + '\'' +
				", mainOptionId=" + mainOptionId +
				'}';
	}

	public Long getMainOptionId() {
		return mainOptionId;
	}

	public void setMainOptionId(Long mainOptionId) {
		this.mainOptionId = mainOptionId;
	}

	public Long getSubOptionId() {
		return subOptionId;
	}

	public void setSubOptionId(Long subOptionId) {
		this.subOptionId = subOptionId;
	}

	public String getSubOptionName() {
		return subOptionName;
	}

	public void setSubOptionName(String subOptionName) {
		this.subOptionName = subOptionName;
	}
}
