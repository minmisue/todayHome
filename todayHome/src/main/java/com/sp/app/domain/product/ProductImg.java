package com.sp.app.domain.product;

public class ProductImg {
	private String saveName;
	private int sequence;
	private int type;

	@Override
	public String toString() {
		return "ProductImg{" +
				"saveName='" + saveName + '\'' +
				", sequence=" + sequence +
				", type=" + type +
				'}';
	}

	public ProductImg() {
	}

	public ProductImg(String saveName, int type) {
		this.saveName = saveName;
		this.type = type;
	}

	public ProductImg(String saveName, int sequence, int type) {
		this.saveName = saveName;
		this.sequence = sequence;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
