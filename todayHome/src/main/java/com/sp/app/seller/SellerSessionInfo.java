package com.sp.app.seller;

public class SellerSessionInfo {
	private Long sellerId;
	private int status;
	private String sellerName;
	private Long adjustmentId;
	

	public Long getAdjustmentId() {
		return adjustmentId;
	}

	public void setAdjustmentId(Long adjustmentId) {
		this.adjustmentId = adjustmentId;
	}

	public SellerSessionInfo(Long sellerId,int status,String sellerName) {
		super();
		this.sellerId=sellerId;
		this.status=status;
		this.sellerName=sellerName;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
