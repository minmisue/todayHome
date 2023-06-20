package com.sp.app.domain.product;

public class ProductSubOption {
	private Long optionDetailId;
	private Long mainOptionId;
	private String OptionDetailName;

	public ProductSubOption() {
	}

	@Override
	public String toString() {
		return "ProductSubOption{" +
				"optionDetailId=" + optionDetailId +
				", mainOptionId=" + mainOptionId +
				", OptionDetailName='" + OptionDetailName + '\'' +
				'}';
	}

	public Long getOptionDetailId() {
		return optionDetailId;
	}

	public void setOptionDetailId(Long optionDetailId) {
		this.optionDetailId = optionDetailId;
	}

	public Long getMainOptionId() {
		return mainOptionId;
	}

	public void setMainOptionId(Long mainOptionId) {
		this.mainOptionId = mainOptionId;
	}

	public String getOptionDetailName() {
		return OptionDetailName;
	}

	public void setOptionDetailName(String optionDetailName) {
		OptionDetailName = optionDetailName;
	}
}
