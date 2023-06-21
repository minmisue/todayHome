package com.sp.app.domain.product;

public class OptionMap {
	private String mainOption;
	private String subOption;

	public OptionMap() {
	}

	@Override
	public String toString() {
		return "OptionMap{" +
				"mainOption='" + mainOption + '\'' +
				", subOption='" + subOption + '\'' +
				'}';
	}

	public OptionMap(String mainOption, String subOption) {
		this.mainOption = mainOption;
		this.subOption = subOption;
	}

	public String getMainOption() {
		return mainOption;
	}

	public void setMainOption(String mainOption) {
		this.mainOption = mainOption;
	}

	public String getSubOption() {
		return subOption;
	}

	public void setSubOption(String subOption) {
		this.subOption = subOption;
	}
}
