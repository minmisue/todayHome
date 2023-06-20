package com.sp.app.domain.product;

public class ProductSubOption {
	private Long optionDetailId;
	private Long mainOptionId;
	private String optionDetailName;

	public ProductSubOption() {
	}

	@Override
	public String toString() {
		return "ProductSubOption{" +
				"optionDetailId=" + optionDetailId +
				", OptionDetailName='" + optionDetailName + '\'' +
				", mainOptionId=" + mainOptionId +
				'}';
	}

	public Long getMainOptionId() {
		return mainOptionId;
	}

	public void setMainOptionId(Long mainOptionId) {
		this.mainOptionId = mainOptionId;
	}

	public Long getOptionDetailId() {
		return optionDetailId;
	}

	public void setOptionDetailId(Long optionDetailId) {
		this.optionDetailId = optionDetailId;
	}

	public String getOptionDetailName() {
		return optionDetailName;
	}

	public void setOptionDetailName(String optionDetailName) {
		this.optionDetailName = optionDetailName;
	}
}
