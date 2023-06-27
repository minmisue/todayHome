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
		
	public Seller(Long memberId, String brandName, String password, String businessNumber, String sellerName,
			String tel, String email, String representativeName, String presentation) {
		this.memberId = memberId;
		this.brandName = brandName;
		this.password = password;
		this.businessNumber = businessNumber;
		this.sellerName = sellerName;
		this.tel = tel;
		this.email = email;
		this.representativeName = representativeName;
		this.presentation = presentation;
		
	}
	

	public Seller(Long sellerId, String password, String sellerName,
			String tel, String email,String presentation) {
		this.sellerId = sellerId;
		this.password = password;
		this.sellerName = sellerName;
		this.tel = tel;
		this.email = email;
		this.presentation = presentation;
	}

	public Seller(Long sellerId, int status) {
		this.sellerId = sellerId;
		this.status = status;
	}
	public Seller(Long sellerId) {
		this.sellerId = sellerId;
	}
	
	public Seller(int status) {
		this.status =status;
	}
	
	public Seller(Long sellerId,Long memberId,String brandName,String password,String businessNumber,String sellerName,String tel,String email,String representativeName,String presentation, Long accumulatedAmount,String regDate,int status) {

	}
	
	public Seller(Long sellerId, String brandName, String businessNumber, String sellerName, String tel, String email, String representativeName, String presentation,Long accumulatedAmount, String regDate,int status) {

	}
	public Seller(String brandName, String businessNumber, String sellerName, String tel, String email, String representativeName, String presentation,Long accumulatedAmount, String regDate) {

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	
}
