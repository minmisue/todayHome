package com.sp.app.domain.member;

public class Member {
	private Long memberId;
	private int memberRoleId;
	private String email;
	private String name;
	private String tel;
	private String regDate;
	private String nickName;
	private String password;
	private int enabled;
	private String profileImgName;
	private String info;
	private String postNum;
	private String address1;
	private String address2;
	private int remainPoint;

	


	public Member() {
	}


	public Member(Long memberId, String email, String nickName, String password) {
		this.memberId = memberId;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member{" +
				"memberId=" + memberId +
				", memberRoleId=" + memberRoleId +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", tel='" + tel + '\'' +
				", regDate='" + regDate + '\'' +
				", nickName='" + nickName + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", profileImgName='" + profileImgName + '\'' +
				", info='" + info + '\'' +
				", postNum='" + postNum + '\'' +
				", address1='" + address1 + '\'' +
				", address2='" + address2 + '\'' +
				", remainPoint=" + remainPoint +
				'}';
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public int getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getRemainPoint() {
		return remainPoint;
	}

	public void setRemainPoint(int remainPoint) {
		this.remainPoint = remainPoint;
	}
}
