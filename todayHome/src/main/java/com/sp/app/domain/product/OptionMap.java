package com.sp.app.domain.product;

public class OptionMap {
	private String mainOptionName;
	private String subOptionName;
	private Long mainOptionId;
	private Long subOptionId;

	public OptionMap() {
	}

	public OptionMap(String mainOptionName, String subOptionName, Long mainOptionId, Long subOptionId) {
		this.mainOptionName = mainOptionName;
		this.subOptionName = subOptionName;
		this.mainOptionId = mainOptionId;
		this.subOptionId = subOptionId;
	}

	@Override
	public String toString() {
		return "OptionMap{" +
				"mainOptionName='" + mainOptionName + '\'' +
				", subOptionName='" + subOptionName + '\'' +
				", mainOptionId=" + mainOptionId +
				", subOptionId=" + subOptionId +
				'}';
	}

	public String getMainOptionName() {
		return mainOptionName;
	}

	public void setMainOptionName(String mainOptionName) {
		this.mainOptionName = mainOptionName;
	}

	public String getSubOptionName() {
		return subOptionName;
	}

	public void setSubOptionName(String subOptionName) {
		this.subOptionName = subOptionName;
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
}
