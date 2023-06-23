package com.sp.app.domain.seller;

public class SellerAdjustment {

	private String adjustmentDate;
	private Long amount;
	private Long adjustmentId;
	private Long sellerId;
	
	public SellerAdjustment(){
		
	}
	
	public SellerAdjustment(Long sellerId, Long amount) {
		this.sellerId = sellerId;
		this.amount = amount;
		
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getAdjustmentDate() {
		return adjustmentDate;
	}
	public void setAdjustmentDate(String adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getAdjustmentId() {
		return adjustmentId;
	}
	public void setAdjustmentId(Long adjustmentId) {
		this.adjustmentId = adjustmentId;
	}
}
