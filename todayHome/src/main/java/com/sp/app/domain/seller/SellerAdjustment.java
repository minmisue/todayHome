package com.sp.app.domain.seller;

public class SellerAdjustment {

	private String adjustmentDate;
	private Long amount;
	private Long adjustmentId;
	private Long sellerId;
	private String brandName;
	private String businessNumber;
	private String sellerName;
	private String tel;
	private String email;
	private String representativeName;
	private String regDate;	
	
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
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
