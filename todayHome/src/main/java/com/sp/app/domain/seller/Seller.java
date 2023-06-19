package com.sp.app.domain.seller;

public class Seller {
	private Long sellerId;
	private Long memberId;
	private String brandName;
	private String password;
	private String businessNumber;
	private String sellerName;
	private String tel;
	private String email;
	private String representativeName;
	private String presentation;
	private Long accumulatedAmount;
	private int status;
	private String regDate;
	private String adjustmentDate;
	private Long amount;
	private Long adjustmentId;
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRepresentativeName() {
		return representativeName;
	}
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public Long getAccumulatedAmount() {
		return accumulatedAmount;
	}
	public void setAccumulatedAmount(Long accumulatedAmount) {
		this.accumulatedAmount = accumulatedAmount;
	}
	
	
}
