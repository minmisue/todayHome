package com.sp.app.domain.product;


import java.util.List;

public class ProductOption {
	private String mainOption;
	private List<String> subOption;

	public ProductOption(String mainOption, List<String> subOption) {
		this.mainOption = mainOption;
		this.subOption = subOption;
	}

	public String getMainOption() {
		return mainOption;
	}

	public void setMainOption(String mainOption) {
		this.mainOption = mainOption;
	}

	public List<String> getSubOption() {
		return subOption;
	}

	public void setSubOption(List<String> subOption) {
		this.subOption = subOption;
	}
}
